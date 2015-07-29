package canitzp.AdvancedLib.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRenderer implements IItemRenderer{

    private String resource;
    private ModelBase model;
    private Float equippedScale = 1F;
    private Float equippedFirstScale = 1F;
    private Float inventoryScale = 1F;
    private Float equippedX = 0F;
    private Float equippedY = 0F;
    private Float equippedZ = 0F;

    public void ItemRenderer(String resource, ModelBase model){
        this.resource = resource;
        this.model = model;
    }

    private ItemRenderer setEquippedScale(Float scale){
        this.equippedScale = scale;
        return this;
    }
    private ItemRenderer setEquippedFirstScale(Float scale){
        this.equippedFirstScale = scale;
        return this;
    }
    private ItemRenderer setInventoryScale(Float scale){
        this.inventoryScale = scale;
        return this;
    }

    private ItemRenderer addEquippedTranslation(Float addX, Float addY, Float addZ){
        this.equippedX = this.equippedX + addX;
        this.equippedY = this.equippedY + addY;
        this.equippedZ = this.equippedZ + addZ;
        return this;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {

            case EQUIPPED:
                GL11.glPushMatrix();
                GL11.glTranslatef(equippedX, equippedY, equippedZ);
                GL11.glRotatef(180F, 0F, 1F, 0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(resource));
                GL11.glRotatef(-180F, 0F, -1F, 0F);

                GL11.glPushMatrix();
                GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(200F, 0.0F, 1.0F, 0.0F);
                GL11.glScaled(equippedScale, equippedScale, equippedScale);
                this.model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                break;


            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                GL11.glTranslatef(0.5F, 2F, 0.5F);
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(resource));
                GL11.glRotatef(-180F, 0.0F, -1.0F, 0.0F);

                GL11.glPushMatrix();
                GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(60F, 0.0F, 1.0F, 0.0F);
                GL11.glScaled(equippedFirstScale, equippedFirstScale, equippedFirstScale);
                this.model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                break;


            case INVENTORY:
                GL11.glPushMatrix();
                GL11.glTranslatef(0.0F, 0.6F, 0.0F);


                GL11.glRotatef(180F, 0F, 1F, 0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(resource));
                GL11.glRotatef(-180F, 0F, -1F, 0F);


                GL11.glPushMatrix();
                GL11.glRotatef(180F, 1F, 0.0F, 0.0F);
                GL11.glScaled(inventoryScale, inventoryScale, inventoryScale);
                this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                break;


            default:
                break;
        }
    }
}
