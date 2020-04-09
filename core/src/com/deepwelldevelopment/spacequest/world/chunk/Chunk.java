package com.deepwelldevelopment.spacequest.world.chunk;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.deepwelldevelopment.spacequest.block.IBlockProvider;
import com.deepwelldevelopment.spacequest.client.render.VoxelMesh;
import com.deepwelldevelopment.spacequest.world.World;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Chunk {

    //TODO: light values

    private static final ExecutorService executorService =
            Executors.newFixedThreadPool(
                    Runtime.getRuntime().availableProcessors() - 1);

    //TODO: world gen

    private final byte[] map;
    private final IBlockProvider blockProvider;
    private final Vector3 worldPosition;
    private final int chunkPosX;
    private final int chunkPosZ;
    private final Object syncToken = new Object();

    //TODO: rendering stuff and more world gen

    private World world;

    //TODO: break data

    //TODO: add biome and more init stuff
    public Chunk(World world, IBlockProvider blockProvider,
            Vector3 worldPosition, int chunkPosX, int chunkPosZ) {
        this.world = world;
        this.blockProvider = blockProvider;
        this.worldPosition = worldPosition;
        this.chunkPosX = chunkPosX;
        this.chunkPosZ = chunkPosZ;
        //more init
        this.map = new byte[World.CHUNK_WIDTH * World.CHUNK_WIDTH *
                World.MAX_HEIGHT];
        //more init
    }

    //TODO: chunk methods

    public Vector3 getWorldPosition() {
        return worldPosition;
    }

    public int getBlockCounter() {
        return 0;
    }

    public void setActive(boolean active) {
    }

    public Array<VoxelMesh> getMeshes() {
        return null;
    }

    public Array<VoxelMesh> getAlphaMeshes() {
        return null;
    }

    public boolean isRecalculating() {
        return false;
    }

    public byte getByte(int i, int i1, int i2) {
        return 0;
    }

    public byte getBlockLight(int x1, int y1, int z1) {
        return 0;
    }
}
