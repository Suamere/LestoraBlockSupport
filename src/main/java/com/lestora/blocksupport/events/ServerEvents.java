package com.lestora.blocksupport.events;

import com.lestora.blocksupport.models.SupportBlock;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ServerEvents {
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        var player = Minecraft.getInstance().player;
        if (player != null) {
            SupportBlock.calculate(player);
        }
    }
}