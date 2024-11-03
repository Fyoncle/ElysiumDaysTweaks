package net.fyoncle.elysiumdaystweaks.utility.constants;

public class Constants {
    public static class Links {
        public static final String MODRINTH_API_LINK = "https://api.modrinth.com/";
        public static final String ELYSIUM_DAYS_PAGE_LINK = "https://modrinth.com/modpack/elysium-days/versions";
        public static final String DISCORD_LINK = "https://discord.gg/WFpDr7zY8Z";
        public static final String RAM_GUIDE_LINK = "https://github.com/Fyoncle/Elysium-Days/wiki/How-to-allocate-more-RAM";
    }

    public static class Core {
        public static final String ELYSIUM_DAYS_WINDOW_TITLE = "Minecraft Elysium Days";
        public static final String CURRENT_ED_VERSION = "6.1.0";
        public static class Paths {
            public static final String ICONS_PATH = "assets/elysium-days-tweaks/icons/";
        }
    }

    public static class Other {
        public static class Configs {
            public static final int DISABLED_RAM_SCREEN_CONFIG_TYPE = 0;
            public static final String CONFIG_FILE_NAME = "elysiumdaystweaks.toml";
        }

        public static class Ram {
            public static final String RECOMMENDED_RAM = "6";
            public static final String MINIMUM_RAM = "4";
            public static class WidgetsText {
                public static final String IGNORE_TEXT = "Ignore";
                public static final String SHOW_GUIDE_TEXT = "Show Guide";
                public static final String DONT_SHOW_AGAIN_TEXT = "Don't Show Again";
                public static final String[] RAM_SCREEN_WARNING_MESSAGE = new String[] {
                        "You have allocated §c",
                        " GB §fof memory to the modpack which is not enough to run.",
                        "Please, allocate a §nminimum§f of §6",
                        "GB§f of RAM.",
                        "For the best experience, §a",
                        "GB§f or more is recommended."
                };
            }
        }
    }
}
