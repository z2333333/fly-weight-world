package com.github.zx.object.build;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @Author: zx
 * @Date: 2019/8/20 15:41
 */
public class ConnectorObject implements IConnector{

    private TextureRegion textureRegion;
    private ConnectorEnum connectorEnum;

    public ConnectorObject(TextureRegion textureRegion,ConnectorEnum connectorEnum){
        this.textureRegion = textureRegion;
        this.connectorEnum = connectorEnum;
    }

    @Override
    public TextureRegion getTextureRegion() {
        return textureRegion;
    }
}
