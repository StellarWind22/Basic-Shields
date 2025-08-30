package com.stellarwind22.basicshields.object;

import dev.architectury.registry.registries.DeferredRegister;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModRegister {

    private final DeferredRegister<Item> modItems;
    private final DeferredRegister<Block> modBlocks;

    public ModRegister(String modId) {
        modItems = DeferredRegister.create(modId, Registries.ITEM);
        modBlocks = DeferredRegister.create(modId, Registries.BLOCK);
    }

    public void register() {
        modItems.register();
        modBlocks.register();
    }

    @Environment(EnvType.CLIENT)
    public void registerClient() {

    }
}
