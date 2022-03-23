package xxrexraptorxx.enhanced_nature.utils;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import xxrexraptorxx.enhanced_nature.main.References;
import xxrexraptorxx.enhanced_nature.world.OreGenerator;

@Mod.EventBusSubscriber(modid = References.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addListener(OreGenerator::onBiomeLoadingEvent);
    }


    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            OreGenerator.registerConfiguredFeatures();
        });
    }

}
