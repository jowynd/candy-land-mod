//package com.bia.candyland.block;
//
//import com.bia.candyland.CandyLandMod;
//import com.bia.candyland.item.ModItems;
//import net.minecraft.world.item.BlockItem;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//import javax.naming.directory.ModificationItem;
//import java.util.function.Supplier;
//
//public class ModBlocks {
//    public static final DeferredRegister<Block> BLOCKS =
//            DeferredRegister.create(ForgeRegistries.BLOCKS, CandyLandMod.MOD_ID);
//
//
//
//private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
//    RegistryObject<T> toReturn = Blocks.register(name, block);
//    registerBlockItem(name, toReturn);
//    return toReturn;
//}
//
//    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
//        return ModItems.ITENS.register(name, () -> new BlockItem(Block.get(), new Item.properties()));
//    }
//
//    public static void register (IEventBus eventBus) {
//        BLOCKS.register(eventBus);
//    }
//}