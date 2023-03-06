package com.michalkosalka;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class ZFAppWithAndroid extends Game {



	@Override
	public void create() {
		this.setScreen(new WelcomeScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
	}
}