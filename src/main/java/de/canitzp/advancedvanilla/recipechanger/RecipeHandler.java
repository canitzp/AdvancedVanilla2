package de.canitzp.advancedvanilla.recipechanger;

import de.canitzp.advancedvanilla.AdvancedVanilla;
import de.canitzp.advancedvanilla.api.AdvancedVanillaApi;
import de.canitzp.advancedvanilla.api.IRecipeHandler;
import de.canitzp.advancedvanilla.proxy.PacketRecipeChanger;
import de.canitzp.advancedvanilla.proxy.PacketRecipeChangerFeedback;
import de.canitzp.advancedvanilla.util.AVItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author canitzp
 */
public class RecipeHandler extends Container{

    public static String STATUS_OK = TextFormatting.DARK_GRAY + "OK";
    public static String STATUS_ERROR = TextFormatting.RED + "Error";
    public static String STATUS_SUCCESS = TextFormatting.GREEN + "Success";

    private EntityPlayer player;
    private IRecipeHandler handler;
    private IInventory iInventory = new InventoryBasic("RecipeChangerInventory", false, 20);
    public static void postInit(){
        AdvancedVanillaApi.addBlockListener(Blocks.CRAFTING_TABLE, new ShapedOreRecipeHandler());
    }
    public RecipeHandler(IRecipeHandler handler, EntityPlayer player){
        this.player = player;
        this.handler = handler;
        handler.resetRecipes();
        FileLoader.read(handler);
        handler.initContainer(this, player);
        for(Slot slot : handler.getSlots(this.iInventory, this, this.player)){
            this.addSlotToContainer(slot);
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn){
        return playerIn.isCreative();
    }
    public void handlePacket(PacketRecipeChanger.Type type){
        switch(type){
            case SAVE:{
                this.handler.onSaveRecipe(this.iInventory, this, this.player);
                FileLoader.save(this.handler);
                return;
            }
            case DELETE:{
                this.handler.onDeleteRecipe(this.iInventory, this, this.player);
                FileLoader.save(this.handler);
                return;
            }
            case RELOAD:{
                this.handler.onReloadRecipes(this.iInventory, this, this.player);
                return;
            }
        }
        this.handler.handlePacket(this.iInventory, this, this.player, type);
    }

    public static String getStringFromStack(Object stack, boolean oreDict){
        if(stack != null){
            if(stack instanceof ItemStack){
                int[] oreDictIDs = OreDictionary.getOreIDs((ItemStack) stack);
                if(oreDictIDs.length > 0 && oreDict){
                    return "[" + OreDictionary.getOreName(oreDictIDs[0]) + ",1]";
                } else {
                    return "[" + ForgeRegistries.ITEMS.getKey(((ItemStack) stack).getItem()) + "," + ((ItemStack) stack).stackSize + "," + ((ItemStack) stack).getMetadata() + "]";
                }
            } else if(stack instanceof String){
                return "[" + stack + "]";
            }
        }
        return "[null]";
    }

    public static Object getStackFromString(String string){
        string = string.replace("[", "").replace("]", "");
        String[] parts = string.split(",");
        if(parts.length == 3){
            Item item = AVItem.getItemFromName(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            int meta = Integer.parseInt(parts[2]);
            return item != null ? new ItemStack(item, amount, meta) : null;
        } else if(parts.length == 2 || (parts.length == 1 && !parts[0].equals("null"))){
            return parts[0];
        }
        return null;
    }

    @SideOnly(Side.CLIENT)
    public static void setFeedbackMessage(EntityPlayer player, String message){
        if(player instanceof EntityPlayerMP){
            AdvancedVanilla.proxy.wrapper.sendTo(new PacketRecipeChangerFeedback(message, player), (EntityPlayerMP) player);
        }
    }

    public static ItemStack getStackFromObject(Object o){
        return o == null ? null : o instanceof ItemStack ? (ItemStack) o : OreDictionary.getOres((String) o).size() > 0 ? OreDictionary.getOres((String) o).get(0) : null;
    }

    @SideOnly(Side.CLIENT)
    public static class RecipeHandlerGui extends GuiContainer{
        private EntityPlayer player;
        private IRecipeHandler handler;
        private ResourceLocation guiLocation;
        private List<TabButton> buttons = new ArrayList<>();
        private TabButton feedbackTab;
        public RecipeHandlerGui(Container container, IRecipeHandler handler, EntityPlayer player){
            super(container);
            this.player = player;
            this.handler = handler;
            this.guiLocation = handler.getResourceLocation(this, player);
            this.xSize = handler.getGuiXSize(this, player);
            this.ySize = handler.getGuiYSize(this, player);
            buttons.add(new TabButton("Save", -60, -2){
                @Override
                public void onMouseClick(int guiLeft, int guiTop, int mouseX, int mouseY, int mouseButton){
                    AdvancedVanilla.proxy.wrapper.sendToServer(new PacketRecipeChanger(player, PacketRecipeChanger.Type.SAVE));
                }
            });
            buttons.add(new TabButton("Delete", -60, -18){
                @Override
                public void onMouseClick(int guiLeft, int guiTop, int mouseX, int mouseY, int mouseButton){
                    AdvancedVanilla.proxy.wrapper.sendToServer(new PacketRecipeChanger(player, PacketRecipeChanger.Type.DELETE));
                }
            });
            buttons.add(new TabButton("Reload", -60, -34){
                @Override
                public void onMouseClick(int guiLeft, int guiTop, int mouseX, int mouseY, int mouseButton){
                    AdvancedVanilla.proxy.wrapper.sendToServer(new PacketRecipeChanger(player, PacketRecipeChanger.Type.RELOAD));
                }
            });
            buttons.add(this.feedbackTab = new TabButton(STATUS_OK, -60, -50){
                @Override
                public void onMouseClick(int guiLeft, int guiTop, int mouseX, int mouseY, int mouseButton){
                    feedbackTab.setText(STATUS_OK);
                }
            });
            handler.initGui(this, player, this.buttons);
        }
        @Override
        protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            for(TabButton button : this.buttons){
                button.draw(this.mc, this.guiLeft, this.guiTop);
            }
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.getTextureManager().bindTexture(this.guiLocation);
            this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
            handler.drawGuiContainerBackgroundLayer(this, this.player, partialTicks, mouseX, mouseY);
        }

        @Override
        protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException{
            for(TabButton button : this.buttons){
                if(button.mouseClick(this.guiLeft, this.guiTop, mouseX, mouseY)){
                    button.onMouseClick(this.guiLeft, this.guiTop, mouseX, mouseY, mouseButton);
                }
            }
            handler.mouseClick(this, this.player, mouseX, mouseY, mouseButton);
            super.mouseClicked(mouseX, mouseY, mouseButton);
        }

        public void changeStatus(String message){
            this.feedbackTab.setText(message);
        }

        public static abstract class TabButton extends Gui{
            private ResourceLocation tabLocation = new ResourceLocation(AdvancedVanilla.MODID, "textures/gui/tabs.png");
            private int x, y;
            private String buttonText;
            public TabButton(String buttonText, int x, int y){
                this.buttonText = buttonText;
                this.x = x;
                this.y = y;
            }
            public void draw(Minecraft minecraft, int guiLeft, int guiTop){
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                minecraft.getTextureManager().bindTexture(this.tabLocation);
                this.drawTexturedModalRect(guiLeft + this.x, guiTop - this.y, 0, 0, -this.x+3, 15);
                minecraft.fontRendererObj.drawString(this.buttonText, guiLeft + this.x + 4, guiTop - this.y - (minecraft.fontRendererObj.FONT_HEIGHT / 2) + 8, 0x0);
            }
            public boolean mouseClick(int guiLeft, int guiTop, int mouseX, int mouseY){
                return guiLeft + this.x <= mouseX && guiLeft + this.x + (-this.x + 3) >= mouseX && guiTop - this.y <= mouseY && guiTop - this.y + 15 >= mouseY;
            }
            public abstract void onMouseClick(int guiLeft, int guiTop, int mouseX, int mouseY, int mouseButton);
            public void setText(String text){
                this.buttonText = text;
            }
            public String getText(){
                return buttonText;
            }
        }
    }
}