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
        register(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeCreators.createAutumnalForestBiome(14971941, 0.1F, 0.35F));
        register(AutumnalForestBiomeKeys.YELLOW_AUTUMNAL_FOREST, AutumnalForestBiomeCreators.createAutumnalForestBiome(16699685, 0.1F, 0.35F));
        register(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, AutumnalForestBiomeCreators.createAutumnalForestBiome(13383955, 0.1F, 0.45F));
        register(AutumnalForestBiomeKeys.PURPLE_AUTUMNAL_FOREST, AutumnalForestBiomeCreators.createAutumnalForestBiome(7802168, 0.1F, 0.35F));

        addBiomes();

    }

    @SuppressWarnings("deprecated")
    private static void addBiomes() {
        OverworldBiomes.addContinentalBiome(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, OverworldClimate.TEMPERATE, 0.75);

        addOrangeAutumnalForestVariant(AutumnalForestBiomeKeys.YELLOW_AUTUMNAL_FOREST, 0.4);
        addOrangeAutumnalForestVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, 0.3);
        addOrangeAutumnalForestVariant(AutumnalForestBiomeKeys.PURPLE_AUTUMNAL_FOREST, 0.225);

        OverworldBiomes.addEdgeBiome(AutumnalForestBiomeKeys.PURPLE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, 0.25);

    }

    private static void addOrangeAutumnalForestVariant(RegistryKey<Biome> variant, double chance) {
        OverworldBiomes.addHillsBiome(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, variant, chance);
    }
}
