package canitzp.advancedvanilla.inventory.gui;

import canitzp.advancedvanilla.util.AVStrings;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


public class GUIAtomicSmelter extends GuiContainer {
    public GUIAtomicSmelter(Container p_i1072_1_) {
        super(p_i1072_1_);
        this.xSize = 175;
        this.ySize = 159;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(AVStrings.textureGui + "guiAtomicSmelter.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize + 1, this.ySize + 1);
    }


}
