package com.github.zx.object.build;

/**
 * @Author: zx
 * @Date: 2019/8/20 15:46
 */
public enum  ConnectorEnum {
    /** 描述连接件的形状
     *  直角,T型,十字:方位词以九点钟为始顺时针
     *  延长件:EX+开口
     *  单独块:block
     * */
    LEFT_DOWN,LEFT_UP_DOWN,LEFT_RIGHT_DOWN,LEFT_UP_RIGHT_DOWN,EX_LEFT,LEFT_UP,EX_LEFT_RIGHT,
    LEFT_UP_RIGHT,EX_DOWN,EX_UP_DOWN,DOWN_RIGHT,UP_RIGHT_DOWN,BLOCK,EX_UP,
    EX_RIGHT,UP_RIGHT
}
