package tokyo.shisui.directconnectreset.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.DirectJoinServerScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DirectJoinServerScreen.class)
public abstract class DirectJoinServerScreenMixin extends Screen {
    private static final int BUTTON_HEIGHT = 20;
    private static final int BUTTON_GAP = 4;

    @Shadow
    private EditBox ipEdit;

    @Unique
    private Button directConnectReset$resetButton;

    protected DirectJoinServerScreenMixin(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    private void directConnectReset$onInit(CallbackInfo ci) {
        this.ipEdit.setValue("");

        int buttonWidth = (this.ipEdit.getWidth() - BUTTON_GAP) / 2;
        int buttonY = this.ipEdit.getY() + this.ipEdit.getHeight() + BUTTON_GAP;
        int pasteX = this.ipEdit.getX();
        int resetX = pasteX + buttonWidth + BUTTON_GAP;

        this.addRenderableWidget(
            Button.builder(
                    Component.translatable("direct_connect_reset.button.paste"),
                    button -> this.ipEdit.setValue(this.minecraft.keyboardHandler.getClipboard()))
                .bounds(pasteX, buttonY, buttonWidth, BUTTON_HEIGHT)
                .build());
        this.directConnectReset$resetButton = this.addRenderableWidget(
            Button.builder(
                    Component.translatable("direct_connect_reset.button.reset"),
                    button -> this.ipEdit.setValue(""))
                .bounds(resetX, buttonY, buttonWidth, BUTTON_HEIGHT)
                .build());
        this.directConnectReset$updateResetButton();
    }

    @Inject(method = "updateSelectButtonStatus", at = @At("RETURN"))
    private void directConnectReset$onValueChanged(CallbackInfo ci) {
        this.directConnectReset$updateResetButton();
    }

    @Unique
    private void directConnectReset$updateResetButton() {
        if (this.directConnectReset$resetButton != null) {
            this.directConnectReset$resetButton.active = !this.ipEdit.getValue().isEmpty();
        }
    }
}
