package com.stellarwind22.basicshields.init;

import com.stellarwind22.basicshields.object.ContentModule;
import com.stellarwind22.basicshields.object.ModRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class BasicShields {
    public static final String MOD_ID = "basicshields";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ModRegister BASIC_SHIELDS_REGISTER = new ModRegister(MOD_ID);

    private static boolean isDev = false;

    public static void init(boolean dev, List<String> loadedMods) {
        // Write common init code here.
        isDev = dev;

        //Try load each module
        ContentModule.loadModules(BASIC_SHIELDS_REGISTER, loadedMods);
    }

    public static boolean isDev() {
        return isDev;
    }
}
