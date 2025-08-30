package com.stellarwind22.basicshields.object;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class ModRegister {

    private final String modId;
    private final DeferredRegister<Item> MOD_ITEMS;

    public ModRegister(String modId) {
        this.modId = modId;
        MOD_ITEMS = DeferredRegister.create(modId, Registries.ITEM);
    }

    public String getModId() {
        return this.modId;
    }

    public void registerContent() {
        MOD_ITEMS.register();
    }
}
