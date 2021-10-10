package fireopal.autumnalforest;

import fireopal.autumnalforest.biomes.AutumnalForestBiomes;
import fireopal.autumnalforest.features.AutumnalForestConfiguredFeatures;
import fireopal.autumnalforest.gen.AutumnalForestBiomeAdditions;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class AutumnalForest implements ModInitializer {
	public static final String MODID = "autumnal_forests";

	@Override
	public void onInitialize() {
		AutumnalForestConfiguredFeatures.init();
		AutumnalForestBiomes.init();
		AutumnalForestBiomeAdditions.init();
	}

	public static Identifier id(String id) {
		return new Identifier(MODID, id);
	}
}
