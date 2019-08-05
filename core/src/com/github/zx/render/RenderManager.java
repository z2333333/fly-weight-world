package com.github.zx.render;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

    private final SpriteBatch spriteBatch = new SpriteBatch();
    private OrthographicCamera camera = new OrthographicCamera();
    private Map<String,Render> renderMap = new HashMap<String, Render>();
    private final ConcurrentHashMap<Object, Chunk> worldObjectChunkMap = new ConcurrentHashMap<Object, Chunk>();

    //todo 读取配置(渲染器与脚本的绑定),先写成代码

    public RenderManager(){
        renderMap.put(StaticRender.class.getSimpleName(),RenderFactory.CreateStaticRender(spriteBatch));
    }

    public void draw(){
        Set<Map.Entry<String, Render>> entries = renderMap.entrySet();
        for (Map.Entry<String, Render> entry : entries) {
            entry.getValue().draw();
        }
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

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }
}