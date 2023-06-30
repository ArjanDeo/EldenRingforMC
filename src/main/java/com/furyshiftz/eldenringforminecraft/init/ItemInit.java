package com.furyshiftz.eldenringforminecraft.init;

import com.furyshiftz.eldenringforminecraft.EldenRingForMinecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EldenRingForMinecraft.MODID);
    // Basic Items
    public static final RegistryObject<Item>  MYTHRITE_INGOT = ITEMS.register("mythrite_ingot",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.RARE)));
    public static final RegistryObject<Item>  SPIRIT_CALLING_BELL = ITEMS.register("spirit_calling_bell",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
    //Music Discs
    public static final RegistryObject<Item>  GOSKIN_APOSTLE_DISC = ITEMS.register("godskin_apostle_music_disc",
            () -> new RecordItem(4, SoundInit.GODSKIN_APOSTLE_THEME, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 5500));
    // Food
    public static final RegistryObject<Item>  PRAWN = ITEMS.register("prawn",
            () -> {
                return new Item(new Item.Properties()
                        .food(new FoodProperties.Builder()
                                .fast()
                                .nutrition(2)
                                .saturationMod(0.3F)
                                .effect(new MobEffectInstance(MobEffects.POISON, 100, 0), 0.6F).build())
                                .rarity(Rarity.COMMON));
            });
    public static final RegistryObject<Item>  BOILED_PRAWN = ITEMS.register("boiled_prawn",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().fast().nutrition(5).saturationMod(0.6F).build())));
    // Block Items
    public static final RegistryObject<BlockItem> MYTHRITE_BLOCK = ITEMS.register("mythrite_block", () -> new BlockItem(BlockInit.MYTHRITE_BLOCK.get(), new Item.Properties().rarity(Rarity.RARE)));
}