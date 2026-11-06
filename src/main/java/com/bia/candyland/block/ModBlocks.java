package com.bia.candyland.block;

import com.bia.candyland.CandyLandMod;
import com.bia.candyland.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CandyLandMod.MOD_ID);

    public static final RegistryObject<Block> GUMBALL_BLOCK = registerBlock("gumball_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.HONEY_BLOCK)));

    public static final RegistryObject<Block> CANDY_BLOCK = registerBlock("candy_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CHOCOLATE_CAKE_BLOCK = registerBlock("chocolate_cake_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.WOOL)));

    public static final RegistryObject<Block> GRANULATED_CHOCOLATE_CAKE_BLOCK = registerBlock("granulated_chocolate_cake_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.ROOTED_DIRT)));

    public static final RegistryObject<Block> SUGAR_CRYSTAL_ORE = registerBlock("sugar_crystal_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}