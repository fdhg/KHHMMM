package com.fdhg.projects.khhmmm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class KHHMMM extends ApplicationAdapter {
	
	@Override
	public void create () {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}