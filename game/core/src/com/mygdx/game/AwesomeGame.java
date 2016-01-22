package com.mygdx.game;

import com.badlogic.gdx.Game;

public class AwesomeGame extends Game {

	@Override
	public void create() {
		setScreen(new ScreenPlay());
	}

}
