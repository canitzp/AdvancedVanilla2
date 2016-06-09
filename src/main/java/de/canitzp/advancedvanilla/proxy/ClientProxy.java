package de.canitzp.advancedvanilla.proxy;

import de.canitzp.advancedvanilla.api.AdvancedVanillaApi;
import de.canitzp.advancedvanilla.api.IBlockListener;
import de.canitzp.advancedvanilla.api.IRecipeHandler;
import de.canitzp.advancedvanilla.recipechanger.RecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author canitzp
 */
public class ClientProxy extends CommonProxy{

    private Map<Integer, KeyBinding> keys = new HashMap<>();
    public static final int KEY_OPENRECIPECHANGER = 0;

    @Override
    public void preInit(){
        keys.put(KEY_OPENRECIPECHANGER, new KeyBinding("To open the Recipe changer", Keyboard.KEY_R, "av.key.recipechanger"));

        for(KeyBinding key : keys.values()){
            ClientRegistry.registerKeyBinding(key);
        }

        MinecraftForge.EVENT_BUS.register(this);
        super.preInit();
    }

    @SubscribeEvent
    public void keyEvent(InputEvent.KeyInputEvent event){
        for(Map.Entry<Integer, KeyBinding> entry : keys.entrySet()){
            switch(entry.getKey()){
                case KEY_OPENRECIPECHANGER:{
                    if(entry.getValue().isPressed()){
                        Minecraft mc = Minecraft.getMinecraft();
                        if(mc.objectMouseOver.typeOfHit.equals(RayTraceResult.Type.BLOCK)){
                            for(IBlockListener listener : AdvancedVanillaApi.blockListener){
                                IRecipeHandler handler = listener.getHandlerFromBlock(mc.theWorld, mc.objectMouseOver.getBlockPos(), mc.thePlayer);
                                if(handler != null){
                                    wrapper.sendToServer(new PacketOpenGui(GuiHandler.RECIPE_CHANGER, mc.thePlayer, mc.objectMouseOver.getBlockPos()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}
