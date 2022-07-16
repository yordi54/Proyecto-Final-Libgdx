package com.mygdx.game.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

public class Enemy extends Actor {
    private Texture image;
    private float pos_final;
    private ArrayList<BulletEnemy> bulletEnemies;

    public ArrayList<BulletEnemy> getBulletEnemies() {
        return bulletEnemies;
    }

    public Enemy() {
        image = new Texture(Gdx.files.internal("image_enemy.png"));
        bulletEnemies = new ArrayList<>();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(image, getX(),getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.setPosition(getX()-100f*delta,getY());
        /*if(getX() < pos_final -50){
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.setPosition(getX(),getY());
            bulletEnemies.add(bulletEnemy);
        }*/




    }

    public void dispose(){
        image.dispose();
    }

}
