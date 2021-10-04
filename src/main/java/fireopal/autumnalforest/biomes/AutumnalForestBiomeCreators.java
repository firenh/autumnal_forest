package fireopal.autumnalforest.biomes;

import fireopal.autumnalforest.util.FireopalBiomeAPI_v1_1.Build;
import fireopal.autumnalforest.util.FireopalBiomeAPI_v1_1.Effects;
import fireopal.autumnalforest.util.FireopalBiomeAPI_v1_1.Generation;
import fireopal.autumnalforest.util.FireopalBiomeAPI_v1_1.Spawns;
import static fireopal.autumnalforest.util.FireopalBiomeAPI_v1_1.Spawns.spawn;

import fireopal.autumnalforest.features.AutumnalForestConfiguredFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;

public class AutumnalForestBiomeCreators {
    private AutumnalForestBiomeCreators() {}

    public static Biome createAutumnalForestBiome(int foliageColor, float depth, float scale) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);
        Spawns.creatures(spawnSettings, 
            spawn(EntityType.WOLF, 5, 4, 4)
        );

        GenerationSettings.Builder generationSettings = (new GenerationSettings.Builder())
            .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addForestFlowers(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addDefaultFlowers(generationSettings);
        DefaultBiomeFeatures.addForestGrass(generationSettings);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);

        Generation.vegetalDecorationFeatures(generationSettings, 
            AutumnalForestConfiguredFeatures.AUTUMNAL_FOREST_TREES,
            ConfiguredFeatures.SEAGRASS_RIVER
        );

        Generation.structureFeatures(generationSettings, 
            ConfiguredStructureFeatures.RUINED_PORTAL,
            ConfiguredStructureFeatures.VILLAGE_TAIGA
        );

        float temperature = 0.7F;
        
        BiomeEffects.Builder biomeEffects = ((new BiomeEffects.Builder())
            .waterColor(4159204)
            .waterFogColor(329011)
            .fogColor(12638463)
            //Old grass color: 11646291
            .grassColor(13023555)
            .foliageColor(foliageColor)
            .moodSound(BiomeMoodSound.CAVE)
        );

        Effects.setSkyColor(biomeEffects, temperature);

        Biome.Builder biome = (new Biome.Builder())
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.FOREST);
        Build.properties(biome, depth, scale, temperature, 0.8F);
        Build.finalize(biome, spawnSettings, generationSettings, biomeEffects);

        return biome.build();
    }

}
