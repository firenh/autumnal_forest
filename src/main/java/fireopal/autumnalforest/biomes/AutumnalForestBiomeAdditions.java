package fireopal.autumnalforest.biomes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import fireopal.autumnalforest.mixin.AddBaseBiomesAccessor;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.mixin.biome.VanillaLayeredBiomeSourceAccessor;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class AutumnalForestBiomeAdditions {
    private static void addBiomes() {
        addOrangeAutumnalForestLargeVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, 0.7, 1);
        addOrangeAutumnalForestLargeVariant(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, 0.7, 1);

        addAutumnalForestVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, 0.7, 2);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, 0.7, 2);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.YELLOW_AUTUMNAL_FOREST, 0.5, 1);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.PURPLE_AUTUMNAL_FOREST, 0.5, 1);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.BROWN_AUTUMNAL_FOREST, 0.5, 1);


        addAutumnalForestVariant(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.YELLOW_AUTUMNAL_FOREST, 0.77, 3);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, 0.77, 2);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, 0.5, 2);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.BROWN_AUTUMNAL_FOREST, 0.5, 1);
        
        addAutumnalForestVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, 0.77, 3);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.PURPLE_AUTUMNAL_FOREST, 0.77, 3);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST, 0.5, 2);
        addAutumnalForestVariant(AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST, AutumnalForestBiomeKeys.BROWN_AUTUMNAL_FOREST, 0.5, 1);
    }

    private static void addOrangeAutumnalForestLargeVariant(RegistryKey<Biome> variant, double chance, int timesAdded) {
        for (int i = 0; i < timesAdded; i++) {
            OverworldBiomes.addBiomeVariant(AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST, variant, chance, OverworldClimate.values());
        }
    }

    private static void addAutumnalForestVariant(RegistryKey<Biome> target, RegistryKey<Biome> variant, double chance, int timesAdded) {
        for (int i = 0; i < timesAdded; i++) {
            OverworldBiomes.addHillsBiome(target, variant, chance);
        }
    }

    public static void addBiomeToBaseBiomes(Biome... biomes) {
        for (Biome b : biomes) {
            AddBaseBiomesAccessor.setTemperateBiomes(
                ArrayUtils.add(AddBaseBiomesAccessor.getTemperateBiomes(), BuiltinRegistries.BIOME.getRawId(b))
            );
        }
    }

    public static void init() {
        List<RegistryKey<Biome>> biomes = new ArrayList<>(VanillaLayeredBiomeSourceAccessor.getBIOMES());
		Collections.addAll(biomes, 
            AutumnalForestBiomeKeys.ORANGE_AUTUMNAL_FOREST,
            AutumnalForestBiomeKeys.GOLDEN_AUTUMNAL_FOREST,
            AutumnalForestBiomeKeys.RED_AUTUMNAL_FOREST
        );
        VanillaLayeredBiomeSourceAccessor.setBIOMES(biomes);

        addBiomeToBaseBiomes(
            AutumnalForestBiomes.ORANGE_AUTUMNAL_FOREST,
            AutumnalForestBiomes.GOLDEN_AUTUMNAL_FOREST,
            AutumnalForestBiomes.RED_AUTUMNAL_FOREST
        );

        addBiomes();
    }
}
