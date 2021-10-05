package fireopal.autumnalforest.features;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import fireopal.autumnalforest.AutumnalForest;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.ConfiguredDecorator;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.decorator.WaterDepthThresholdDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.Heightmap;

public class AutumnalForestConfiguredFeatures {
    public static ConfiguredFeature<?, ?> AUTUMNAL_FOREST_TREES;
    public static ConfiguredFeature<?, ?> AUTUMNAL_FOREST_PUMPKINS;

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return (ConfiguredFeature<FC, ?>)Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, AutumnalForest.id(id), configuredFeature);
    }

    public static void init() {
        AUTUMNAL_FOREST_TREES = register("autumnal_forest_trees", Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(ImmutableList.of(
                ConfiguredFeatures.FANCY_OAK_BEES_0002.withChance(0.25F),
                ConfiguredFeatures.DARK_OAK.withChance(0.05F),
                ConfiguredFeatures.SPRUCE.withChance(0.05F),
                ConfiguredFeatures.PINE.withChance(0.05F)), 
                ConfiguredFeatures.OAK_BEES_0002))
            .decorate(AutumnalForestConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(8, 0.5F, 2))));

        AUTUMNAL_FOREST_PUMPKINS = register("autumnal_forest_pumpkins", Feature.RANDOM_PATCH.configure(
            (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(
                    Blocks.PUMPKIN.getDefaultState()), SimpleBlockPlacer.INSTANCE))
                .tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK)).cannotProject().build())
            .decorate(AutumnalForestConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).applyChance(8));
    }

    public static final class Decorators {
        public static final ConfiguredDecorator<?> HEIGHTMAP = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING));
        public static final ConfiguredDecorator<?> HEIGHTMAP_OCEAN_FLOOR = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR));
        public static final ConfiguredDecorator<?> HEIGHTMAP_OCEAN_FLOOR_NO_WATER = HEIGHTMAP_OCEAN_FLOOR.decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(0)));
        public static final ConfiguredDecorator<?> SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER = (ConfiguredDecorator<?>)HEIGHTMAP_OCEAN_FLOOR_NO_WATER.spreadHorizontally();
        public static final ConfiguredDecorator<?> HEIGHTMAP_SPREAD_DOUBLE = Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING));
        public static final ConfiguredDecorator<?> SQUARE_HEIGHTMAP_SPREAD_DOUBLE = (ConfiguredDecorator<?>)HEIGHTMAP_SPREAD_DOUBLE.spreadHorizontally();
    }
    
}
