package net.fyoncle.elysiumdaystweaks.customwidgets;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;

public class HoverableTextButton extends TexturedButtonWidget {
    private final Identifier unfocused;
    private final Identifier focused;

    private final int textureWidth;
    private final int textureHeight;

    private final String text;

    public HoverableTextButton(int x, int y, int width, int height,
                               int u, int v, int offset, int tw, int th,
                               String text,
                               Identifier textureUnFocused,
                               Identifier textureFocused, PressAction pressAction) {
        super(x, y, width, height, u, v, offset, textureUnFocused, pressAction);
        unfocused = textureUnFocused;
        focused = textureFocused;
        this.textureWidth = tw;
        this.textureHeight = th;
        this.text = text;
    }

    @Override
    public void renderButton(DrawContext context, int mouseX, int mouseY, float delta) {
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
