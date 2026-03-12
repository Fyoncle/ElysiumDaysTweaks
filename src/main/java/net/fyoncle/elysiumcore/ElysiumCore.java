package net.fyoncle.elysiumcore;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fyoncle.elysiumcore.custommenus.RamWarningMenu;
import net.fyoncle.elysiumcore.utility.other.Ram;
import net.fyoncle.elysiumcore.utility.other.ServiceLoaders;
import net.fyoncle.elysiumcore.utility.other.VersionChecking;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElysiumCore implements ClientModInitializer {

    public static final String MOD_ID = "elysiumcore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public final static ServiceLoaders serviceLoaders = new ServiceLoaders();
    private final VersionChecking versionChecking = new VersionChecking();
    private RamWarningMenu ramWarningMenu;
    private boolean hasShownRamWarning = false;

    @Override
    public void onInitializeClient() {
        ElysiumCoreConfig.init();
        versionChecking.checkEDVersion();
        initEvents();
        initCustomScreens();
    }

    private void initEvents() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            if (!ElysiumCoreConfig.config.disableRamWarningScreen) {
                if (Ram.getAllocatedRam() < 4.5) {
                    ClientTickEvents.END_CLIENT_TICK.register(tickClient -> {
                        if (!hasShownRamWarning && tickClient.currentScreen instanceof TitleScreen) {
                            tickClient.setScreen(ramWarningMenu);
                            hasShownRamWarning = true;
                        }
                    });
                }
            }
        });
    }

    private void initCustomScreens() {
        ramWarningMenu = new RamWarningMenu(Text.empty(),
                String.valueOf(Ram.getAllocatedRam()).substring(0, 3));
    }
}