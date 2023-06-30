package com.furyshiftz.eldenringforminecraft;

import com.furyshiftz.eldenringforminecraft.init.BlockInit;
import com.furyshiftz.eldenringforminecraft.init.CreativeTabInit;
import com.furyshiftz.eldenringforminecraft.init.ItemInit;
import com.furyshiftz.eldenringforminecraft.init.SoundInit;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EldenRingForMinecraft.MODID)
public class EldenRingForMinecraft {
    public static final String MODID = "erfmc";

    public EldenRingForMinecraft() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        CreativeTabInit.TABS.register(bus);
        SoundInit.SOUND_EVENTS.register(bus);

    }
}
