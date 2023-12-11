package net.ethan.randomadditions.item;

import net.ethan.randomadditions.RandomAdditions;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = //a long list of items to add
            DeferredRegister.create(ForgeRegistries.ITEMS, RandomAdditions.MOD_ID);
    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_JADE = ITEMS.register("raw_jade",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) { //registers deferredregisters
        ITEMS.register(eventBus);
    }
}
