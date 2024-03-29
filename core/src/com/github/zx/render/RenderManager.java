package com.github.zx.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.github.zx.object.ISprite;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zx
 * @Date: 2019/8/1 17:08
 */
public class RenderManager {

    private final CameraManager cameraManager;
    /**Spritebatch不能绘制多边形纹理,而在两个batch之前切换会导致许多不必要的批量刷新,全局用PolygonSpriteBatch
     * https://www.badlogicgames.com/wordpress/?p=3289
     */
    //private final SpriteBatch spriteBatch = new SpriteBatch();
    private final PolygonSpriteBatch spriteBatch = new PolygonSpriteBatch();
    private Map<String,Render> renderMap = new HashMap<String, Render>();
    private final ConcurrentHashMap<Object, Chunk> worldObjectChunkMap = new ConcurrentHashMap<Object, Chunk>();

    //todo 读取配置(渲染器与脚本的绑定),先写成代码

    public RenderManager(){
        cameraManager = new CameraManager();
        renderMap.put(StaticRender.class.getSimpleName(),RenderFactory.CreateStaticRender(spriteBatch));
    }

    public void draw(){
        Set<Map.Entry<String, Render>> entries = renderMap.entrySet();
        for (Map.Entry<String, Render> entry : entries) {
            entry.getValue().draw();
        }
        cameraManager.handleInput();
        spriteBatch.setProjectionMatrix(cameraManager.getCamera().combined);
        cameraManager.getCamera().update();
    }

    //放入一个sprite的方法，分别存入外部map和对应render存储
    public void setWorldObjectChunkMap(int x, int y, ISprite sprite, Class classz){
        String chunkKey = x+"_"+y;
        if (worldObjectChunkMap.get(chunkKey) == null) {
            Chunk chunk = new Chunk();
            worldObjectChunkMap.put(chunkKey,chunk);
        }
        worldObjectChunkMap.get(chunkKey).putChunkItem(sprite,classz);
        renderMap.get(classz.getSimpleName()).addObject(sprite);
    }

    public Render getRender(Class classz){
        return renderMap.get(classz.getSimpleName());
    }

    public Batch getSpriteBatch() {
        return spriteBatch;
    }

    public CameraManager getCameraManager() {
        return cameraManager;
    }
}