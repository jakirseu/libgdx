package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Camera extends ApplicationAdapter {
	ShapeRenderer renderer;

	// Circle X Position, Y Position and Radius
	private static final  float X_POSITION = 200;
	private static final float Y_POSITION = 200;
	private static final float raious = 150;

	// Declare Camera

	OrthographicCamera camera;
	private Viewport viewport;

	@Override
	public void create () {
		renderer = new ShapeRenderer();
		// Initialize the camera
		camera = new OrthographicCamera();

		// set camera position
		camera.position.set(X_POSITION,Y_POSITION,0);

		// set viewport
		viewport = new FitViewport(800, 480, camera);
	}
	@Override
	public void resize(int width, int height) {

		viewport.update(width, height);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// update camera
		camera.update();
		// set Projection Matrix
		renderer.setProjectionMatrix(camera.combined);

		renderer.begin(ShapeRenderer.ShapeType.Filled);
		renderer.setColor(Color.WHITE);

		renderer.circle(X_POSITION,Y_POSITION, raious);

		renderer.end();
	}
}
