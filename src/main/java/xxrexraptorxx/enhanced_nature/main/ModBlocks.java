package xxrexraptorxx.enhanced_nature.main;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.enhanced_nature.blocks.BlockQuicksand;

import java.util.function.Supplier;

public class ModBlocks {


    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(References.MODID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.MODID);

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final DeferredBlock<BlockQuicksand> QUICK_SAND = registerBlock("quicksand", BlockQuicksand::new);



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem registerBlockItem(String name, DeferredBlock<T> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
