package net.fyoncle.elysiumdaystweaks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fyoncle.elysiumdaystweaks.custommenus.RamWarningMenu;
import net.fyoncle.elysiumdaystweaks.utility.configs.ConfigReader;
import net.fyoncle.elysiumdaystweaks.utility.configs.ConfigSaver;
import net.fyoncle.elysiumdaystweaks.utility.constants.Constants;
import net.fyoncle.elysiumdaystweaks.utility.other.Ram;
import net.fyoncle.elysiumdaystweaks.utility.other.VersionChecking;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ElysiumDaysTweaks implements ClientModInitializer {

	//Config
	public ConfigSaver configSaver;
	public ConfigReader configReader;

	private final VersionChecking versionChecking = new VersionChecking();

	//Screens
	private RamWarningMenu ramWarningMenu;

	@Override
	public void onInitializeClient() {
		versionChecking.checkEDVersion();
		initConfigs();
		initEvents();
		initCustomScreens();
		registerBuiltinResourcePacks();
	}

	private void initConfigs() {
		configReader = new ConfigReader(
				FabricLoader.getInstance().getConfigDir().toFile().getAbsolutePath() + "/",
				Constants.Other.Configs.CONFIG_FILE_NAME);
		configSaver = new ConfigSaver(
				FabricLoader.getInstance().getConfigDir().toFile().getAbsolutePath() + "/",
				Constants.Other.Configs.CONFIG_FILE_NAME);

		if (configReader.readData().isEmpty()) {
			configSaver.saveData("false", Constants.Other.Configs.DISABLED_RAM_SCREEN_CONFIG_TYPE);
		}
	}

	private void initEvents() {
		ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
			if(configReader.readData().get("disableRamScreen").equals("false")) {
				if(Ram.getAllocatedRam() < 4.5) {
					if (client.currentScreen instanceof TitleScreen) {
						client.setScreen(ramWarningMenu);
					}
				}
			}
		});
	}

	private void initCustomScreens() {
		ramWarningMenu = new RamWarningMenu(this, Text.empty(),
				String.valueOf(Ram.getAllocatedRam()).substring(0, 3),
				Constants.Other.Ram.RECOMMENDED_RAM, Constants.Other.Ram.MINIMUM_RAM);
	}

	private void registerBuiltinResourcePacks() {
		FabricLoader.getInstance().getModContainer("elysium-days-tweaks").ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(
					new Identifier("elysium-days-tweaks", "elysiumdaystweaks"),
					modContainer,
					"§fElysium §6Days §cTweaks",
					ResourcePackActivationType.ALWAYS_ENABLED);
		});
	}

}
