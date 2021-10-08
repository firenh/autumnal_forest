package fireopal.autumnalforest.biomes;

import fireopal.autumnalforest.mixin.BuiltinBiomesAccessor;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import static fireopal.autumnalforest.biomes.AutumnalForestBiomeCreators.createAutumnalForestBiome;

public class AutumnalForestBiomes {
    public static final Biome ORANGE_AUTUMNAL_FOREST = createAutumnalForestBiome(0xE47425, 0.15F, 0.35F);
    public static final Biome YELLOW_AUTUMNAL_FOREST = createAutumnalForestBiome(0xFFDA3C, 0.15F, 0.1F);
    public static final Biome GOLDEN_AUTUMNAL_FOREST = createAutumnalForestBiome(0xFEA920, 0.15F, 0.25F);
    public static final Biome RED_AUTUMNAL_FOREST = createAutumnalForestBiome(0xCC3913, 0.15F, 0.45F);
    public static final Biome PURPLE_AUTUMNAL_FOREST = createAutumnalForestBiome(0x770D38, 0.15F, 0.35F);
    public static final Biome BROWN_AUTUMNAL_FOREST = createAutumnalForestBiome(0x794924, 0.1F, 0.1F);

    private static void register(RegistryKey<Biome> key, Biome biome) {
        Registry.register(BuiltinRegistries.BIOME, key.getValue(), biome);
        BuiltinBiomesAccessor.getRawIdMap().put(BuiltinRegistries.BIOME.getRawId(biome), key);
    }

    public static void init() {
        register(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, ORANGE_AUTUMNAL_FOREST);
        register(AutumnalForestBiomeKeys.YELLOW_AUTUMNAL_FOREST, YELLOW_AUTUMNAL_FOREST);
        register(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, GOLDEN_AUTUMNAL_FOREST);
        register(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, RED_AUTUMNAL_FOREST);
        register(AutumnalForestBiomeKeys.PURPLE_AUTUMNAL_FOREST, PURPLE_AUTUMNAL_FOREST);
        register(AutumnalForestBiomeKeys.BROWN_AUTUMNAL_FOREST, BROWN_AUTUMNAL_FOREST);
    }
}
