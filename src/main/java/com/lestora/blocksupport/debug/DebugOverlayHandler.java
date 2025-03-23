package com.lestora.blocksupport.debug;

import com.lestora.blocksupport.models.SupportBlock;
import com.lestora.blocksupport.models.StandingBlockUtil;
import com.lestora.debug.DebugOverlay;
import com.lestora.debug.models.DebugObject;
import com.lestora.debug.models.DebugSupplier;
import net.minecraft.client.Minecraft;

public class DebugOverlayHandler {
    public static void register() {
        DebugSupplier supportSupplier = new DebugSupplier("Lestora_SupportBlock", 11, () -> {
            var supportBlock = SupportBlock.getSupportBlock(Minecraft.getInstance().player);
            var blockStr = StandingBlockUtil.getSupportingBlockType(supportBlock);
            String infoStr = blockStr + " " + supportBlock.getSupportingPos();
            int color = 16776960;
            return new DebugObject("Support", color, false, blockStr, color, false,
                    "Supporting Block", color, true, infoStr, color, true);
        });
        DebugOverlay.registerDebugLine(supportSupplier.getKey(), supportSupplier);
    }
}