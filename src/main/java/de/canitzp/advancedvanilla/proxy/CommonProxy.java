package de.canitzp.advancedvanilla.proxy;

import de.canitzp.advancedvanilla.AdvancedVanilla;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author canitzp
 */
public class CommonProxy{

    public SimpleNetworkWrapper wrapper;

    public void preInit(){
        wrapper = new SimpleNetworkWrapper(AdvancedVanilla.MODID);
        wrapper.registerMessage(PacketOpenGui.Handler.class, PacketOpenGui.class, 0, Side.SERVER);
        wrapper.registerMessage(PacketRecipeChanger.Handler.class, PacketRecipeChanger.class, 1, Side.SERVER);
        wrapper.registerMessage(PacketRecipeChangerFeedback.Handler.class, PacketRecipeChangerFeedback.class, 2, Side.CLIENT);

        NetworkRegistry.INSTANCE.registerGuiHandler(AdvancedVanilla.instance, new GuiHandler());
    }

}
