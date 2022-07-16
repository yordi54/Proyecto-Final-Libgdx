package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Controllers.Dispatcher;
import com.mygdx.game.Controllers.InputController;
import com.mygdx.game.Controllers.Planner;
import com.mygdx.game.GameMain;
import com.mygdx.game.Models.Scene;

import java.util.Iterator;


public class GameScreen extends BaseScreen{
    private final int width;
    private final int height;
    private final int size;



    private final SpriteBatch batch;
    private  final Texture img;
    private Scene stage;
    private final InputController inputController;
    private final Dispatcher dispatcher;
    private final Planner planner;

    public GameScreen(GameMain game, int width, int height, int size) {
        super(game);
        inputController = new InputController();
        Gdx.input.setInputProcessor(inputController);
        dispatcher = new Dispatcher();
        this.width = width;
        this.height = height;
        this.size = size;
        this.batch = game.getBatch();
        img = new Texture(Gdx.files.internal("BG.png"));
        stage = new Scene();

        planner = new Planner();
        planner.setGameScreen(this);

        inputController.setGame(this);
        dispatcher.setGameScreen(this);
        planner.start();
        dispatcher.start();
        planner.setInitial(true);
        Gdx.graphics.setWindowedMode(size*width, size*height);

    }
    public Scene getStage() {
        return stage;
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 1, 1);

        batch.begin();
        //stage.getHelicopter().draw(batch,1);
        batch.draw(img,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.end();

        stage.draw();
    }



    @Override
    public void dispose() {
        batch.dispose();
    }
}
