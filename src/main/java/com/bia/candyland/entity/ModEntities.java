package com.bia.candyland.entity;

import com.bia.candyland.CandyLandMod;
import com.bia.candyland.entity.custom.GummyBearEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CandyLandMod.MOD_ID);

    public static final RegistryObject<EntityType<GummyBearEntity>> GUMMY_BEAR =
            ENTITY_TYPES.register("gummy_bear",
                    () -> EntityType.Builder.of(GummyBearEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.2F)
                            .build("gummy_bear"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
