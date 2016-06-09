package de.canitzp.advancedvanilla.recipechanger;

import de.canitzp.advancedvanilla.AdvancedVanilla;
import de.canitzp.advancedvanilla.api.AdvancedVanillaApi;
import de.canitzp.advancedvanilla.api.IRecipeHandler;
import de.canitzp.advancedvanilla.proxy.PacketRecipeChanger;
import de.canitzp.advancedvanilla.util.AVRecipe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.network.ForgeNetworkHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author canitzp
 */
public class ShapedOreRecipeHandler implements IRecipeHandler{

    private static List<RecipeManager> shapedRecipe = new ArrayList<>();
    private static List<RecipeManager> shapelessRecipe = new ArrayList<>();

    private static final String SHAPED = TextFormatting.RED + "Shaped";
    private static final String SHAPELESS = TextFormatting.BLUE + "Shapeless";
    private boolean isShaped = true;

    private List<RecipeManager> getRecipeList(){
        return isShaped ? shapedRecipe : shapelessRecipe;
    }

    @Override
    public AdvancedVanillaApi.SaveFiles getSaveFile(){
        return isShaped ? AdvancedVanillaApi.SaveFiles.SHAPED_ORE : AdvancedVanillaApi.SaveFiles.SHAPELESS_ORE;
    }

