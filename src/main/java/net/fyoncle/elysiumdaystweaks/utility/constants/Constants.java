package net.fyoncle.elysiumdaystweaks.utility.constants;

import net.minecraft.MinecraftVersion;

public class Constants {
    public static class Links {
        public static final String MODRINTH_API_LINK = "https://api.modrinth.com/";
        public static final String ELYSIUM_DAYS_PAGE_LINK = "https://modrinth.com/modpack/elysium-days/versions";
        public static final String DISCORD_LINK = "https://discord.gg/WFpDr7zY8Z";
        public static final String RAM_GUIDE_LINK = "https://github.com/Fyoncle/Elysium-Days/wiki/How-to-allocate-more-RAM";
    }

    public static class Core {
        public static final String CURRENT_ED_VERSION = "7.0.0";
        public static final String CURRENT_MINECRAFT_VERSION = MinecraftVersion.CURRENT.getName();
        public static final String ELYSIUM_DAYS_WINDOW_TITLE = "Minecraft " + CURRENT_MINECRAFT_VERSION + " - Elysium Days";
        public static class Paths {
            public static final String ICONS_PATH = "assets/elysium-days-tweaks/icons/";
            public static final String[] DEFAULT_ED_ICONS_FILE_NAMES = new String[] {
                    "defaulticons/ed_default_icon_16x16.png", "defaulticons/ed_default_icon_32x32.png",
                    "defaulticons/ed_default_icon_48x48.png", "defaulticons/ed_default_icon_128x128.png",
                    "defaulticons/ed_default_icon_256x256.png",
            };
            public static final String[] CHRISTMAS_ED_ICONS_FILE_NAMES = new String[] {
                    "christmasicons/ed_christmas_icon_16x16.png", "christmasicons/ed_christmas_icon_32x32.png",
                    "christmasicons/ed_christmas_icon_48x48.png", "christmasicons/ed_christmas_icon_128x128.png",
                    "christmasicons/ed_christmas_icon_256x256.png",
            };
            public static final String[] HALLOWEEN_ED_ICONS_FILE_NAMES = new String[] {
                    "halloweenicons/ed_halloween_icon_16x16.png", "halloweenicons/ed_halloween_icon_32x32.png",
                    "halloweenicons/ed_halloween_icon_48x48.png", "halloweenicons/ed_halloween_icon_128x128.png",
                    "halloweenicons/ed_halloween_icon_256x256.png",
            };
        }
    }

    public static class Other {
        public static class Configs {
            public static final int DISABLED_RAM_SCREEN_CONFIG_TYPE = 0;
            public static final String CONFIG_FILE_NAME = "elysiumdaystweaks.toml";
        }

        public static class Ram {
            public static final String RECOMMENDED_RAM = "6";
            public static final String MINIMUM_RAM = "5";
            public static class WidgetsText {
                public static final String IGNORE_TEXT = "Ignore";
                public static final String SHOW_GUIDE_TEXT = "Show Guide";
                public static final String DONT_SHOW_AGAIN_TEXT = "Don't Show Again";
                public static final String[] RAM_SCREEN_WARNING_MESSAGE = new String[] {
                        "You have allocated §c",
                        " GB §fof memory to the modpack which is not enough to run.",
                        "Please, allocate a §nminimum§f of §6",
                        " GB §fof RAM.",
                        "For the best experience, §a§l",
                        " GB §for more is §lrecommended§f."
                };
            }
        }
    }
}
