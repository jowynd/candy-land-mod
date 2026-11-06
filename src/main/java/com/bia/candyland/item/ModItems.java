package com.bia.candyland.item;

import com.bia.candyland.CandyLandMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CandyLandMod.MOD_ID);

    public static final RegistryObject<Item> CANDY_CANE = ITEMS.register("candy_cane",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BROWN_SUGAR_CRYSTAL = ITEMS.register("brown_sugar_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUGAR_CRYSTAL = ITEMS.register("sugar_crystal",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
