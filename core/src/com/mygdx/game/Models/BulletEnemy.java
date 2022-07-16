package com.mygdx.game.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BulletEnemy extends Actor {
    private final Texture imageBulletEnemy;
    public BulletEnemy() {
        imageBulletEnemy = new Texture(Gdx.files.internal("Bullet_Enemy.png"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(imageBulletEnemy,getX(),getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.setPosition(getX()-100f*delta,getY());
    }
}
