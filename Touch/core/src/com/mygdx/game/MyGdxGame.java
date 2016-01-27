package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MyGdxGame extends ApplicationAdapter {
	OrthographicCamera camera;
	SpriteBatch batch;
	Sprite sprite;

	private float xPosition = 400;
	private float yPosition = 0; // y position to middle

	@Override
	public void create () {
		camera = new OrthographicCamera(800,480);
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		sprite = new Sprite( new Texture("astronaut.png"));
		sprite.setPosition(xPosition, yPosition);

	}
	@Override
	public void dispose(){

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		sprite.draw(batch);
		batch.end();

		// checking if user touch the screen and set position
		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			xPosition = touchPos.x - 64 / 2;
		}
		sprite.setPosition(xPosition, yPosition);
	}
}