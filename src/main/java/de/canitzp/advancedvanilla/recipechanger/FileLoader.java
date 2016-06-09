package de.canitzp.advancedvanilla.recipechanger;

import de.canitzp.advancedvanilla.api.IRecipeHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author canitzp
 */
public class FileLoader{

    public static void read(IRecipeHandler handler){
        if(handler.getSaveFile().saveFile.exists()){
            try{
                handler.resetRecipes();
                List<String> lines = FileUtils.readLines(handler.getSaveFile().saveFile);
                for(int i = 0; i < lines.size(); i++){
                    if(lines.get(i).contains("#") && !lines.get(i + 1).contains("#")){
                        handler.readFromFile(lines.get(i).replace("#", ""), lines.get(i + 1));
                    }
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void save(IRecipeHandler handler){
        File saveFile = handler.getSaveFile().saveFile;
        try{
            if(!saveFile.exists()){
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            } else {
                saveFile.delete();
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            }

            List<Pair<String, String>> entries = handler.saveToFile();
            if(entries != null && entries.size() > 0){
                StringBuilder builder = new StringBuilder();
                for(Map.Entry<String, String> entry : entries){
                    builder.append("#" + entry.getKey()).append("\r\n").append(entry.getValue()).append("\r\n");
                }
                FileUtils.writeStringToFile(saveFile, builder.toString());
            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
