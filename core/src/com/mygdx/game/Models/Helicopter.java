package com.mygdx.game.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

public class Helicopter extends Actor {
    private char direction;




    public void setDirection(char direction) {
        this.direction = direction;
    }

    private Texture image;
    private Animation<TextureRegion> animation;
    private TextureRegion[] sprite_images;
    private TextureRegion frame_actual;
    private float time;

    public Helicopter(){
        direction = 'N';
        image = new Texture(Gdx.files.internal("helicopter.png"));
        TextureRegion[][] tmp = TextureRegion.split(image, image.getWidth()/8, image.getHeight());
        sprite_images =  new TextureRegion[8];
        for (int i = 0; i < 8 ; i++){
            sprite_images[i] = tmp[0][i];
        }
        animation = new Animation<TextureRegion>(1f/20f, sprite_images);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        time+= Gdx.graphics.getDeltaTime();
        frame_actual = animation.getKeyFrame(time, true);
        batch.draw(frame_actual, getX(),getY());
    }
    public void dispose(){
        image.dispose();

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(direction != 'N') {
            switch (direction) {
                case 'A':
                    this.setPosition(this.getX(), this.getY() + 200 * delta);
                    break;
                case 'D':
                    this.setPosition(this.getX(), this.getY() - 200 * delta);
                    break;


                default:
                    System.out.print("No hay tecla");
            }
            this.setDirection('N');
        }
    }
}