    @Override
    public List<Slot> getSlots(IInventory inventory, Container container, EntityPlayer player){
        this.isShaped = true;
        List<Slot> slots = new ArrayList<>();
        slots.add(new Slot(inventory, 9, 124, 35));
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                slots.add(new Slot(inventory, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }
        for(int k = 0; k < 3; ++k){
            for(int i1 = 0; i1 < 9; ++i1){
                slots.add(new Slot(player.inventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }
        for(int l = 0; l < 9; ++l){
            slots.add(new Slot(player.inventory, l, 8 + l * 18, 142));
        }
        return slots;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ResourceLocation getResourceLocation(GuiContainer gui, EntityPlayer player){
        return new ResourceLocation("textures/gui/container/crafting_table.png");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initGui(GuiContainer gui, EntityPlayer player, List<RecipeHandler.RecipeHandlerGui.TabButton> buttons){
        buttons.add(new RecipeHandler.RecipeHandlerGui.TabButton(SHAPED, -60, -66){
            @Override
            public void onMouseClick(int guiLeft, int guiTop, int mouseX, int mouseY, int mouseButton){
                AdvancedVanilla.proxy.wrapper.sendToServer(new PacketRecipeChanger(player, PacketRecipeChanger.Type.CUSTOM));
                if(this.getText().equals(SHAPED)){
                    this.setText(SHAPELESS);
                } else {
                    this.setText(SHAPED);
                }
            }
        });
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getGuiXSize(GuiContainer gui, EntityPlayer player){
        return 176;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getGuiYSize(GuiContainer gui, EntityPlayer player){
        return 166;
    }

    @Override
    public void onSaveRecipe(IInventory inventory, Container container, EntityPlayer player){
        if(!addRecipe(new RecipeManager(inventory.getStackInSlot(9) != null ? inventory.getStackInSlot(9).copy() : null, inventory))){
            RecipeHandler.setFeedbackMessage(player, RecipeHandler.STATUS_ERROR);
        } else {
            RecipeHandler.setFeedbackMessage(player, RecipeHandler.STATUS_SUCCESS);
        }
    }

    @Override
    public void onDeleteRecipe(IInventory inventory, Container container, EntityPlayer player){
        if(!removeRecipe(new RecipeManager(inventory.getStackInSlot(9) != null ? inventory.getStackInSlot(9).copy() : null, inventory))){
            RecipeHandler.setFeedbackMessage(player, RecipeHandler.STATUS_ERROR);
        } else {
            RecipeHandler.setFeedbackMessage(player, RecipeHandler.STATUS_SUCCESS);
        }
    }

    @Override
    public void handlePacket(IInventory inventory, Container container, EntityPlayer player, PacketRecipeChanger.Type type){
        if(type.equals(PacketRecipeChanger.Type.CUSTOM)){
            this.isShaped = !this.isShaped;
            FileLoader.read(this);
        }
    }

    @Override
    public void resetRecipes(){
        getRecipeList().clear();
    }

    @Override
    public List<Pair<String, String>> saveToFile(){
        List<Pair<String, String>> rec = new ArrayList<>();
        for(RecipeManager recipe : getRecipeList()){
            String id = RecipeHandler.getStringFromStack(recipe.output.copy(), false);
            String values = "";
            for(Object stack : recipe.input.clone()){
                values += RecipeHandler.getStringFromStack(stack, false); //TODO option to enable oreDict for specific stack
            }
            rec.add(Pair.of(id, values));
        }
        return rec;
    }

    @Override
    public void readFromFile(String identifier, String recipeLine){
        Object output = RecipeHandler.getStackFromString(identifier);
        Object[] input = new Object[recipeLine.split("]").length];
        String[] split = recipeLine.split("]");
        for(int i = 0; i < split.length; i++){
            input[i] = RecipeHandler.getStackFromString(split[i]);
        }
        if(output != null && output instanceof ItemStack){
            addRecipe(new RecipeManager(input.clone(), ((ItemStack) output).copy()));
        }
    }

    public boolean addRecipe(RecipeManager recipe){
        if(recipe.output == null || recipe.isInputEmpty()){
            return false;
        }
        for(RecipeManager handler : getRecipeList()){
            if(handler.equals(recipe)){
                return false;
            }
        }
        getRecipeList().add(recipe);
        if(isShaped){
            addShapedRecipe(recipe.output.copy(), recipe.input.clone());
        } else {
            addShapelessRecipe(recipe.output.copy(), recipe.input.clone());
        }


        return true;
    }

    public boolean removeRecipe(RecipeManager recipe){
        for(int i = 0; i < getRecipeList().size(); i++){
            if(getRecipeList().get(i).equals(recipe)){
                getRecipeList().remove(i);
                return true;
            }
        }
        return false;
    }

    private static void addShapedRecipe(ItemStack output, Object... input){
        List<Object> objects = new ArrayList<>();
        String firstLine = "", secondLine = "", thirdLine = "";

        if(input[0] != null){
            firstLine += "A";
            objects.add('A');
            objects.add(input[0]);
        } else {
            firstLine += " ";
        }
        if(input[1] != null){
            firstLine += "B";
            objects.add('B');
            objects.add(input[1]);
        } else {
            firstLine += " ";
        }
        if(input[2] != null){
            firstLine += "C";
            objects.add('C');
            objects.add(input[2]);
        } else {
            firstLine += " ";
        }

        if(input[3] != null){
            secondLine += "D";
            objects.add('D');
            objects.add(input[3]);
        } else {
            secondLine += " ";
        }
        if(input[4] != null){
            secondLine += "E";
            objects.add('E');
            objects.add(input[4]);
        } else {
            secondLine += " ";
        }
        if(input[5] != null){
            secondLine += "F";
            objects.add('F');
            objects.add(input[5]);
        } else {
            secondLine += " ";
        }

        if(input[6] != null){
            thirdLine += "G";
            objects.add('G');
            objects.add(input[6]);
        } else {
            thirdLine += " ";
        }
        if(input[7] != null){
            thirdLine += "H";
            objects.add('H');
            objects.add(input[7]);
        } else {
            thirdLine += " ";
        }
        if(input[8] != null){
            thirdLine += "I";
            objects.add('I');
            objects.add(input[8]);
        } else {
            thirdLine += " ";
        }

        List<Object> objList = new ArrayList<>();
        objList.add(firstLine);
        objList.add(secondLine);
        objList.add(thirdLine);
        objList.addAll(objects);

        GameRegistry.addRecipe(new ShapedOreRecipe(output, objList.toArray()));
    }

    public static void addShapelessRecipe(ItemStack output, Object... input){
        List<Object> newInput = new ArrayList<>();
        for(Object o : input){
            if(o != null){
                if(o instanceof ItemStack || o instanceof String){
                    newInput.add(o);
                }
            }
        }
        GameRegistry.addRecipe(new ShapelessOreRecipe(output, newInput.toArray()));
    }

    private static class RecipeManager{
        private Object[] input;
        private ItemStack output;

        private RecipeManager(ItemStack result, IInventory input){
            this.input = new ItemStack[9];
            for(int i = 0; i < 9; i++){
                this.input[i] = input.getStackInSlot(i);
            }
            this.output = result;
        }

        private RecipeManager(Object[] input, ItemStack output){
            this.input = input.clone();
            this.output = output.copy();
        }

        @Override
        public boolean equals(Object obj){
            if(obj != null && obj instanceof RecipeManager){
                RecipeManager recipeHandler = (RecipeManager) obj;
                if(ItemStack.areItemStacksEqual(this.output, recipeHandler.output)){
                    for(int i = 0; i < this.input.length; i++){
                        if(!ItemStack.areItemStacksEqual(RecipeHandler.getStackFromObject(input[i]), RecipeHandler.getStackFromObject(recipeHandler.input[i]))){
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        private boolean isInputEmpty(){
            for(Object stack : this.input){
                if(stack != null){
                    return false;
                }
            }
            return true;
        }

        @Override
        public String toString(){
            return "Output:[" + this.output.toString() + "] Input:" + Arrays.toString(this.input);
        }
    }
}

