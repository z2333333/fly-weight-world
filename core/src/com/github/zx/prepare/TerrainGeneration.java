package com.github.zx.prepare;

import com.github.zx.utils.WorldConstant;

import java.util.*;

/**
 * @Author: zx
 * @Date: 2019/8/12 15:27
 */
public class TerrainGeneration {

    public static float[] generateIrregularSurface(int weight, int height, int centerX, int centerY) {
        List<Float> result = new ArrayList();
        int mapSideLength = WorldConstant.basicUnitOfSize * WorldConstant.mapSize;
        //最小步进距离为0.5*basicUnitOfSize
        float minStepDistance = 0.5f * WorldConstant.basicUnitOfSize;
        int maxStepDistanceMultiple = 6;
        //从y轴开始顺时针
        float[] vertex = {centerX-weight*0.5f, centerY, centerX, centerY+height*0.5f, centerX+weight*0.5f, centerY, centerX, centerY-height*0.5f};

        Random random = new Random();
        int minMoveTimeX = (int) Math.ceil(weight/2/(minStepDistance*maxStepDistanceMultiple));
        int maxMoveTimeX = minMoveTimeX*6;
        if (random.nextBoolean()) {
            result.add(vertex[0]);
            result.add(vertex[1]);
            result.add(vertex[0]);
            result.add(vertex[1]+height*0.5f);
            result.add(vertex[2]);
            result.add(vertex[3]);
        }else {
            //分别进行x和y轴移动
            //x轴移动时y不变
            //决定向上还是向右
            if (random.nextBoolean()) {
                //向上
                //移动距离
                float StepDistance = random.nextInt(maxStepDistanceMultiple + 1) * minStepDistance;
                result.add(vertex[0]);
                result.add(vertex[0]);
            }
            //移动方向
        }
        return null;
    }

    public static Queue<Direction> forwardDirection(int capacity){
        Queue<Direction> queue = new LinkedList<Direction>();
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            Direction direction = Direction.getCode(random.nextInt(4));
            queue.offer(direction);
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Direction> queue = forwardDirection(6);
        for (Direction direction:queue) {
            System.out.println(direction);
        }
    }

    public enum Direction{
        UPON(0),
        DOWN(1),
        LEFT(2),
        RIGHT(3);
        private int code;
        Direction(int code){
            this.code=code;
        }
        public static Direction getCode(int code){
            for (Direction direction : values()) {
                if (direction.code == code) {
                    return direction;
                }
            }
            return Direction.UPON;
        }
    }
}
