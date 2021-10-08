package fireopal.autumnalforest.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.biome.layer.AddBaseBiomesLayer;

@Mixin(AddBaseBiomesLayer.class)
public interface AddBaseBiomesAccessor {
    @Accessor("TEMPERATE_BIOMES")
    public static int[] getTemperateBiomes() {
        throw new AssertionError();
    }

    @Accessor("TEMPERATE_BIOMES")
    public static void setTemperateBiomes(int[] biomes) {
        throw new AssertionError();
    }
}
