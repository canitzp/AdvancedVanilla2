package de.canitzp.advancedvanilla.proxy;

import de.canitzp.advancedvanilla.recipechanger.RecipeHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * @author canitzp
 */
public class PacketRecipeChanger implements IMessage{

    private int playerID, worldID;
    private Type type;

    public PacketRecipeChanger(){}

    public PacketRecipeChanger(EntityPlayer player, Type type){
        this.playerID = player.getEntityId();
        this.type = type;
        this.worldID = player.worldObj.provider.getDimension();
    }

    @Override
    public void fromBytes(ByteBuf buf){
        this.worldID = buf.readInt();
        this.playerID = buf.readInt();
        this.type = Type.values()[buf.readInt()];
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(this.worldID);
        buf.writeInt(this.playerID);
        buf.writeInt(this.type.ordinal());
    }

    public static class Handler implements IMessageHandler<PacketRecipeChanger, IMessage>{
        @Override
        public IMessage onMessage(PacketRecipeChanger message, MessageContext ctx){
            World world = DimensionManager.getWorld(message.worldID);
            if(world != null){
                EntityPlayer player = (EntityPlayer) world.getEntityByID(message.playerID);
                if(player != null){
                    Container container = player.openContainer;
                    if(container instanceof RecipeHandler){
                        ((RecipeHandler) container).handlePacket(message.type);
                    }
                }
            }
            return null;
        }
    }

    public enum Type{
        SAVE,
        DELETE,
        RELOAD,
        CUSTOM
    }
}
