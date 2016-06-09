package de.canitzp.advancedvanilla.api;

import de.canitzp.advancedvanilla.proxy.PacketRecipeChanger;
import de.canitzp.advancedvanilla.recipechanger.RecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * @author canitzp
 */
public interface IRecipeHandler{

    AdvancedVanillaApi.SaveFiles getSaveFile();

    default void initContainer(Container container, EntityPlayer player){}

    default List<Slot> getSlots(IInventory inventory, Container container, EntityPlayer player){return null;}

    default void onSaveRecipe(IInventory inventory, Container container, EntityPlayer player){}

    default void onDeleteRecipe(IInventory inventory, Container container, EntityPlayer player){}

    default void onReloadRecipes(IInventory inventory, Container container, EntityPlayer player){}

    default void handlePacket(IInventory inventory, Container container, EntityPlayer player, PacketRecipeChanger.Type type){}

    void resetRecipes();

    default List<Pair<String, String>> saveToFile(){return null;}

    default void readFromFile(String identifier, String recipeLine){}

    @SideOnly(Side.CLIENT)
    default void drawGuiContainerBackgroundLayer(GuiContainer gui, EntityPlayer player, float partialTicks, int mouseX, int mouseY){}

    @SideOnly(Side.CLIENT)
    default void mouseClick(GuiContainer gui, EntityPlayer player, int mouseX, int mouseY, int mouseButton){}

    @SideOnly(Side.CLIENT)
    ResourceLocation getResourceLocation(GuiContainer gui, EntityPlayer player);

    @SideOnly(Side.CLIENT)
    int getGuiXSize(GuiContainer gui, EntityPlayer player);

    @SideOnly(Side.CLIENT)
    int getGuiYSize(GuiContainer gui, EntityPlayer player);

    @SideOnly(Side.CLIENT)
    default void initGui(GuiContainer gui, EntityPlayer player, List<RecipeHandler.RecipeHandlerGui.TabButton> buttons){}

}
