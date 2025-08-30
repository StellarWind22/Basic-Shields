package com.stellarwind22.basicshields.neoforge.init;

import com.stellarwind22.basicshields.init.BasicShields;
import net.neoforged.fml.common.Mod;

@Mod(BasicShields.MOD_ID)
public final class BasicShieldsNeoForge {
    public BasicShieldsNeoForge() {
        // Run our common setup.
        BasicShields.init();
    }
}
