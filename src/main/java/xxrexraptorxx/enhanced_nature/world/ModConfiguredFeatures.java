package xxrexraptorxx.enhanced_nature.world;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.enhanced_nature.main.ModBlocks;
import xxrexraptorxx.enhanced_nature.main.References;

import java.util.List;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, References.MODID);


    public static final Supplier<List<OreConfiguration.TargetBlockState>> QUICKSAND_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.SAND), ModBlocks.QUICK_SAND.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> CLAY_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.CLAY.defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> COBBLESTONE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.COBBLESTONE.defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> INFESTED_STONE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.INFESTED_STONE.defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SAND_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.SAND.defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SANDSTONE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.SANDSTONE.defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> DEEPSLATE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.DEEPSLATE.defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> COBBLED_DEEPSLATE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.COBBLED_DEEPSLATE.defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> STONE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.STONE.defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> CALCITE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.CALCITE.defaultBlockState())));



    public static final RegistryObject<ConfiguredFeature<?, ?>> QUICKSAND = CONFIGURED_FEATURES.register("quicksand",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(QUICKSAND_GEN.get(),20)));//TODO size

    public static final RegistryObject<ConfiguredFeature<?, ?>> CLAY = CONFIGURED_FEATURES.register("clay",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CLAY_GEN.get(),20)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> COBBLESTONE = CONFIGURED_FEATURES.register("cobblestone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(COBBLESTONE_GEN.get(),20)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> INFESTED_STONE = CONFIGURED_FEATURES.register("infested_stone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(INFESTED_STONE_GEN.get(),5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAND = CONFIGURED_FEATURES.register("sand",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAND_GEN.get(),20)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SANDSTONE = CONFIGURED_FEATURES.register("sandstone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SANDSTONE_GEN.get(),20)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> DEEPSLATE = CONFIGURED_FEATURES.register("deepslate",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DEEPSLATE_GEN.get(),15)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> COBBLED_DEEPSLATE = CONFIGURED_FEATURES.register("cobbled_deepslate",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(COBBLED_DEEPSLATE_GEN.get(),20)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> STONE = CONFIGURED_FEATURES.register("stone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(STONE_GEN.get(),20)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CALCITE = CONFIGURED_FEATURES.register("calcite",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CALCITE_GEN.get(),15)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}