package com.github.zx.utils;

/**
 * @Author: zx
 * @Date: 2019/8/13 14:02
 */
public class WorldConstant {

    /**
     * 世界基本尺寸单位,按设计逻辑一个单位为1米
     * 1个单位大小显示为64像素
     */
    public final static int basicUnitOfSize = 32;

    /**
     * 地图相对于单位长度倍数
     * 256表示地图为边长=256*64个像素的正方形
     */
    public static int mapSize = 256;
}
