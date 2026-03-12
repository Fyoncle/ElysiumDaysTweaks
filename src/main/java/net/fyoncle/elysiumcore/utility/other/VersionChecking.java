package net.fyoncle.elysiumcore.utility.other;

import com.google.gson.JsonParser;
import net.fyoncle.elysiumcore.ElysiumCore;
import net.fyoncle.elysiumcore.utility.constants.Constants;
import net.fyoncle.elysiumcore.utility.networking.RequestSender;

public class VersionChecking {

    private boolean isVersionGreater(String[] current, String[] latest) {
        int length = Math.min(current.length, latest.length);
        for (int i = 0; i < length; i++) {
            int c = Integer.parseInt(current[i]);
            int l = Integer.parseInt(latest[i]);
            if (c != l) return c >= l;
        }
        return true;
    }

    public void checkEDVersion() {
        RequestSender requestSender = new RequestSender();
        String jsonString = requestSender.sendRequestTo(
                Constants.Links.MODRINTH_API_LINK
                        + "v2/project/lz3ryGPQ/version?game_versions=[%22"
                        + Constants.Core.CURRENT_MINECRAFT_VERSION + "%22]");

        if (jsonString.equals("request_failed") || jsonString.equals("invalid_result")) {
            Flags.IS_LATEST_VERSION = true;
            return;
        }

        try {
            Strings.LATEST_ED_VERSION = JsonParser.parseString(jsonString).getAsJsonArray().get(0)
                    .getAsJsonObject().get("version_number").getAsString();

            String[] currentVersionNums = Constants.Core.CURRENT_ED_VERSION.split("\\.");
            String[] latestVersionNums = Strings.LATEST_ED_VERSION.split("\\.");

            Flags.IS_LATEST_VERSION = isVersionGreater(currentVersionNums, latestVersionNums);
        } catch (Exception e) {
            Flags.IS_LATEST_VERSION = true;
            ElysiumCore.LOGGER.error("Version check failed: {}", e.getMessage());
        }
    }
}