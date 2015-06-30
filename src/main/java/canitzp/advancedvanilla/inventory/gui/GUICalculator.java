package canitzp.advancedvanilla.inventory.gui;


import canitzp.advancedvanilla.specials.GUIButton;
import canitzp.advancedvanilla.util.AVStrings;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GUICalculator extends GuiContainer{

    public FontRenderer calcString;
    public int  mathOp;
    public float text, eingabe1;
    public boolean delNextTime;
    public String ausgabe = Float.toString(text);

    public GUICalculator(Container container) {
        super(container);
        this.xSize = 92;
        this.ySize = 178;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(AVStrings.textureGui + "guiCalculator.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize + 1, this.ySize + 1);
    }
    @Override
    public void drawGuiContainerForegroundLayer(int x, int y) {

        this.calcString.drawString(ausgabe, 85-this.calcString.getStringWidth(ausgabe), 11, 0);
    }

    @Override
    public void initGui() {
        super.initGui();

        this.buttonList.add(new GUIButton(0, guiLeft + 4, guiTop + 136, 16, 16, "0", "0", 1));
        this.buttonList.add(new GUIButton(1, guiLeft+4, guiTop+113, 16, 16, "1", "1", 1));
        this.buttonList.add(new GUIButton(2, guiLeft+27, guiTop+113, 16, 16, "2", "2", 1));
        this.buttonList.add(new GUIButton(3, guiLeft+50, guiTop+113, 16, 16, "3", "3", 1));
        this.buttonList.add(new GUIButton(4, guiLeft+4, guiTop+90, 16, 16, "4", "4", 1));
        this.buttonList.add(new GUIButton(5, guiLeft+27, guiTop+90, 16, 16, "5", "5", 1));
        this.buttonList.add(new GUIButton(6, guiLeft+50, guiTop+90, 16, 16, "6", "6", 1));
        this.buttonList.add(new GUIButton(7, guiLeft+4, guiTop+67, 16, 16, "7", "7", 1));
        this.buttonList.add(new GUIButton(8, guiLeft+27, guiTop+67, 16, 16, "8", "8", 1));
        this.buttonList.add(new GUIButton(9, guiLeft+50, guiTop+67, 16, 16, "9", "9", 1));

        this.buttonList.add(new GUIButton(10, guiLeft+73, guiTop+113, 16, 16, "+", "+", 1));
        this.buttonList.add(new GUIButton(11, guiLeft + 73, guiTop + 136, 16, 16, "=", "=", 1));
        this.buttonList.add(new GUIButton(12, guiLeft+73, guiTop+90, 16, 16, "-", "-", 1));
        this.buttonList.add(new GUIButton(13, guiLeft+73, guiTop+67, 16, 16, "*", "*", 1));
        this.buttonList.add(new GUIButton(14, guiLeft+73, guiTop+44, 16, 16, "/", "/", 1));

        calcString = this.mc.fontRenderer;


    }

    @Override
    public void actionPerformed(GuiButton button) {
       if(button.id >= 0 && button.id <= 9){
           if(!delNextTime) {
               String eingabe = Float.toString(text) + button.id;
               text = Float.parseFloat(eingabe);
               ausgabe = Float.toString(text);
           }
           else{
               text = button.id;
               ausgabe = Float.toString(text);
           }

       }
        if(button.id == 10){
            mathOp = 10;
            eingabe1 = text;
            text = 0;
            ausgabe = Float.toString(text);

        }

        if(button.id == 11){
            if(eingabe1 != 0){
                if(mathOp == 10)text = eingabe1 + text;
                if(mathOp == 12)text = eingabe1 - text;
                if(mathOp == 13)text = eingabe1 * text;
                if(mathOp == 14){
                    text = eingabe1 / text;
                    ausgabe = Float.toString(text);
                }
                eingabe1 = 0;
                delNextTime = true;
            }
        }


        if(button.id == 12){
            mathOp = 12;
            eingabe1 = text;
            text = 0;
            ausgabe = Float.toString(text);
        }

        if(button.id == 13){
            mathOp = 13;
            eingabe1 = text;
            text = 0;
            ausgabe = Float.toString(text);
        }
        if(button.id == 14){
            mathOp = 14;
            eingabe1 = text;
            text = 0;
            ausgabe = Float.toString(text);
        }
    }
}
