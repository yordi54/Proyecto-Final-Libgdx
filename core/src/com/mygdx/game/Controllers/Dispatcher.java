package com.mygdx.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.GameMain;
import com.mygdx.game.Models.BulletEnemy;
import com.mygdx.game.Models.Enemy;
import com.mygdx.game.Screens.GameScreen;

import java.util.Iterator;

public class Dispatcher extends Thread{
    private GameScreen gameScreen;

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    @Override
    public void run() {

        synchronized (this){

            while (true) {
                try {
                    for (int i = 1; i < gameScreen.getStage().getActors().size; i++) {
                        if (gameScreen.getStage().isPared(i)) {
                            gameScreen.getStage().getActors().get(i).remove();

                        } else {
                            if(!gameScreen.getStage().colisionEnemies()) {
                                gameScreen.getStage().getActors().get(i).act(Gdx.graphics.getDeltaTime());
                            }
                        }
                    }
                    sleep(10);
                }catch (InterruptedException e){
                    System.out.println(e);
                }

            }
        }


    }

}
