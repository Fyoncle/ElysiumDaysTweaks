package net.fyoncle.elysiumdaystweaks;

import com.google.gson.JsonParser;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fyoncle.elysiumdaystweaks.custommenus.RamWarningMenu;
import net.fyoncle.elysiumdaystweaks.utility.*;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ElysiumDaysTweaks implements ClientModInitializer {
	public ConfigSaver configSaver;
	public ConfigReader configReader;

	@Override
	public void onInitializeClient() {
		configReader = new ConfigReader(
				FabricLoader.getInstance().getConfigDir().toFile().getAbsolutePath() + "/",
				"elysiumdaystweaks.toml");
		configSaver = new ConfigSaver(
				FabricLoader.getInstance().getConfigDir().toFile().getAbsolutePath() + "/",
				"elysiumdaystweaks.toml");
		if (configReader.readData().isEmpty()) {
			configSaver.saveData("false", Constants.DISABLED_RAM_SCREEN_DATA_TYPE);
		}


		RequestSender requestSender = new RequestSender();
		String jsonString = requestSender.sendRequestTo(Constants.MODRINTH_API_LINK +
				"v2/project/lz3ryGPQ/version");
		JsonParser parser = new JsonParser();
		String latestVersion = parser.parse(jsonString).getAsJsonArray().get(0)
				.getAsJsonObject().get("version_number").getAsString();
		Strings.LATEST_ED_VERSION = latestVersion;

		String[] currentVersionNums = Constants.CURRENT_ED_VERSION.split("\\.");
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

		RamWarningMenu ramWarningMenu = new RamWarningMenu(this, Text.empty(),
				String.valueOf(Ram.getAllocatedRam()).substring(0, 3),
				"6", "5");

		ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
			if(configReader.readData().get("disableRamScreen").equals("false")) {
				if(Ram.getAllocatedRam() < 4.5) {
					if (client.currentScreen instanceof TitleScreen) {
						client.setScreen(ramWarningMenu);
					}
				}
			}
		});

		FabricLoader.getInstance().getModContainer("elysium-days-tweaks").ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(
					new Identifier("elysium-days-tweaks", "elysiumdaystweaks"),
					modContainer,
					"§fElysium §6Days §cTweaks",
					ResourcePackActivationType.ALWAYS_ENABLED);
		});
	}
}