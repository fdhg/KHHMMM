package com.fdhg.projects.khhmmm.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;

// handles all resources
public class Content {

    private HashMap<String, TextureAtlas> atlases;

    public Content() {
        atlases = new HashMap<>();
    }

    public void loadAtlas(String path, String key) {
        atlases.put(key, new TextureAtlas(Gdx.files.internal(path)));
    }

    public TextureAtlas getAtlas(String key) {
        return atlases.get(key);
    }
}