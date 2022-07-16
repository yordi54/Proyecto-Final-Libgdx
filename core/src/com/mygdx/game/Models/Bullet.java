package com.mygdx.game.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bullet extends Actor {
    private final Texture image_bullet;
    public  Bullet(){
        this.image_bullet = new Texture(Gdx.files.internal("fire_ball_1.png"));

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(image_bullet,getX(),getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.setPosition(getX()+100f*delta,getY());
    }
}
