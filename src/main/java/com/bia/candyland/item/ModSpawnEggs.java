package com.bia.candyland.item;

import com.bia.candyland.CandyLandMod;
import com.bia.candyland.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSpawnEggs {
    public static final DeferredRegister<Item> SPAWN_EGGS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CandyLandMod.MOD_ID);

    public static final RegistryObject<Item> GUMMY_BEAR_SPAWN_EGG = SPAWN_EGGS.register("gummy_bear_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GUMMY_BEAR, 0x00FF00, 0x006400, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        SPAWN_EGGS.register(eventBus);
    }
}
