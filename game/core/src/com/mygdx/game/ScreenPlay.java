package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Jack on 1/23/2016.
 */

public class ScreenPlay extends ScreenAdapter {
    // Declare shapeRenderer
    private ShapeRenderer shapeRenderer;

    @Override
    public void show() {
        // Initialize shapeRenderer
        shapeRenderer = new ShapeRenderer();

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(100, 100, 400, 400);
        shapeRenderer.end();
    }
}
