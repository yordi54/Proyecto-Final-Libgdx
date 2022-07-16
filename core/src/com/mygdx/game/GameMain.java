package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.GameScreen;

public class GameMain extends Game {
    private SpriteBatch batch;
    private int size;
    private int height;
    private int width;
    private GameScreen gameScreen;
    @Override
    public void create() {
        batch =  new SpriteBatch();
        size = 32;
        width = 1095;
        height = 950;
        gameScreen =  new GameScreen(this,25,20,34);
        setScreen(gameScreen);
    }
    public SpriteBatch getBatch(){
        return batch;
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }
}
