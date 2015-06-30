package canitzp.advancedvanilla.inventory;


import canitzp.advancedvanilla.inventory.container.ContainerAtomicSmelter;
import canitzp.advancedvanilla.inventory.container.ContainerCalculator;
import canitzp.advancedvanilla.inventory.gui.GUIAtomicSmelter;
import canitzp.advancedvanilla.inventory.gui.GUICalculator;
import canitzp.advancedvanilla.tileEntity.TileEntityAtomicSmelter;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            return new ContainerCalculator();
        }
        if (ID == 1) {
            TileEntityAtomicSmelter te = (TileEntityAtomicSmelter) world.getTileEntity(x, y, z);
            return new ContainerAtomicSmelter(6, true, player.inventory, te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            return new GUICalculator(new ContainerCalculator());
        }
        if (ID == 1) {
            TileEntityAtomicSmelter te = (TileEntityAtomicSmelter) world.getTileEntity(x, y, z);
            return new GUIAtomicSmelter(new ContainerAtomicSmelter(6, true, player.inventory, te));
        }
        return null;
    }
}
