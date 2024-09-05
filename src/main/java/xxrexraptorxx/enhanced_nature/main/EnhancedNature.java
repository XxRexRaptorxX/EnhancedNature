package xxrexraptorxx.enhanced_nature.main;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.enhanced_nature.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage <a href="https://www.curseforge.com/minecraft/mc-mods/enhancednature">...</a>
 **/
@Mod(References.MODID)
public class EnhancedNature {

    public static final Logger LOGGER = LogManager.getLogger();

    public EnhancedNature(IEventBus bus, ModContainer container) {
        ModBlocks.init(bus);
        Config.init(container);

        bus.addListener(this::addCreative);
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.QUICK_SAND);
        }
    }
}