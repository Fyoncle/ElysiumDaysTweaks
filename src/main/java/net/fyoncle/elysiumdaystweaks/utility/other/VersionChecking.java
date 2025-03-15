package net.fyoncle.elysiumdaystweaks.utility.other;

import com.google.gson.JsonParser;
import net.fyoncle.elysiumdaystweaks.utility.constants.Constants;
import net.fyoncle.elysiumdaystweaks.utility.networking.RequestSender;

public class VersionChecking {

    private boolean isVersionBigger(String[] version1, String[] version2) {
        int greaterCount = 0;
        for(int i = 0; i < version1.length; i++) {
            greaterCount += (Integer.parseInt(version1[i]) >= Integer.parseInt(version2[i])) ? 1 : 0;
        }
        return greaterCount == version1.length;
    }

    public void checkEDVersion() {
        RequestSender requestSender = new RequestSender();
        String jsonString = requestSender.sendRequestTo(
                Constants.Links.MODRINTH_API_LINK
                        + "v2/project/lz3ryGPQ/version?game_versions=[%22"
                        + Constants.Core.CURRENT_MINECRAFT_VERSION +"%22]");
        try {
            Strings.LATEST_ED_VERSION = JsonParser.parseString(jsonString).getAsJsonArray().get(0)
                    .getAsJsonObject().get("version_number").getAsString();

            String[] currentVersionNums = Constants.Core.CURRENT_ED_VERSION.split("\\.");
            String[] latestVersionNums = Strings.LATEST_ED_VERSION.split("\\.");

            Flags.IS_LATEST_VERSION = isVersionBigger(currentVersionNums, latestVersionNums);
        } catch(Exception e) {e.printStackTrace();}
    }
}