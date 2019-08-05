package com.github.zx.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @Author: zx
 * @Date: 2019/8/2 11:22
 */
public class StaticRender extends RenderAbstract{

    public StaticRender(SpriteBatch spriteBatch) {
        super(spriteBatch);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void dispose() {

    }
    //queen保存持有对象
    //todo 普通地面,泥泞地面,挖掘后的地面

}
