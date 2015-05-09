package com.fdhg.projects.khhmmm.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fdhg.projects.khhmmm.KHHMMM;

public class Tile extends Box {

    private TextureRegion light;
    private TextureRegion dark;

    private boolean selected;

    private float totalWidth;
    private float totalHeight;
    private float timer;
    private float maxTime = 0.5f;

    public Tile(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = 0;
        this.height = 0;
        totalWidth = width - 8;
        totalHeight = height - 8;


        light = KHHMMM.res.getAtlas("packSheet").findRegion("light");
        dark = KHHMMM.res.getAtlas("packSheet").findRegion("dark");
    }

    public void setSelected(boolean b) {
        selected = b;
    }

    public void setTimer(float t) {
        timer = t;
    }

    public void update(float dt) {

        // tiles pop into view
        if (width < totalHeight && height < totalHeight) {
            timer += dt;
            width = (timer / maxTime) * totalWidth;
            height = (timer / maxTime) * totalHeight;

            if (width < 0) width = 0;
            if (height < 0) height = 0;
            if (width > totalWidth) width = totalWidth;
            if (height > totalHeight) height = totalHeight;
        }
    }
    public void render(SpriteBatch sb) {
        if (selected)
            sb.draw(light, x - width / 2, y - height / 2, width, height);
        else
            sb.draw(dark, x - width / 2, y - height / 2, width, height);
    }
}















