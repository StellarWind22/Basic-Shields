package com.stellarwind22.basicshields.fabric.init;

import com.stellarwind22.basicshields.init.BasicShieldsClient;
import net.fabricmc.api.ClientModInitializer;

public final class BasicshieldsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        BasicShieldsClient.init();
    }
}
