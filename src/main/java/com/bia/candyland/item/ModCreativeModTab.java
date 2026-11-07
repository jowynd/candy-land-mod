package com.bia.candyland.item;

import com.bia.candyland.CandyLandMod;
import com.bia.candyland.block.ModBlocks;
import com.bia.candyland.item.ModSpawnEggs;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CandyLandMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CANDY_LAND_TAB = CREATIVE_MOD_TAB.register("candy_land_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CANDY_CANE.get()))
                    .title(Component.translatable("creativetab.candy_land_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        //items
                        pOutput.accept(ModItems.CANDY_CANE.get());
                        pOutput.accept(ModItems.BROWN_SUGAR_CRYSTAL.get());
                        pOutput.accept(ModItems.SUGAR_CRYSTAL.get());

                        //blocks
                        pOutput.accept(ModBlocks.GUMBALL_BLOCK.get());
                        pOutput.accept(ModBlocks.CANDY_BLOCK.get());
                        pOutput.accept(ModBlocks.CHOCOLATE_CAKE_BLOCK.get());
                        pOutput.accept(ModBlocks.GRANULATED_CHOCOLATE_CAKE_BLOCK.get());
                        pOutput.accept(ModBlocks.SUGAR_CRYSTAL_ORE.get());

                        //spawn eggs
                        pOutput.accept(ModSpawnEggs.GUMMY_BEAR_SPAWN_EGG.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TAB.register(eventBus);
    }
}
