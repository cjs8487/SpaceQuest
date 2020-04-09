package com.deepwelldevelopment.spacequest.block;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.deepwelldevelopment.spacequest.client.render.IBlockRender;
import com.deepwelldevelopment.spacequest.client.render.block.BasicBlockRender;
import com.deepwelldevelopment.spacequest.world.chunk.Chunk;

public class Block {

    private final byte id;
    private String topTextureRegion;
    private String bottomTextureRegion;
    private String sidesTextureRegion;
    protected IBlockRender blockRender;
    private Vector2[] topTextureUVs;
    private Vector2[] bottomTextureUVs;
    private Vector2[] sidesTextureUVs;

    private int opacity;
    private boolean isLightSource;
    private Color tileColor;
    private boolean collidable;
    private float hardness;

    public Block(byte id, String topTextureRegion,
            String bottomTextureRegion, String sidesTextureRegion) {
        this.id = id;
        this.topTextureRegion = topTextureRegion;
        this.bottomTextureRegion = bottomTextureRegion;
        this.sidesTextureRegion = sidesTextureRegion;
        this.blockRender = new BasicBlockRender();
        this.opacity = 32;
        this.isLightSource = false;
        this.tileColor = Color.WHITE;
        this.collidable = true;
        this.hardness = 1.0f;
        //TODO: ItemBlock init
    }

    public Block(byte id, String textureRegion) {
        this(id, textureRegion, textureRegion, textureRegion);
    }

    //TODO: block behavior and rendering calculation methods


    public byte getId() {
        return id;
    }

    public String getTopTextureRegion() {
        return topTextureRegion;
    }

    public String getBottomTextureRegion() {
        return bottomTextureRegion;
    }

    public String getSidesTextureRegion() {
        return sidesTextureRegion;
    }

    //TODO: calculate UVs if they aren't already
    public Vector2[] getTopTextureUVs() {
        return topTextureUVs;
    }

    public Vector2[] getBottomTextureUVs() {
        return bottomTextureUVs;
    }

    public Vector2[] getSidesTextureUVs() {
        return sidesTextureUVs;
    }

    public int getOpacity() {
        return opacity;
    }

    public Block setOpacity(int opacity) {
        this.opacity = opacity;
        return this;
    }

    public boolean isLightSource() {
        return isLightSource;
    }

    public Block setLightSource(boolean lightSource) {
        isLightSource = lightSource;
        return this;
    }

    public Color getTileColor() {
        return tileColor;
    }

    public Block setTileColor(Color tileColor) {
        this.tileColor = tileColor;
        return this;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public Block setCollidable(boolean collidable) {
        this.collidable = collidable;
        return this;
    }

    public float getHardness() {
        return hardness;
    }

    public Block setHardness(float hardness) {
        this.hardness = hardness;
        return this;
    }

    public IBlockRender getBlockRender() {
        return blockRender;
    }

    public boolean drawSide(IBlockProvider blockProvider, Chunk chunk, int x, int y, int z,
            Side front) {
        return false;
    }

    public enum Side {
        FRONT(new Vector3(0, 0, 1)),
        BACK(new Vector3(0, 0, -1)),
        RIGHT(new Vector3(1, 0, 0)),
        LEFT(new Vector3(-1, 0, 0)),
        TOP(new Vector3(0, 1, 0)),
        BOTTOM(new Vector3(0, -1, 0));

        private Vector3 sideDirection;

        Side(Vector3 sideDirection) {
            this.sideDirection = sideDirection;
        }

        public byte getBlockAt(Chunk chunk, int x, int y, int z) {
            return chunk.getByte(x + (int) sideDirection.x, y + (int) sideDirection.y, z + (int) sideDirection.z);
        }
    }
}
