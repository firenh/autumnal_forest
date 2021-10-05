package fireopal.autumnalforest.biomes;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class AutumnalForestBiomes {
    private static Biome register(RegistryKey<Biome> key, Biome biome) {
        return Registry.register(BuiltinRegistries.BIOME, key.getValue(), biome);
    }

    public static void init() {
        register(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeCreators.createAutumnalForestBiome(0xE47425, 0.15F, 0.35F));
        register(AutumnalForestBiomeKeys.YELLOW_AUTUMNAL_FOREST, AutumnalForestBiomeCreators.createAutumnalForestBiome(0xFFDA3C, 0.15F, 0.1F));
        register(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, AutumnalForestBiomeCreators.createAutumnalForestBiome(0xFEA920, 0.15F, 0.25F));
        register(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, AutumnalForestBiomeCreators.createAutumnalForestBiome(0xCC3913, 0.15F, 0.45F));
        register(AutumnalForestBiomeKeys.PURPLE_AUTUMNAL_FOREST, AutumnalForestBiomeCreators.createAutumnalForestBiome(0x770D38, 0.15F, 0.35F));

        addBiomes();

    }

    @SuppressWarnings("deprecated")
    private static void addBiomes() {
        OverworldBiomes.addContinentalBiome(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, OverworldClimate.TEMPERATE, 0.75);

        addOrangeAutumnalForestLargeVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, 0.333, 1);
        addOrangeAutumnalForestLargeVariant(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, 0.333, 1);

        addAutumnalForestVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, 0.5, 2);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, 0.5, 2);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.YELLOW_AUTUMNAL_FOREST, 0.25, 1);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.PURPLE_AUTUMNAL_FOREST, 0.25, 1);



        addAutumnalForestVariant(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.YELLOW_AUTUMNAL_FOREST, 0.6, 3);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, 0.4, 2);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, 0.25, 2);

        addAutumnalForestVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, 0.6, 3);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.PURPLE_AUTUMNAL_FOREST, 0.6, 3);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, 0.25, 2);

    }

    private static void addOrangeAutumnalForestLargeVariant(RegistryKey<Biome> variant, double chance, int timesAdded) {
        for (int i = 0; i < timesAdded; i++) {
            OverworldBiomes.addBiomeVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, variant, chance, OverworldClimate.TEMPERATE);
        }
    }

    private static void addAutumnalForestVariant(RegistryKey<Biome> target, RegistryKey<Biome> variant, double chance, int timesAdded) {
        for (int i = 0; i < timesAdded; i++) {
            OverworldBiomes.addHillsBiome(target, variant, chance);
        }
    }
}
