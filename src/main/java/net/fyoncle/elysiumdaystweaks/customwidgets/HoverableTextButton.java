package net.fyoncle.elysiumdaystweaks.customwidgets;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;

public class HoverableTextButton extends TexturedButtonWidget {
    private final Identifier unfocused;
    private final Identifier focused;

    private final int textureWidth;
    private final int textureHeight;

    private final String text;

    private final int u;
    private final int v;

    public HoverableTextButton(int x, int y, int width, int height,
                               int u, int v, int tw, int th,
                               String text,
                               Identifier textureUnFocused,
                               Identifier textureFocused, PressAction pressAction) {
        super(x, y, width, height, new ButtonTextures(textureUnFocused, textureFocused), pressAction);
        unfocused = textureUnFocused;
        focused = textureFocused;
        this.textureWidth = tw;
        this.textureHeight = th;
        this.text = text;
        this.u = u;
        this.v = v;
    }

    @Override
    public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        if(isHovered()) {
            context.drawTexture(focused, this.getX(), this.getY(), this.u, this.v, this.width,
                    this.height, this.textureWidth,this.textureHeight);
        } else {
            context.drawTexture(unfocused, this.getX(), this.getY(), this.u, this.v, this.width,
                    this.height, this.textureWidth,this.textureHeight);
        }
        if(text != null) {
            context.drawCenteredTextWithShadow(MinecraftClient.getInstance().textRenderer,
                    text, this.getX() + this.width/2,this.getY() + 6, Colors.WHITE);
        }
    }
}
