package com.github.zx.prepare;

import com.github.zx.utils.WorldConstant;

/**
 * @Author: zx
 * @Date: 2019/8/12 15:27
 */
public class TerrainGeneration {

    public static float[] generateIrregularSurface(int weight, int height, float x, float y) {
        int mapSideLength = WorldConstant.basicUnitOfSize * WorldConstant.mapSize;
        //最小步进距离为0.5*basicUnitOfSize
        float minStepDistance = 0.5f * WorldConstant.basicUnitOfSize;
        //从y轴开始顺时针
        float[] vertex = {0, height / 2, weight / 2, height, weight, height / 2, weight / 2, 0};

        return null;
    }
}
