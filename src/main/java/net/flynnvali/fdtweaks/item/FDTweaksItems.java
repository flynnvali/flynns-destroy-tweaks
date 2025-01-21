package net.flynnvali.fdtweaks.item;
import net.flynnvali.fdtweaks.FDTweaks;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FDTweaksItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FDTweaks.MOD_ID);
    public static final RegistryObject<Item> POTATO_STARCH = ITEMS.register("potato_starch",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
