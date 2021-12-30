package xxrexraptorxx.enhanced_nature.world;

import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xxrexraptorxx.enhanced_nature.main.ModBlocks;
import xxrexraptorxx.enhanced_nature.main.References;
import xxrexraptorxx.enhanced_nature.utils.Config;

import java.util.List;

@Mod.EventBusSubscriber(modid = References.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OreGenerator {

    public static final RuleTest SAND = new BlockMatchTest(Blocks.SAND);
    public static final RuleTest DIRT = new BlockMatchTest(Blocks.DIRT);


    @SubscribeEvent
    public static void oreGeneration(final BiomeLoadingEvent event) {

        if(Config.WORLD_GENERATION.get()) {
            genOre(event.getGeneration(), OreFeatures.STONE_ORE_REPLACEABLES, Blocks.CLAY.defaultBlockState(), 20, 0, 80, Config.CLAY_VEIN_RARITY.get());
            genOre(event.getGeneration(), OreFeatures.STONE_ORE_REPLACEABLES, Blocks.COBBLESTONE.defaultBlockState(), 20, 0, 80, Config.COBBLESTONE_VEIN_RARITY.get());
            genOre(event.getGeneration(), OreFeatures.STONE_ORE_REPLACEABLES, Blocks.INFESTED_STONE.defaultBlockState(), 10, 0, 80, Config.SILVERFISH_BLOCK_VEIN_RARITY.get());
            genOre(event.getGeneration(), OreFeatures.STONE_ORE_REPLACEABLES, Blocks.SAND.defaultBlockState(), 20, 50, 200, Config.SAND_VEIN_RARITY.get());
            genOre(event.getGeneration(), OreFeatures.STONE_ORE_REPLACEABLES, Blocks.SANDSTONE.defaultBlockState(), 20, 30, 200, Config.SANDSTONE_VEIN_RARITY.get());
            genOre(event.getGeneration(), OreFeatures.STONE_ORE_REPLACEABLES, Blocks.DEEPSLATE.defaultBlockState(), 15, 0, 20, Config.DEEPSLATE_VEIN_RARITY.get());
            genOre(event.getGeneration(), OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.COBBLED_DEEPSLATE.defaultBlockState(), 20, -60, 0, Config.COBBLESTONE_VEIN_RARITY.get());
            genOre(event.getGeneration(), OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.STONE.defaultBlockState(), 20, -10, 0, Config.STONE_VEIN_RARITY.get());

            if (event.getCategory() == Biome.BiomeCategory.SWAMP) {
                genOre(event.getGeneration(), DIRT, ModBlocks.MUD.get().defaultBlockState(), 20, 50, 64, 20);
            }
            if (event.getCategory() == Biome.BiomeCategory.JUNGLE) {
                genOre(event.getGeneration(), SAND, ModBlocks.QUICK_SAND.get().defaultBlockState(), 20, 50, 100, 20);
            }
        }
    }


    private static void genOre(BiomeGenerationSettingsBuilder settings, RuleTest fillertype, BlockState state, int veinSize, int minHeight, int maxHeight, int maxperchunk) {
        settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(fillertype, state, veinSize))
                        .placed(List.of((CountPlacement.of(UniformInt.of(0, maxperchunk)))
                                , InSquarePlacement.spread()
                                , HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)), BiomeFilter.biome())));
    }

}
