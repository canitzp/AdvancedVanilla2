package de.canitzp.advancedvanilla.util;

import net.minecraft.client.Minecraft;

import java.io.*;
import java.util.Calendar;

/**
 * @author canitzp
 */
public class AVConfig {

    public static boolean newEntry = false;
    public static int changes;

    public static void configChanger(String fileName, String lineToChange, String replacedLine){
        File config = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "config" + File.separator + fileName);
        String line, input = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(config));
            boolean lastModText = false;
            while ((line = br.readLine()) != null) {
                if (line.replace(" ", "").equals(lineToChange.replace(" ", ""))) {
                    input += "    # The next Line is modified by AdvancedVanilla!" + System.lineSeparator() + "    " + replacedLine + System.lineSeparator();
                    newEntry = true;
                    changes++;
                }else if(line.contains("# AdvancedVanilla last modified:") && newEntry){
                    input += writeCalender();
                    lastModText = true;
                } else {
                    input += line + System.lineSeparator();
                }
            }
            if(!lastModText && newEntry){
                input += writeCalender();
            }

            new FileOutputStream(config).write(input.getBytes());
            br.close();

            if(changes > 0) AVLogger.info("Replaced \"" + lineToChange + "\" in \"" + fileName + "\" with \"" + replacedLine + "\"");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String writeCalender(){
        String input = "";
        Calendar c = Calendar.getInstance();
        String year = Integer.toString(c.get(Calendar.YEAR));
        String month = Integer.toString(c.get(Calendar.MONTH) + 1);
        String day = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(c.get(Calendar.MINUTE));
        if(hour.length() == 1) hour = "0" + hour;
        if(minute.length() == 1) minute = "0" + minute;
        input += "# AdvancedVanilla last modified: " + year + "/" + month + "/" + day + ", " + hour + ":" + minute;
        return input;
    }

}
