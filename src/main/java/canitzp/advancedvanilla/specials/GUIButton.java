package canitzp.advancedvanilla.specials;


import canitzp.advancedvanilla.util.AVStrings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GUIButton extends GuiButton{

    public int width;
    public int height;
    public int xPosition;
    public int yPosition;
    public String displayString;
    public int id;
    public boolean enabled;
    public boolean visible;
    public String name, dname;
    public int buttonType;
    public String text;

    public GUIButton(int ID, int x, int y, String dname, String name, int buttonType) {
        this(ID, x, y, 157, 10, dname, name, buttonType);
    }
    public GUIButton(int ID, int x, int y, int width, int height, String dname, String name, int buttonType) {
        super(ID, x, y, width, height, dname);
        this.width = 157;
        this.height = 10;
        this.enabled = true;
        this.visible = true;
        this.id = ID;
        this.xPosition = x;
        this.yPosition = y;
        this.width = width;
        this.height = height;
        this.displayString = dname;
        this.name = name;
        this.dname = dname;
        this.buttonType = buttonType;


    }

    protected static final ResourceLocation buttonTextures = new ResourceLocation(AVStrings.textureGui + "guiButtons.png");




    public void func_146113_a(SoundHandler sh) {}


    public void drawButton(Minecraft mc, int x, int y) {
        if (this.visible && buttonType == 1) {
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_146123_n = x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height;
            int k = this.getHoverState(this.field_146123_n);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, k * 16, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 157 - this.width / 2, k * 16, this.width / 2, this.height);
            this.mouseDragged(mc, x, y);
            int l = 14737632;

            if (packedFGColour != 0) {
                l = packedFGColour;
            } else if (!this.enabled) {
                l = 10526880;
            } else if (this.field_146123_n) {
                l = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
    }
}
