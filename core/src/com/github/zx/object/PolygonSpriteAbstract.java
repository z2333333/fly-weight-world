package com.github.zx.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

/**
 * @Author: zx
 * @Date: 2019/8/9 17:32
 * 关于多边形点和三角,见:https://stackoverflow.com/questions/15733442/drawing-filled-polygon-with-libgdx
 */
public abstract class PolygonSpriteAbstract implements ISprite{

    private PolygonSprite polygonSprite;
    private PolygonRegion polygonRegion;

    public PolygonSpriteAbstract(Texture texture,float[] pointCoordinates){
        if (pointCoordinates.length==0) {
            int width = texture.getWidth();
            int height = texture.getHeight();
            pointCoordinates = new float[]{0,0,width,0,width,height,0,height,0,0};
        }
        polygonRegion = new PolygonRegion(new TextureRegion(texture),pointCoordinates,new short[] {0,1,2,0,2,3});
        polygonSprite = new PolygonSprite(polygonRegion);
    }

    public PolygonSpriteAbstract(Texture texture,String path){
        PolygonRegionLoader loader = new PolygonRegionLoader();
        PolygonRegion polygonRegion = loader.load(new TextureRegion(texture), Gdx.files.internal(path));
        this.polygonRegion = polygonRegion;
        this.polygonSprite = new PolygonSprite(this.polygonRegion);
    }

    public void setSprite(PolygonSprite sprite) {
        this.polygonSprite = sprite;
    }

    public PolygonSprite getSprite(){
        return polygonSprite;
    }

    public void draw(Batch batch) {
        polygonSprite.draw((PolygonSpriteBatch) batch);
    }
}
