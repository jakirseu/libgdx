package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Movement extends ApplicationAdapter {

	OrthographicCamera camera;
	SpriteBatch batch;
	Sprite sprite;

	private float xPosition = 0;
	private float yPosition = 240; // y position to middle
	
	@Override
	public void create () {
		camera = new OrthographicCamera(800,480);
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		sprite = new Sprite( new Texture("bullet.png"));
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

		xPosition = xPosition + (200 * (Gdx.graphics.getDeltaTime()));
		if (xPosition > 800) xPosition=0;
		sprite.setPosition(xPosition,yPosition);
	}
}
