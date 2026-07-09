package net.fyoncle.elysiumcore.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.fyoncle.elysiumcore.ElysiumCore;
import net.fyoncle.elysiumcore.customwidgets.HoverableTextToggleButton;
import net.fyoncle.elysiumcore.utility.constants.Textures;
import net.fyoncle.elysiumcore.utility.other.Flags;
import net.fyoncle.elysiumcore.utility.other.ServiceLoaders;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class EscapeMenuMixin extends Screen {
    @Unique
    private HoverableTextToggleButton healthBarStatusButton;

    protected EscapeMenuMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "initWidgets")
    private void addButtons(CallbackInfo ci) {
        for (int i = 0; i < this.children().size(); i++) {
            if (!(this.children().get(i) instanceof ClickableWidget widget)) continue;

            String widgetText = widget.getMessage().getString();
            int healthBarY = FabricLoader.getInstance().isModLoaded("replaymod") ? widget.getY() + widget.getHeight() + 3 : widget.getY();

            if (widget instanceof ButtonWidget) {
                if (widgetText.equals(Text.translatable("menu.returnToMenu").getString()) ||
                        widgetText.equals(Text.translatable("menu.disconnect").getString())) {
                    addHealthBarTogglingButton(this.width / 2 - 100 / 2, healthBarY);
                    break;
                }
            }
        }
    }

    @Unique
    private void addHealthBarTogglingButton(int x, int y) {
        if (ServiceLoaders.Flags.IS_NEAT_CONFIG_LOADED) {
            String neatText = Text.translatable("elysiumcore.neat_health_bar").getString();

            healthBarStatusButton = new HoverableTextToggleButton(x,
                    y + 20 + 5, 100, 20,
                    Textures.FOCUSED_ON_HEALTHBAR_TEXTURE,
                    Textures.FOCUSED_OFF_HEALTHBAR_TEXTURE,
                    Flags.IS_HEALTH_BAR_TOGGLED,
                    neatText + ": ON",
                    neatText + ": OFF",
                    Textures.UNFOCUSED_ON_HEALTHBAR_TEXTURE,
                    Textures.UNFOCUSED_OFF_HEALTHBAR_TEXTURE,
                    button -> toggleHealthBar());
            restoreHealthBarToggleStates();
            this.addDrawableChild(healthBarStatusButton);
        }
    }

    @Unique
    private void restoreHealthBarToggleStates() {
        boolean draw = ElysiumCore.serviceLoaders.NEAT_CONFIG_SERVICE.getDraw();
        Flags.IS_HEALTH_BAR_TOGGLED = draw;
        healthBarStatusButton.isToggled = draw;
    }

    @Unique
    private void toggleHealthBar() {
        boolean newState = !Flags.IS_HEALTH_BAR_TOGGLED;
        Flags.IS_HEALTH_BAR_TOGGLED = newState;
        healthBarStatusButton.isToggled = newState;
        ElysiumCore.serviceLoaders.NEAT_CONFIG_SERVICE.setDraw(newState);
    }
}