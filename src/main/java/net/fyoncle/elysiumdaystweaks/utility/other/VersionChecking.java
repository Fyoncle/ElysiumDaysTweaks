package net.fyoncle.elysiumdaystweaks.utility.other;

import com.google.gson.JsonParser;
import net.fyoncle.elysiumdaystweaks.utility.constants.Constants;
import net.fyoncle.elysiumdaystweaks.utility.networking.RequestSender;

public class VersionChecking {
    public void checkEDVersion() {
        RequestSender requestSender = new RequestSender();
        String jsonString = requestSender.sendRequestTo(
                Constants.Links.MODRINTH_API_LINK +
                "v2/project/lz3ryGPQ/version");
        JsonParser parser = new JsonParser();
        String latestVersion = parser.parse(jsonString).getAsJsonArray().get(0)
                .getAsJsonObject().get("version_number").getAsString();
        Strings.LATEST_ED_VERSION = latestVersion;

        String[] currentVersionNums = Constants.Core.CURRENT_ED_VERSION.split("\\.");
        String[] latestVersionNums = latestVersion.split("\\.");

        int greaterNumMatchingCount = 0;

        for(int i = 0; i < currentVersionNums.length; i++) {
            if(Integer.parseInt(currentVersionNums[i]) >= Integer.parseInt(latestVersionNums[i])) {
                greaterNumMatchingCount++;
            }
        }

        if(greaterNumMatchingCount >= 3) {
            Flags.IS_LATEST_VERSION = true;
        }
    }
}
