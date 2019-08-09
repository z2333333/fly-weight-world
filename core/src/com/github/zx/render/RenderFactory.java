package com.github.zx.render;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * @Author: zx
 * @Date: 2019/8/1 18:35
 */
public class RenderFactory {

    public static Render CreateStaticRender(Batch spriteBatch){
        return new StaticRender(spriteBatch);
    }

}
