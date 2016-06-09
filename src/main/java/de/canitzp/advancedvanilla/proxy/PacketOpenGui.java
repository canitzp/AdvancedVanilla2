package de.canitzp.advancedvanilla.proxy;

import de.canitzp.advancedvanilla.AdvancedVanilla;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * @author canitzp
 */
public class PacketOpenGui implements IMessage{

    private int guiID, worldID, playerID;
    private BlockPos pos;

    public PacketOpenGui(){}

    public PacketOpenGui(int guiID, EntityPlayer player, BlockPos pos){
        this.guiID = guiID;
        this.playerID = player.getEntityId();
        this.pos = pos;
        this.worldID = player.worldObj.provider.getDimension();
    }

    @Override
    public void fromBytes(ByteBuf buf){
        PacketBuffer buffer = new PacketBuffer(buf);
        this.guiID = buffer.readInt();
        this.worldID = buffer.readInt();
        this.playerID = buffer.readInt();
        this.pos = buffer.readBlockPos();
    }

    @Override
    public void toBytes(ByteBuf buf){
        PacketBuffer buffer = new PacketBuffer(buf);
        buffer.writeInt(this.guiID);
        buffer.writeInt(this.worldID);
        buffer.writeInt(this.playerID);
        buffer.writeBlockPos(this.pos);
    }

    public static class Handler implements IMessageHandler<PacketOpenGui, IMessage>{
        @Override
        public IMessage onMessage(PacketOpenGui message, MessageContext ctx){
            World world = DimensionManager.getWorld(message.worldID);
            if(world != null){
                EntityPlayer player = (EntityPlayer) world.getEntityByID(message.playerID);
                if(player != null){
                    player.openGui(AdvancedVanilla.instance, message.guiID, world, message.pos.getX(), message.pos.getY(), message.pos.getZ());
                }
            }
            return null;
        }
    }
}
