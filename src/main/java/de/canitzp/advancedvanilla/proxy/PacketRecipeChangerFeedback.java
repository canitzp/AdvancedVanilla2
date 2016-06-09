package de.canitzp.advancedvanilla.proxy;

import de.canitzp.advancedvanilla.recipechanger.RecipeHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * @author canitzp
 */
public class PacketRecipeChangerFeedback implements IMessage{

    private int playerID, worldID;
    private String message;

    public PacketRecipeChangerFeedback(){}

    public PacketRecipeChangerFeedback(String message, EntityPlayer player){
        this.message = message;
        this.playerID = player.getEntityId();
        this.worldID = player.worldObj.provider.getDimension();
    }

    @Override
    public void fromBytes(ByteBuf buf){
        this.worldID = buf.readInt();
        this.playerID = buf.readInt();
        this.message = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(this.worldID);
        buf.writeInt(this.playerID);
        ByteBufUtils.writeUTF8String(buf, this.message);
    }

    public static class Handler implements IMessageHandler<PacketRecipeChangerFeedback, IMessage>{
        @Override
        public IMessage onMessage(PacketRecipeChangerFeedback message, MessageContext ctx){
            GuiScreen gui = Minecraft.getMinecraft().currentScreen;
            if(gui instanceof RecipeHandler.RecipeHandlerGui){
                ((RecipeHandler.RecipeHandlerGui) gui).changeStatus(message.message);
            }
            return null;
        }
    }
}
