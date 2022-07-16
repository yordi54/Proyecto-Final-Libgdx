package com.mygdx.game.Controllers;

import static java.lang.Character.toUpperCase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.game.GameMain;
import com.mygdx.game.Screens.GameScreen;

public class InputController extends InputAdapter {

private GameScreen game;

    public void setGame(GameScreen game) {
        this.game = game;
    }

    @Override
    public boolean keyTyped(char character) {

        switch (toUpperCase(character)){
            case 'A':
                System.out.println("Presionaste la tecla A");
                game.getStage().getHelicopter().setDirection(toUpperCase(character));
                game.getStage().getHelicopter().act(Gdx.graphics.getDeltaTime());

                break;
            case 'D':
                System.out.println("Presionaste la tecla D");
                game.getStage().getHelicopter().setDirection(toUpperCase(character));
                game.getStage().getHelicopter().act(Gdx.graphics.getDeltaTime());
                break;
            case 'P':
                System.out.println("PResionaste las balas");
                game.getStage().loadBullet();

                break;

            default:
                System.out.println("Unexpected value: " + character);
        }
        
        return true;
    }
}
