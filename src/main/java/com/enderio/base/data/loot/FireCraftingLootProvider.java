package com.enderio.base.data.loot;

import com.enderio.EnderIO;
import com.enderio.base.common.init.EIOItems;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class FireCraftingLootProvider implements LootTableSubProvider {

    public FireCraftingLootProvider() {
    }

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> writer) {
        LootTable.Builder infinity = LootTable
            .lootTable()
            .withPool(LootPool
                .lootPool()
                .name("infinity_in_world_crafting")
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(EIOItems.GRAINS_OF_INFINITY.get()).when(LootItemRandomChanceCondition.randomChance(0.5f))))
            .setParamSet(LootContextParamSet.builder().build());

        writer.accept(EnderIO.loc("fire_crafting/infinity"), infinity);
    }
}
