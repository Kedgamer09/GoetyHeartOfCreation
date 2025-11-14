package net.kedgamer.ghoc.item;

import com.Polarice3.Goety.api.magic.SpellType;
import com.Polarice3.Goety.common.items.magic.DarkWand;
import net.kedgamer.ghoc.GHoC;
import net.kedgamer.ghoc.item.custom.UniverseCoreItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GHoC.MOD_ID);

    public static final RegistryObject<Item> SPELLSTONE_MIXTURE = ITEMS.register("spellstone_mixture",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHARM_MIXTURE = ITEMS.register("charm_mixture",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCROLL_MIXTURE = ITEMS.register("scroll_mixture",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RING_MIXTURE = ITEMS.register("ring_mixture",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNIVERSE_CORE = ITEMS.register("universe_core",
            () -> new UniverseCoreItem(new Item.Properties()));
    public static final RegistryObject<Item> SKULL_MIXTURE = ITEMS.register("skull_mixture",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNWITNESSED_GEM = ITEMS.register("unwitnessed_gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TEST_WAND = ITEMS.register("test_wand",
            () -> new DarkWand(new Item.Properties(), SpellType.NONE));
    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new UniverseCoreItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}