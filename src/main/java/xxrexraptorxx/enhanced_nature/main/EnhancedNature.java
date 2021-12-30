package xxrexraptorxx.enhanced_nature.main;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.enhanced_nature.utils.Config;

@Mod(References.MODID)
public class EnhancedNature {

    public static final Logger LOGGER = LogManager.getLogger();

    public EnhancedNature() {
        ModBlocks.init();
        Config.init();
    }
}