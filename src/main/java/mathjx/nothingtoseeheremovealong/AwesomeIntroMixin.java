package mathjx.nothingtoseeheremovealong;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.SplashScreen;
import net.minecraft.client.sound.AbstractSoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;

@Mixin(SplashScreen.class)
public final class AwesomeIntroMixin {

	@Inject(method = "render", at = @At(value = "INVOKE_ASSIGN", target = "net/minecraft/util/Util.getMeasuringTimeMs()J", shift = Shift.BEFORE, ordinal = 1))
	private void playAwesomeIntro(CallbackInfo info) {
		MinecraftClient.getInstance().getSoundManager().play(new AbstractSoundInstance(
				new Identifier("nothingtoseeheremovealong", "awesome_intro"), SoundCategory.MASTER) {
		});
	}

}
