package xxrexraptorxx.enhanced_nature.main;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.enhanced_nature.utils.Config;
import xxrexraptorxx.enhanced_nature.world.ModConfiguredFeatures;
import xxrexraptorxx.enhanced_nature.world.ModPlacedFeatures;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/enhancednature
 **/
@Mod(References.MODID)
public class EnhancedNature {

    public static final Logger LOGGER = LogManager.getLogger();

    public EnhancedNature() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.init();
        Config.init();

        ModConfiguredFeatures.register(modbus);
        ModPlacedFeatures.register(modbus);
    }
}