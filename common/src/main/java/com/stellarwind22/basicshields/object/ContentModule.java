package com.stellarwind22.basicshields.object;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class ContentModule {

    public static final List<ContentModule> modules = new ArrayList<>();
    public static ModRegister register;

    public static void registerModulesContent(String modId, List<String> loadedMods) {
        register = new ModRegister(modId);
        for(ContentModule module : modules) {
            module.tryLoad(register, loadedMods);
        }
    }

    private boolean isLoaded = false;
    private final Supplier<Boolean> forceLoad;
    private final String[] dependsOn;

    public ContentModule(Supplier<Boolean> forceLoad, String...dependsOn) {
        modules.add(this);
        this.forceLoad = forceLoad;
        this.dependsOn = dependsOn;
    }

    public void tryLoad(ModRegister register, List<String> loadedMods) {
        boolean shouldLoad = this.forceLoad.get();

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

        if(shouldLoad) {
            this.isLoaded = true;
            addContent(register);
        }
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    abstract void addContent(ModRegister register);
}
