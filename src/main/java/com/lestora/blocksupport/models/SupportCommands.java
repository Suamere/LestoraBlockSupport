package com.lestora.blocksupport.models;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
class SupportCommands {

    @SubscribeEvent
    static void onRegisterCommands(RegisterCommandsEvent event) {
        var dispatcher = event.getDispatcher();
        // Optional: Restrict to ops (permission level 2+)
        var root = Commands.literal("lestora")
                .requires(source -> source.hasPermission(2));

        registerPrintBlock(root);

        dispatcher.register(root);
    }

    static void registerPrintBlock(LiteralArgumentBuilder<CommandSourceStack> root) {
        root.then(Commands.literal("blockSupport")
                .then(Commands.literal("print")
                        .executes(ctx -> {
                            try {
                                ServerPlayer player = ctx.getSource().getPlayerOrException();
                                EntityBlockInfo info = SupportBlock.calculate(player);
                                String infoStr = (info != null)
                                        ? StandingBlockUtil.getSupportingBlockType(info) + " " + info.getSupportingPos()
                                        : "No supporting block found";
                                player.displayClientMessage(Component.literal(infoStr), false);
                            } catch (Exception e) {
                                // Log the exception to the console so you can see what went wrong.
                                e.printStackTrace();
                                ctx.getSource().sendFailure(Component.literal("An error occurred: " + e.getMessage()));
                            }
                            return 1;
                        })
                )
        );
    }
}
