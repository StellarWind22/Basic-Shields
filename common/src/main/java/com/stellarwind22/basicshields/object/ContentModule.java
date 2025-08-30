package com.stellarwind22.basicshields.object;

import com.stellarwind22.basicshields.init.BasicShields;

import java.util.ArrayList;
import java.util.List;

public abstract class ContentModule {

    public static final List<ContentModule> modules = new ArrayList<>();
    public static ModRegister register;

    public static void loadModules(ModRegister register, List<String> loadedMods) {
        for(ContentModule module : modules) {
            if(module.shouldLoad(loadedMods)) {
                module.setLoaded(true);
                module.load(register);
            }
        }
        register.register();
    }

    public static void loadModulesClient(ModRegister register) {
        for(ContentModule module : modules) {
            if(module.isLoaded) module.loadClient(register);
        }
        register.registerClient();
    }

    private boolean isLoaded = false;
    private final List<String> dependsOn;

    public ContentModule(List<String> dependsOn) {
        modules.add(this);
        this.dependsOn = dependsOn;
    }

    public boolean shouldLoad(List<String> loadedMods) {
        //Handle force loading
        boolean shouldLoad = BasicShields.isDev();

        if(!shouldLoad) {
            boolean hasDepends = true;
            for(String dependMod : dependsOn) {
                if (!loadedMods.contains(dependMod)) {
                    hasDepends = false;
                    break;
                }
            }
            shouldLoad = hasDepends;
        }

        return shouldLoad;
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    protected void setLoaded(boolean loaded) {
        this.isLoaded = loaded;
    }

    abstract void load(ModRegister register);
    abstract void loadClient(ModRegister register);
}
