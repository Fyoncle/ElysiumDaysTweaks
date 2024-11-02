package net.fyoncle.elysiumdaystweaks.custommenus;

import net.fyoncle.elysiumdaystweaks.customwidgets.HoverableTextButton;
import net.fyoncle.elysiumdaystweaks.utility.constants.Constants;
import net.fyoncle.elysiumdaystweaks.utility.constants.Textures;
import net.fyoncle.elysiumdaystweaks.ElysiumDaysTweaks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Util;

public class RamWarningMenu extends Screen {

    private final String currentRam;
    private final String recommendedRam;
    private final String minimumRam;

    private final ElysiumDaysTweaks client;

    public RamWarningMenu(ElysiumDaysTweaks client, Text title, String currentRam,
                          String recommendedRam, String minimumRam) {
        super(title);
        this.client = client;
        this.currentRam = currentRam;
        this.recommendedRam = recommendedRam;
        this.minimumRam = minimumRam;
    }

    @Override
    protected void init() {
        super.init();
        addIgnoreButton();
        addGuideButton();
        addStopShowingButton();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        MultilineText.create(
                        MinecraftClient.getInstance().textRenderer,
                        Text.literal(Constants.Other.Ram.WidgetsText.RAM_SCREEN_WARNING_MESSAGE[0]
                                + currentRam + Constants.Other.Ram.WidgetsText.RAM_SCREEN_WARNING_MESSAGE[1]),
                        Text.literal(Constants.Other.Ram.WidgetsText.RAM_SCREEN_WARNING_MESSAGE[2]
                                + minimumRam + Constants.Other.Ram.WidgetsText.RAM_SCREEN_WARNING_MESSAGE[3]),
                        Text.literal(Constants.Other.Ram.WidgetsText.RAM_SCREEN_WARNING_MESSAGE[4]
                                + recommendedRam + Constants.Other.Ram.WidgetsText.RAM_SCREEN_WARNING_MESSAGE[5]))
                .drawCenterWithShadow(context, this.width/2, this.height/2-80, 20, Colors.WHITE);
    }

    private void addIgnoreButton() {
        this.addDrawableChild(new HoverableTextButton(this.width/2-200/2,
                this.height/2-20, 200, 20, 0, 0, 0, 200, 20,
                Constants.Other.Ram.WidgetsText.IGNORE_TEXT,
                Textures.IGNORE_BUTTON_UNFOCUSED, Textures.IGNORE_BUTTON_FOCUSED, button -> this.close()));
    }

    private void addGuideButton() {
        this.addDrawableChild(new HoverableTextButton(this.width/2-200/2,
                this.height/2+5, 200, 20, 0, 0, 0, 200, 20,
                Constants.Other.Ram.WidgetsText.SHOW_GUIDE_TEXT,
                Textures.GUIDE_BUTTON_UNFOCUSED, Textures.GUIDE_BUTTON_FOCUSED,
                button -> Util.getOperatingSystem().open(Constants.Links.RAM_GUIDE_LINK)));
    }

    private void addStopShowingButton() {
        this.addDrawableChild(new HoverableTextButton(this.width/2-200/2,
                this.height/2+30, 200, 20, 0, 0, 0, 200, 20,
                Constants.Other.Ram.WidgetsText.DONT_SHOW_AGAIN_TEXT, Textures.RED_BUTTON_UNFOCUSED,
                Textures.RED_BUTTON_FOCUSED, button -> {
            client.configSaver.saveData("true", Constants.Other.Configs.DISABLED_RAM_SCREEN_CONFIG_TYPE);
            this.close();
        }));
    }

    @Override
    public void close() {
        super.close();
    }
}
