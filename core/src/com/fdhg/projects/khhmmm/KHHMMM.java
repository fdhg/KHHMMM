package com.fdhg.projects.khhmmm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fdhg.projects.khhmmm.states.GSM;
import com.fdhg.projects.khhmmm.states.PlayState;

public class KHHMMM extends ApplicationAdapter {

	public static final String TITLE = "KHHMMM";
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	private SpriteBatch sb;
	private GSM gsm;
	
	@Override
	public void create () {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);

		sb = new SpriteBatch();
		gsm = new GSM();
		gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);
	}
}





















