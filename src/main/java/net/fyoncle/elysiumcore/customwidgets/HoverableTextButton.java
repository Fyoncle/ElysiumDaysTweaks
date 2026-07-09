package net.fyoncle.elysiumcore.customwidgets;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;

public class HoverableTextButton extends TexturedButtonWidget {
    private final String text;

    public HoverableTextButton(int x, int y, int width, int height,
                               String text,
                               Identifier textureUnfocused,
                               Identifier textureFocused, PressAction pressAction) {
        super(x, y, width, height, new ButtonTextures(textureUnfocused, textureFocused), pressAction);
        this.text = text;
    }

    @Override
    public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        super.renderWidget(context, mouseX, mouseY, delta);

        if (text != null) {
            context.drawCenteredTextWithShadow(MinecraftClient.getInstance().textRenderer,
                    text, this.getX() + this.width / 2, this.getY() + 6, Colors.WHITE);
        }
    }
}