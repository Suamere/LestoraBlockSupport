package com.lestora.blocksupport.models;

import net.minecraft.core.BlockPos;

class Coordinates {
    private final int x;
    private final int y;
    private final int z;

    Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    static Coordinates fromPos(BlockPos pos) {
        return new Coordinates(pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public String toString() {
        return x + ", " + y + ", " + z;
    }
}