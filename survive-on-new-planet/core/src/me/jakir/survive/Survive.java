package me.jakir.survive;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;



public class Survive extends ApplicationAdapter {
	SpriteBatch batch;
	Texture astronautImage, bg, cometImage;
	private Sound deadSound;
	private Music bgAudio;
	private OrthographicCamera camera;
	private Rectangle astronaut;
	private Array<Rectangle> comets;
	private long lastCometTime;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		// loading images
		cometImage = new Texture(Gdx.files.internal("comet.png"));
		astronautImage = new Texture(Gdx.files.internal("astronaut.png"));
		bg = new Texture(Gdx.files.internal("bg.jpg"));

		// loading Sounds
		deadSound = Gdx.audio.newSound(Gdx.files.internal("dead.wav"));
		bgAudio = Gdx.audio.newMusic(Gdx.files.internal("bgAudio.mp3"));

		// start playing background music

		bgAudio.setLooping(true);
		bgAudio.play();

		// creating the camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,480);

		batch = new SpriteBatch();

		// creating the astronaut

		astronaut = new Rectangle();
		astronaut.x = 800/2 - 128;
		astronaut.y = 0;
		astronaut.width = 128;
		astronaut.height = 128;

		// create the random comet arry

		comets = new Array<Rectangle>();
		randomComet();


	}

	private void randomComet() {

		Rectangle comet = new Rectangle();
		comet.x = MathUtils.random(0, 800 - 62);
		comet.y = 480;

		comet.width = 62;
		comet.height = 174;
		comets.add(comet);
		lastCometTime = TimeUtils.nanoTime();


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



		camera.update();
		batch.setProjectionMatrix(camera.combined);




		batch.begin();
		batch.draw(bg, 0, 0, 800, 480);

		batch.draw(astronautImage, astronaut.x, astronaut.y);

		for(Rectangle comet: comets){
			batch.draw(cometImage,comet.x,comet.y);
		}
		batch.end();

		if(Gdx.input.isTouched()){
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(),Gdx.input.getY(),0);
			camera.unproject(touchPos);
			astronaut.x = touchPos.x - 128/2;

		}

		if(TimeUtils.nanoTime() - lastCometTime > 1000000000) randomComet();


		Iterator<Rectangle> iter = comets.iterator();
		while (iter.hasNext()){
			Rectangle comet = iter.next();
			comet.y -= 200 * Gdx.graphics.getDeltaTime();
			if(comet.y + 174 < 0) iter.remove();
			if(comet.overlaps(astronaut)){
				deadSound.play();
				iter.remove();
			}
		}


	}
}
