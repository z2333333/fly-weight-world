package com.github.zx.object.build;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.github.zx.utils.AssetsNameSpace;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zx
 * @Date: 2019/8/20 16:11
 */
public class ConnectorFactory {

    private static final String ROCK_KEY = "rock";
    private static Map<String,IConnector> connectorMap = new HashMap<String, IConnector>();

    public static IConnector getRockConnector(ConnectorEnum connectorEnum){
        final String key = ROCK_KEY + connectorEnum;
        final String rockAssets = AssetsNameSpace.core$assets$textures$buliding$linked$Rock_Atlas$png;
        if (connectorMap.containsKey(key)) {
            return connectorMap.get(key);
        }

        Texture texture = new Texture(Gdx.files.internal(rockAssets));
        TextureRegion[][] textureRegions = TextureRegion.split(texture, IConnector.weight, IConnector.height);

        /*if (textureRegions.length != ConnectorEnum.values().length) {
            throw new Exception("名称与切割数组个数不匹配");
        }*/

        int interval = IConnector.connectorWeight/IConnector.height-1;
        for (int x=0;x<=interval;x++) {
            for (int y=0;y<=interval;y++) {
                int index = x*interval+x+y;
                ConnectorObject connectorObject = new ConnectorObject(textureRegions[x][y],ConnectorEnum.values()[index]);
                connectorMap.put(ROCK_KEY+ConnectorEnum.values()[index],connectorObject);
            }
        }
        return connectorMap.get(ROCK_KEY+connectorEnum);
    }
}
