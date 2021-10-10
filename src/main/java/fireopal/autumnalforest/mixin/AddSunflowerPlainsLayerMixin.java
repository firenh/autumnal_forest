package fireopal.autumnalforest.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import fireopal.autumnalforest.biomes.AutumnalForestBiomes;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.BiomeIds;
import net.minecraft.world.biome.layer.AddSunflowerPlainsLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

@Mixin(AddSunflowerPlainsLayer.class)
public class AddSunflowerPlainsLayerMixin {

    @Inject(at = @At("RETURN"), method = "sample(Lnet/minecraft/world/biome/layer/util/LayerRandomnessSource;I)I", cancellable = true)
    public void sample(LayerRandomnessSource context, int se, CallbackInfoReturnable<Integer> info) {
        if (se == BuiltinRegistries.BIOME.getRawId(AutumnalForestBiomes.ORANGE_AUTUMNAL_FOREST)) {
            short rand = (short) context.nextInt(8);

            if (rand == 0 || rand == 1) {
                info.setReturnValue(BuiltinRegistries.BIOME.getRawId(AutumnalForestBiomes.GOLDEN_AUTUMNAL_FOREST));
            } else if (rand == 2 || rand == 3) {
                info.setReturnValue(BuiltinRegistries.BIOME.getRawId(AutumnalForestBiomes.RED_AUTUMNAL_FOREST));
            } else {
                info.setReturnValue(se);
            }
        } else {
            info.setReturnValue(info.getReturnValue());
        }
    }
}
