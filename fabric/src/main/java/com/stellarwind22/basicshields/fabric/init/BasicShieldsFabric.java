package com.stellarwind22.basicshields.fabric.init;

import com.stellarwind22.basicshields.init.BasicShields;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.util.ArrayList;
import java.util.List;

public final class BasicShieldsFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        List<String> modIds = new ArrayList<>();
        FabricLoader.getInstance().getAllMods().forEach((modContainer -> {
            modIds.add(modContainer.getMetadata().getId());
        }));

        // Run our common setup.
        BasicShields.init(
                FabricLoader.getInstance().isDevelopmentEnvironment(),
                modIds
        );
    }
}
