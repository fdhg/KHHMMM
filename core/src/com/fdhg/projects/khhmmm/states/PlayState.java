package com.fdhg.projects.khhmmm.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fdhg.projects.khhmmm.KHHMMM;
import com.fdhg.projects.khhmmm.ui.Tile;

public class PlayState extends State {

    private Tile[][] tiles;
    private int tileSize;
    private int boardHeight;
    private float boardOffset;

    public PlayState(GSM gsm) {
        super(gsm);

        tiles = new Tile[6][6];
        tileSize = KHHMMM.WIDTH / tiles[0].length;
        boardHeight = tileSize * tiles.length;
        boardOffset = (KHHMMM.HEIGHT - boardHeight) / 2;

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[0].length; col++) {
                tiles[row][col] = new Tile(
                        (col * tileSize) + (tileSize / 2),
                        (row * tileSize) + boardOffset + (tileSize / 2),
                        tileSize,
                        tileSize);

                // delay other tiles for dramatic entry
                tiles[row][col].setTimer((-(tiles.length - row) - col) * 0.05f);
            }
        }
    }

    @Override
    public void handleInput() {
        int MAX_FINGERS = 2;
        for (int i = 0; i < MAX_FINGERS; i++) {
            // i = current finger touching the device (1st or 2nd)
            if (Gdx.input.isTouched(i)) {
                mouse.x = Gdx.input.getX(i);
                mouse.y = Gdx.input.getY(i);
                cam.unproject(mouse);

                if (mouse.x >= 0 &&
                        mouse.x < KHHMMM.WIDTH &&
                        mouse.y > boardOffset &&
                        mouse.y < boardOffset + boardHeight) {
                    int row = (int) ((mouse.y - boardOffset) / tileSize);
                    int col = (int) (mouse.x / tileSize);
                    tiles[row][col].setSelected(true);
                }
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
//        for (int row = 0; row < tiles.length; row++) {
        for (Tile[] tile : tiles) {
            for (int col = 0; col < tiles[0].length; col++) {
//                tiles[row][col].update(dt);
                tile[col].update(dt);
            }
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();

//        for (int row = 0; row < tiles.length; row++) {
        for (Tile[] tile : tiles) {
            for (int col = 0; col < tiles[0].length; col++) {
                tile[col].render(sb);
            }
        }

        sb.end();
    }
}























