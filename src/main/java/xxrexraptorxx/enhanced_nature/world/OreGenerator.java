package xxrexraptorxx.enhanced_nature.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
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

    public static Holder<PlacedFeature> CLAY_GEN;
    public static Holder<PlacedFeature> COBBLESTONE_GEN;
    public static Holder<PlacedFeature> INFECTED_STONE_GEN;
    public static Holder<PlacedFeature> SAND_GEN;
    public static Holder<PlacedFeature> SANDSTONE_GEN;
    public static Holder<PlacedFeature> DEEPSLATE_GEN;
    public static Holder<PlacedFeature> COBBLED_DEEPSLATE_GEN;
    public static Holder<PlacedFeature> STONE_GEN;
    public static Holder<PlacedFeature> MUD_GEN;
    public static Holder<PlacedFeature> QUICK_SAND_GEN;


    public static void registerConfiguredFeatures() {
        OreConfiguration clayConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.CLAY.defaultBlockState(), 20);
        CLAY_GEN = registerPlacedFeature("clay", new ConfiguredFeature<>(Feature.ORE, clayConfig),
                CountPlacement.of(Config.CLAY_VEIN_RARITY.get()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)));

        OreConfiguration cobbleConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.COBBLESTONE.defaultBlockState(), 20);
        COBBLESTONE_GEN = registerPlacedFeature("cobblestone", new ConfiguredFeature<>(Feature.ORE, cobbleConfig),
                CountPlacement.of(Config.COBBLESTONE_VEIN_RARITY.get()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)));

        OreConfiguration infestedStoneConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.INFESTED_STONE.defaultBlockState(), 5);
        INFECTED_STONE_GEN = registerPlacedFeature("infested_stone", new ConfiguredFeature<>(Feature.ORE, infestedStoneConfig),
                CountPlacement.of(Config.SILVERFISH_BLOCK_VEIN_RARITY.get()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)));

        OreConfiguration sandConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.SAND.defaultBlockState(), 20);
        SAND_GEN = registerPlacedFeature("sand", new ConfiguredFeature<>(Feature.ORE, sandConfig),
                CountPlacement.of(Config.SAND_VEIN_RARITY.get()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)));

        OreConfiguration sandstoneConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.SANDSTONE.defaultBlockState(), 20);
        SANDSTONE_GEN = registerPlacedFeature("sandstone", new ConfiguredFeature<>(Feature.ORE, sandstoneConfig),
                CountPlacement.of(Config.SANDSTONE_VEIN_RARITY.get()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)));

        OreConfiguration deepslateConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.DEEPSLATE.defaultBlockState(), 15);
        DEEPSLATE_GEN = registerPlacedFeature("deepslate", new ConfiguredFeature<>(Feature.ORE, deepslateConfig),
                CountPlacement.of(Config.DEEPSLATE_VEIN_RARITY.get()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(20)));

        OreConfiguration cobbledDeepslateConfig = new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.COBBLED_DEEPSLATE.defaultBlockState(), 20);
        COBBLED_DEEPSLATE_GEN = registerPlacedFeature("cobbled_deepslate", new ConfiguredFeature<>(Feature.ORE, cobbledDeepslateConfig),
                CountPlacement.of(Config.COBBLESTONE_VEIN_RARITY.get()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(0)));

        OreConfiguration stoneDeepslateConfig = new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.STONE.defaultBlockState(), 20);
        STONE_GEN = registerPlacedFeature("stone_deepslate", new ConfiguredFeature<>(Feature.ORE, stoneDeepslateConfig),
                CountPlacement.of(Config.STONE_VEIN_RARITY.get()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(0)));

        OreConfiguration mudConfig = new OreConfiguration(DIRT, ModBlocks.MUD.get().defaultBlockState(), 20);
        MUD_GEN = registerPlacedFeature("mud", new ConfiguredFeature<>(Feature.ORE, mudConfig),
                CountPlacement.of(20),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(64)));

        OreConfiguration quickSandConfig = new OreConfiguration(SAND, ModBlocks.QUICK_SAND.get().defaultBlockState(), 20);
        QUICK_SAND_GEN = registerPlacedFeature("quicksand", new ConfiguredFeature<>(Feature.ORE, quickSandConfig),
                CountPlacement.of(20),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(100)));
    }


        private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
            return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
        }


        public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
            if (Config.WORLD_GENERATION.get()) {
                if (event.getCategory() == Biome.BiomeCategory.JUNGLE && Config.GENERATE_QUICKSAND.get()) {
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, QUICK_SAND_GEN);
                }
                if (event.getCategory() == Biome.BiomeCategory.SWAMP && Config.GENERATE_MUD.get()) {
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MUD_GEN);
                }
                if (event.getCategory() != Biome.BiomeCategory.THEEND && event.getCategory() != Biome.BiomeCategory.NETHER) {
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CLAY_GEN);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, COBBLESTONE_GEN);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, INFECTED_STONE_GEN);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SAND_GEN);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SANDSTONE_GEN);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DEEPSLATE_GEN);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, COBBLED_DEEPSLATE_GEN);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, STONE_GEN);
                }
            }
        }
}