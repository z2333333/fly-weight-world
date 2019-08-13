package com.github.zx.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.github.zx.utils.WorldConstant;

/**
 * @Author: zx
 * @Date: 2019/8/6 11:41
 */
public class CameraManager {

    private OrthographicCamera camera;
    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private float worldSize = WorldConstant.basicUnitOfSize*WorldConstant.mapSize;

    public CameraManager(){
        //camera =new OrthographicCamera(w*0.3f, w*0.3f*(h/w));
        camera =new OrthographicCamera(w, h);
        //camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.position.set(worldSize / 2f, worldSize / 2f, 0);
        camera.update();
    }

    public Camera getCamera(){
        return camera;
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            camera.zoom += 0.02;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            camera.zoom -= 0.02;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.translate(-30, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.translate(30, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.translate(0, -30, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.translate(0, 30, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.rotate(-0.5f, 0, 0, 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            camera.rotate(0.5f, 0, 0, 1);
        }

        //camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, w/camera.viewportWidth);

        float effectiveViewportWidth = camera.viewportWidth * camera.zoom;
        float effectiveViewportHeight = camera.viewportHeight * camera.zoom;

        //camera.position.x = MathUtils.clamp(camera.position.x, effectiveViewportWidth / 2f, w - effectiveViewportWidth / 2f);
        //camera.position.y = MathUtils.clamp(camera.position.y, effectiveViewportHeight / 2f, h - effectiveViewportHeight / 2f);
        //xy应该保持缩放比,如果显示不下移动
        //camera.position.x = worldSize/2f;
        //camera.position.y = worldSize/2f;
    }
}
