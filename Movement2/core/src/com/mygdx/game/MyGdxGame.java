package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	OrthographicCamera camera;
	SpriteBatch batch;
	Sprite sprite;

	private float xPosition = 400;
	private float yPosition = 480;

	@Override
	public void create () {
		camera = new OrthographicCamera(800,480);
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		sprite = new Sprite( new Texture("comet.png"));
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

 		yPosition = yPosition - (200 * (Gdx.graphics.getDeltaTime()));
 		if (yPosition < -174 ) yPosition = 480;
 		sprite.setPosition(xPosition, yPosition);
	}
}
