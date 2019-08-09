package com.github.zx.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.zx.object.ISprite;

import java.util.List;

/**
 * @Author: zx
 * @Date: 2019/8/1 17:51
 */
public interface Render {

    /**
     * 初始化自身(持有的object,通过配置文件)
     */
    void initialize();

    /**
     * 完成所持有sprite的绘制
     */
    void draw();

    /**
     * 释放资源
     */
    void dispose();

    void setSpriteBatch(Batch spriteBatch);
    Batch getRenderSpriteBatch();
    List<ISprite> getRenderObjectList();
    boolean addObject(ISprite sprite);
}
