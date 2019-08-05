package com.github.zx.render;

import com.github.zx.object.ISprite;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zx
 * @Date: 2019/8/2 17:32
 * 存储地图方块的容器
 */
public class Chunk {

    //renderName,序号
    private Map<String, ISprite> chunk;

    public Chunk(){
        this.chunk = new HashMap<String, ISprite>();
    }

    public Map<String, ISprite> getChunk(){
        return this.chunk;
    }

    public void putChunkItem(ISprite sprite,Class classz){
        chunk.put(classz.getSimpleName()+chunk.size(),sprite);
    }
}
