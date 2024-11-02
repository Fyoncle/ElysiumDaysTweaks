package net.fyoncle.elysiumdaystweaks.mixin;

import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fyoncle.elysiumdaystweaks.customwidgets.HoverableButton;
import net.fyoncle.elysiumdaystweaks.customwidgets.HoverableTextButton;
import net.fyoncle.elysiumdaystweaks.utility.constants.Constants;
import net.fyoncle.elysiumdaystweaks.utility.constants.Textures;
import net.fyoncle.elysiumdaystweaks.utility.other.Flags;
import net.fyoncle.elysiumdaystweaks.utility.other.Strings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MainMenuMixin extends Screen {

    protected MainMenuMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "initWidgetsNormal")
    private void addModsButton(int y, int spacingY, CallbackInfo ci) {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if(screen instanceof TitleScreen) {
                for (int i = 0; i < screen.children().size(); i++) {
                    if (((ButtonWidget) screen.children().get(i)).getMessage()
                            .getString().equals(Text.translatable("menu.quit").getString())) {
                        addDiscordButton(i);
                        addNewUpdateButton(Flags.IS_LATEST_VERSION,
                                ((ButtonWidget) screen.children().get(i)).getY());
                    }
                }
            }
        });
    }

    @Unique
    private void addDiscordButton(int i) {
        int x = ((ButtonWidget) MainMenuMixin.this.children().get(i+1)).getX();
        int yPos = ((ButtonWidget) MainMenuMixin.this.children().get(i+1)).getY();
        int width = ((ButtonWidget) MainMenuMixin.this.children().get(i+1)).getWidth();
        this.addDrawableChild(new HoverableButton(x + width + 4, yPos, 20,
                20, 0,0, 0, 20, 20, Textures.DISCORD_BUTTON_UNFOCUSED_TEXTURE,
                Textures.DISCORD_BUTTON_FOCUSED_TEXTURE,
                button -> Util.getOperatingSystem().open(Constants.Links.DISCORD_LINK)));
    }

    @Unique
    private void addNewUpdateButton(boolean isLatestVersion, int quitGameButtonY) {
        if(!isLatestVersion) {
            this.addDrawableChild(new HoverableTextButton(this.width/2-200/2, quitGameButtonY+30,
                    200, 20,0, 0, 0, 200, 20,
                    "Modpack Update Available " + "(" + Strings.LATEST_ED_VERSION + ")",
                    Textures.GREEN_BUTTON_UNFOCUSED_TEXTURE,
                    Textures.GREEN_BUTTON_FOCUSED_TEXTURE,
                    button -> Util.getOperatingSystem().open(Constants.Links.ELYSIUM_DAYS_PAGE_LINK)));
        }
    }

}