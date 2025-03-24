package com.lestora.blocksupport.models;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SupportBlock {
    private static final Map<UUID, SupportBlock> supportMap = new ConcurrentHashMap<>();

    private boolean lastBlockSolid;
    private EntityBlockInfo supportingBlock;

    public static EntityBlockInfo getSupportBlock(Player player) {
        var supportBlock = supportMap.get(player.getUUID());
        if (supportBlock == null) return null;
        return supportBlock.supportingBlock;
    }

    public static EntityBlockInfo calculate(Player player) {
        SupportBlock playerSupport = supportMap.computeIfAbsent(player.getUUID(), id -> new SupportBlock());

        if (playerSupport.supportingBlock != null) {
            Block currentBlock = playerSupport.supportingBlock.getSupportingBlock().getBlock();
            if (currentBlock == Blocks.WATER) {
                playerSupport.lastBlockSolid = false;
            } else if (currentBlock != Blocks.AIR) {
                playerSupport.lastBlockSolid = true;
            }
        }

        playerSupport.supportingBlock = StandingBlockUtil.getSupportingBlock(player, playerSupport.lastBlockSolid);
        return playerSupport.supportingBlock;
    }
}