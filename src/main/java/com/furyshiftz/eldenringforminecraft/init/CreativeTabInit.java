package com.furyshiftz.eldenringforminecraft.init;

import com.furyshiftz.eldenringforminecraft.EldenRingForMinecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = EldenRingForMinecraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EldenRingForMinecraft.MODID);

    public static final List<Supplier<? extends ItemLike>> ELDEN_RING_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> ELDEN_RING_TAB = TABS.register("elden_ring_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.elden_ring_tab"))
                    .icon(ItemInit.MYTHRITE_INGOT.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                            ELDEN_RING_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                    .withSearchBar()
                    .build()
    );

   public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        ELDEN_RING_TAB_ITEMS.add(itemLike);
        return itemLike;
    }

  /*   @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.getEntries().putAfter(Items.ACACIA_LOG.getDefaultInstance(), ItemInit.MYTHRITE_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if(event.getTab() == ELDEN_RING_TAB.get()) {
            event.accept(Items.CROSSBOW);
        }
    }*/
}