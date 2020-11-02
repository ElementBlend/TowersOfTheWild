package com._idrae.towers_of_the_wild.structures.pieces;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com._idrae.towers_of_the_wild.config.TowersOfTheWildConfig;
import com._idrae.towers_of_the_wild.register.JigsawRegistration;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.template.ProcessorLists;
import net.minecraftforge.fml.ModList;

public class OceanWarmTowerPools {

    public static boolean registered = false;

    public static void init(DynamicRegistries registries) {
        JigsawRegistration.registerPostSetup(TOP, registries);
    }

    public static JigsawPattern BOTTOM = JigsawRegistration.register(
            new JigsawPattern(
                    new ResourceLocation(TowersOfTheWild.MOD_ID, "ocean_warm_bottom"),
                    new ResourceLocation("empty"),
                    ImmutableList.of(
                            Pair.of(JigsawPiece.func_242851_a(TowersOfTheWild.MOD_ID + ":ocean_warm/ocean_warm_tower_bottom", ProcessorLists.field_244101_a), 1)),
                    JigsawPattern.PlacementBehaviour.RIGID)
    );

    public static JigsawPattern TOP =
            new JigsawPattern(
                    new ResourceLocation(TowersOfTheWild.MOD_ID, "ocean_warm_top"),
                    new ResourceLocation("empty"),
                    ImmutableList.of(
                            Pair.of(JigsawPiece.func_242851_a(
                                    ModList.get().isLoaded("waystones") && TowersOfTheWildConfig.waystonesCompat ?
                                            TowersOfTheWild.MOD_ID + ":ocean_warm/waystone_ocean_warm_tower_top" :
                                            TowersOfTheWild.MOD_ID + ":ocean_warm/ocean_warm_tower_top",
                                    ProcessorLists.field_244101_a), 1)),
                    JigsawPattern.PlacementBehaviour.RIGID);

}
