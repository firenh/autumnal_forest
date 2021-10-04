package fireopal.autumnalforest.biomes;

import fireopal.autumnalforest.AutumnalForest;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class AutumnalForestBiomeKeys {
    private static RegistryKey<Biome> register(String id) {
        return RegistryKey.of(Registry.BIOME_KEY, AutumnalForest.id(id));
    }

    public static final RegistryKey<Biome> ORANGE_AUTUMNAL_FOREST = register("orange_autumnal_forest");
    public static final RegistryKey<Biome> YELLOW_AUTUMNAL_FOREST = register("yellow_autumnal_forest");
    public static final RegistryKey<Biome> RED_AUTUMNAL_FOREST = register("red_autumnal_forest");
    public static final RegistryKey<Biome> PURPLE_AUTUMNAL_FOREST = register("purple_autumnal_forest");

    public static final RegistryKey<Biome> AUTUMNAL_FOREST_EDGE = register("autumnal_forest_edge");
}
