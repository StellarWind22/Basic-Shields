package com.stellarwind22.basicshields.init;

import com.stellarwind22.basicshields.object.ContentModule;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BasicShieldsClient {

    public static void init() {
        //Client common init code
        ContentModule.loadModulesClient(BasicShields.BASIC_SHIELDS_REGISTER);
    }
}
