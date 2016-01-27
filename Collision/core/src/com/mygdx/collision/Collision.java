package com.mygdx.collision;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Collision extends ApplicationAdapter {

	OrthographicCamera camera;
	SpriteBatch batch;
	Sprite spriteBullet;
	Sprite spriteRobber;

	private float bulletXposition = -400;
	private float robberXposition = 400;
	private float robberYpossition = -300;
	private static final float GRAVITY = -20.0f;

	@Override
	public void create () {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch = new SpriteBatch();

		spriteBullet = new Sprite( new Texture("bullet.png"));
		spriteBullet.setPosition(bulletXposition, 0);

		spriteRobber = new Sprite( new Texture("Robber.png"));
		spriteRobber.setPosition(robberXposition, robberYpossition);


	}
	@Override
	public void dispose(){

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		spriteBullet.draw(batch);
		spriteRobber.draw(batch);
		batch.end();

		boolean isBottm = spriteBullet.getBoundingRectangle().overlaps(Gdx.graphics.)

		robberYpossition+= (Gdx.graphics.getDeltaTime()) * GRAVITY;
		spriteRobber.setPosition(0, robberYpossition);
	}
}
