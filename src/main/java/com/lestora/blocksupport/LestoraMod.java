package com.lestora.blocksupport;

import com.lestora.blocksupport.debug.DebugOverlayHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("lestora_block_support")
public class LestoraMod {
    public LestoraMod(FMLJavaModLoadingContext constructContext) {
        if (net.minecraftforge.fml.ModList.get().isLoaded("lestora_debug")) {
            DebugOverlayHandler.register();
        }
    }
}