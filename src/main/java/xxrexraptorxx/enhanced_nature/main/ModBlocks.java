package xxrexraptorxx.enhanced_nature.main;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.enhanced_nature.blocks.BlockQuicksand;

public class ModBlocks {


    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(References.MODID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final DeferredBlock<BlockQuicksand> QUICK_SAND = BLOCKS.register("quicksand", BlockQuicksand::new);
    public static final DeferredItem<Item> QUICK_SAND_BLOCKITEM = ITEMS.register("quicksand", () -> new BlockItem(QUICK_SAND.get(), new Item.Properties()));
}
