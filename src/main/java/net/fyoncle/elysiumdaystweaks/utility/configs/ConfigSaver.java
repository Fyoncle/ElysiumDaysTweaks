package net.fyoncle.elysiumdaystweaks.utility.configs;

import net.fyoncle.elysiumdaystweaks.utility.constants.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigSaver {
    File configFile;
    FileWriter fileWriter;
    public ConfigSaver(String pathToMinecraftFolder, String fileName) {
        configFile = new File(pathToMinecraftFolder + fileName);
        if(!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveData(String data, int dataType) {
        try {
            fileWriter = new FileWriter(configFile);
            if(dataType == Constants.Other.Configs.DISABLED_RAM_SCREEN_CONFIG_TYPE) {
                fileWriter.write("disableRamScreen = " + data);
                fileWriter.close();
            }
        } catch (IOException e) {e.printStackTrace();}
    }
}
