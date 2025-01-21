package net.flynnvali.fdtweaks.util;
import net.flynnvali.fdtweaks.FDTweaks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;


public class FDTweaksTags   {

    public static class Items{
        public static final TagKey<Item> VARNISHES = tag("varnishes");
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(FDTweaks.MOD_ID, name));
        }
    }
}
