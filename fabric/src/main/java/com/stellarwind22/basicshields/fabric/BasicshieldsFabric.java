package com.stellarwind22.basicshields.fabric;

import com.stellarwind22.basicshields.init.Basicshields;
import net.fabricmc.api.ModInitializer;

public final class BasicshieldsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Basicshields.init();
    }
}
