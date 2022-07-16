package com.mygdx.game.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Scene extends Stage {
    private Helicopter helicopter;
    private ArrayList<Enemy> enemies;
    private ArrayList<Bullet> bullets;
    private  ArrayList<BulletEnemy> bulletEnemies;
    private  int count=0;
    public Scene() {
        helicopter = new Helicopter();
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        bulletEnemies = new ArrayList<>();
        this.addActor(helicopter);
        for(int i = 0;i < 10; i++){
            Enemy enemy = new Enemy();

            Random random = new Random();

            int value = random.nextInt(100 + 0) + 0;
            enemy.setPosition(Gdx.graphics.getWidth(),0.1f * this.getHeight() +
                    0.8f * this.getHeight() * (float) Math.random());
            enemy.setName("Enemy");
            enemies.add(enemy);

        }

    }
    public void loadEnemy(){
        if(! (count >  enemies.size())) {
            Enemy enemy = enemies.get(count);
            this.addActor(enemy);
            count++;
        }else{
            count = 0;
        }

    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void loadBullet(){
        Bullet bullet = new Bullet();
        bullet.setPosition(helicopter.getX()+50,helicopter.getY());
        bullet.setName("Bullet");
        bullets.add(bullet);
        this.addActor(bullet);
    }

    public void loadBulletEnemy(){
        for (int i = 1; i< this.getActors().size;i++){
            if(this.getActors().get(i).getName().equals("Enemy")){
                Enemy enemy = (Enemy) getActors().get(i);
                if(enemy.getBulletEnemies().size()>0){
                    BulletEnemy bulletEnemy = enemy.getBulletEnemies().remove(0);
                    this.addActor(bulletEnemy);
                }
            }
        }
    }
    public boolean isPared(int i){
        if(this.getActors().get(i).getX() <0){
            return true;
        }
        return false;
    }
    public Helicopter getHelicopter(){
        return helicopter;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public boolean colisionEnemies(){
        for(int i = 1; i < this.getActors().size; i++){
            if(this.getActors().get(i).getName().equals("Enemy")){
                if(this.getActors().get(i).getX()<this.helicopter.getY()+40+50 &&
                        this.getActors().get(i).getY()+40>this.helicopter.getY()+50 &&
                this.helicopter.getX()+60 > this.getActors().get(i).getX() && this.helicopter.getY() > this.getActors().get(i).getY() ){
                    enemies.remove(this.getActors().get(i));
                    this.getActors().get(i).remove();
                    return true;


                }
            }
        }
        return false;
    }

    @Override
    public void dispose() {
        helicopter.dispose();
    }

    @Override
    public void draw() {
        super.draw();
    }
}
