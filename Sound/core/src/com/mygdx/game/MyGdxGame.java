package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Music audioBG, touch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

        // Load Sound
		audioBG = Gdx.audio.newMusic(Gdx.files.internal("gameBG.mp3"));
		touch = Gdx.audio.newMusic(Gdx.files.internal("touch.mp3"));

		// start the playback of the background music immediately
		audioBG.setLooping(true);
        // Play
		audioBG.play();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

        if(Gdx.input.isTouched()) {
			touch.play();

        }
	}
}
