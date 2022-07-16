package com.mygdx.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Models.Enemy;
import com.mygdx.game.Screens.GameScreen;

import java.util.Random;

public class Planner extends Thread{
    private GameScreen gameScreen;
    private float timer;
    private boolean initial;


    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.initial = false;

    }

    @Override
    public void run() {
        synchronized (this){
                while(true){
                    try {
                        this.gameScreen.getStage().loadEnemy();

                        sleep(3000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }

        }
    }
}
