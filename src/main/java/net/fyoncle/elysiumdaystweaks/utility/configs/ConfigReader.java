package net.fyoncle.elysiumdaystweaks.utility.configs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ConfigReader {

    File configFile;
    BufferedReader bufferedReader;

    int whiteSpaceCount = 0;

    public ConfigReader(String pathToMinecraftFolder, String fileName) {
        configFile = new File(pathToMinecraftFolder + fileName);
    }

    public HashMap<String, String> readData() {
        HashMap<String, String> result = new HashMap<>();
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(configFile));
            while((line = bufferedReader.readLine()) != null) {
                result.put(getVarNameBeforeEquals(line), getDataAfterEquals(line).trim());
            }
            bufferedReader.close();
        } catch (IOException e) {throw new RuntimeException(e);}
        return result;
    }

    private String getDataAfterEquals(String line) {
        String data = "null";
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '=') {
                if(line.charAt(i+1) == ' ') {
                    whiteSpaceCount++;
                }
                data = line.substring(i + whiteSpaceCount);
                whiteSpaceCount = 0;
            }
        }
        return data;
    }

    private String getVarNameBeforeEquals(String line) {
        String name = "";
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) != '=') {
                name += line.charAt(i);
            } else {
                break;
            }
        }
        return name.trim();
    }

}
