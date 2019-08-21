package com.github.zx.object.build;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @Author: zx
 * @Date: 2019/8/20 15:34
 * 各种可连接对象的接口
 */
public interface IConnector {

    int weight = 80;
    int height = 80;
    int connectorWeight = 320;

    TextureRegion getTextureRegion();
}
