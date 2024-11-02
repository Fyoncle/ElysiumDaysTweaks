// This code was written by VipCoder.

package net.fyoncle.elysiumdaystweaks.custommenus;

import net.fyoncle.elysiumdaystweaks.ElysiumDaysTweaks;
import net.fyoncle.elysiumdaystweaks.customwidgets.HoverableTextButton;
import net.fyoncle.elysiumdaystweaks.utility.Constants;
import net.fyoncle.elysiumdaystweaks.utility.Textures;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Util;

public class RamWarningMenu extends Screen {

    private String currentRam;
    private String recommendedRam;
    private String minimumRam;

    private ElysiumDaysTweaks client;

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
                        Text.literal("You have allocated §c"
                                + currentRam + " GB §fof memory to the modpack which is not enough to run."),
                        Text.literal("Please, allocate a §nminimum§f of §6" + minimumRam + " GB§f of RAM."),
                        Text.literal("For the best experience, §a§l" + recommendedRam + " GB§f or more is §lrecommended§f."))
                .drawCenterWithShadow(context, this.width/2, this.height/2-80, 20, Colors.WHITE);
    }

    private void addIgnoreButton() {
        this.addDrawableChild(new HoverableTextButton(this.width/2-200/2,
                this.height/2-20, 200, 20, 0, 0, 0, 200, 20,
                "Ignore", Textures.IGNORE_BUTTON_UNFOCUSED, Textures.IGNORE_BUTTON_FOCUSED, button -> {
            this.close();
        }));
    }

    private void addGuideButton() {
        this.addDrawableChild(new HoverableTextButton(this.width/2-200/2,
                this.height/2+5, 200, 20, 0, 0, 0, 200, 20,
                "Show Guide", Textures.GUIDE_BUTTON_UNFOCUSED, Textures.GUIDE_BUTTON_FOCUSED, button -> {
            Util.getOperatingSystem().open(Constants.RAM_GUIDE_LINK);
        }));
    }

    private void addStopShowingButton() {
        this.addDrawableChild(new HoverableTextButton(this.width/2-200/2,
                this.height/2+30, 200, 20, 0, 0, 0, 200, 20,
                "Don't Show Again", Textures.RED_BUTTON_UNFOCUSED, Textures.RED_BUTTON_FOCUSED, button -> {
            client.configSaver.saveData("true", Constants.DISABLED_RAM_SCREEN_DATA_TYPE);
            this.close();
        }));
    }

    @Override
    public void close() {
        super.close();
    }
}