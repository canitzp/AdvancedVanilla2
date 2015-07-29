package canitzp.advancedvanilla.compat.multiMod;

import cpw.mods.fml.common.Loader;
import net.minecraftforge.common.config.Configuration;

import java.io.*;

public class AVModpack {
    public static void preInit(){

    }
    public static void init() throws IOException {
        if(Loader.isModLoaded("ActuallyAdditions")){
            String file = "";
            StringBuffer buf = new StringBuffer();
            BufferedReader buff = new BufferedReader(new FileReader("config\\ActuallyAdditions.cfg"));
            while ((file = buff.readLine()) != null){
                String str = file.replace("B:\"Black Quartz in a Crafting Table (as a Backup if there's no Ores to be found anywhere)\"=true", "B:\"Black Quartz in a Crafting Table (as a Backup if there's no Ores to be found anywhere)\"=false");
                buf.append(str);
                BufferedWriter buffr = new BufferedWriter(new FileWriter("config\\ActuallyAdditions.cfg"));
                buffr.write(buf.toString());
                buffr.close();
            }
        }
    }
    public static void postInit(){

    }
}
