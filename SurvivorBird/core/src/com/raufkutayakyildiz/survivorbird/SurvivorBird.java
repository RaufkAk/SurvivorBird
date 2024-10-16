package com.raufkutayakyildiz.survivorbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class SurvivorBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture bird;
	float birdX = 0;
	float birdY = 0;
	int gameState = 0;
	float acceleration = 0;
	float gravity = 0.1f;
	float enemyAcceleration=2;
	int score = 0;
	int scoredEnemy = 0;
	BitmapFont font;
	BitmapFont font2;
	Texture bee1;
	Texture bee2;
	Texture bee3;
	Random random;
	Circle birdCircle;
	Circle [] enemyCircles;
	Circle [] enemyCircles2;
	Circle [] enemyCircles3;

	//ShapeRenderer shapeRenderer;

	int numberOfEnenmies = 4;
	float [] enemyX = new float[numberOfEnenmies];
	float [] enemyofSet = new float[numberOfEnenmies];
	float [] enemyofSet2= new float[numberOfEnenmies];
	float [] enemyofSet3 = new float[numberOfEnenmies];
	float distance = 0;






	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.png");

		bird = new Texture("bird.png");

		bee1 = new Texture("bee.png");
		bee2 = new Texture("bee.png");
		bee3 = new Texture("bee.png");

		distance=Gdx.graphics.getWidth()/2;
		random = new Random();



		birdX=Gdx.graphics.getWidth()/2-bird.getHeight();
		birdY=Gdx.graphics.getHeight()/3;
		//shapeRenderer = new ShapeRenderer();
		font= new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(4);

		font2 = new BitmapFont();
		font2.setColor(Color.WHITE);
		font2.getData().setScale(6);

		birdCircle = new Circle();
		enemyCircles = new Circle[numberOfEnenmies];
		enemyCircles2 = new Circle[numberOfEnenmies];
		enemyCircles3 = new Circle[numberOfEnenmies];

		for(int i = 0; i<numberOfEnenmies;i++){
			enemyX[i]=Gdx.graphics.getWidth() - bee1.getWidth() / 2 + i * distance;

			enemyofSet[i] = (random.nextFloat()-0.5f)*(Gdx.graphics.getWidth()-200);
			enemyofSet2[i] = (random.nextFloat()-0.5f)*(Gdx.graphics.getWidth()-200);
			enemyofSet3[i] = (random.nextFloat()-0.5f)*(Gdx.graphics.getWidth()-200);

			enemyCircles[i] = new Circle();
			enemyCircles2[i] = new Circle();
			enemyCircles3[i] = new Circle();



		}


	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		if(gameState==1){


			if(enemyX[scoredEnemy]<birdX){
				score++;
				if(scoredEnemy<numberOfEnenmies-1){
					scoredEnemy++;
				}else{
					scoredEnemy=0;
				}
			}





			if(Gdx.input.justTouched()){
				acceleration=-7;
			}


			for (int i = 0; i<numberOfEnenmies;i++){
              if(enemyX[i]<-bee1.getWidth()){
				  enemyX[i] = enemyX[i] + numberOfEnenmies*distance;
				  enemyofSet[i] = (random.nextFloat()-0.5f)*(Gdx.graphics.getWidth()-200);
				  enemyofSet2[i] = (random.nextFloat()-0.5f)*(Gdx.graphics.getWidth()-200);
				  enemyofSet3[i] = (random.nextFloat()-0.5f)*(Gdx.graphics.getWidth()-200);

			  }else {
				  enemyX[i]=enemyX[i]-enemyAcceleration;
			  }
			    batch.draw(bee1,enemyX[i],Gdx.graphics.getHeight()/2+enemyofSet[i],Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()/10);
				batch.draw(bee2,enemyX[i],Gdx.graphics.getHeight()/2+enemyofSet2[i],Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()/10);
				batch.draw(bee3,enemyX[i],Gdx.graphics.getHeight()/2+enemyofSet3[i],Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()/10);
				enemyCircles[i] =new Circle(enemyX[i]+Gdx.graphics.getWidth()/30,Gdx.graphics.getHeight()/2+enemyofSet[i]+Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth()/30);
				enemyCircles2[i] =new Circle(enemyX[i]+Gdx.graphics.getWidth()/30,Gdx.graphics.getHeight()/2+enemyofSet2[i]+Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth()/30);
				enemyCircles3[i] =new Circle(enemyX[i]+Gdx.graphics.getWidth()/30,Gdx.graphics.getHeight()/2+enemyofSet3[i]+Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth()/30);




			}

			if(birdY > 0){
				acceleration=acceleration+gravity ;
				birdY=birdY-acceleration;
			}else {
				gameState=2;
			}

		}else if(gameState==0) {
			if(Gdx.input.justTouched()){
				gameState = 1;
			}

		}else if (gameState ==2){

			font2.draw(batch,"Game Over! Tap To Play Again!",150,Gdx.graphics.getHeight()/2);



			if(Gdx.input.justTouched()){
				gameState = 1;
				birdY=Gdx.graphics.getHeight()/3;
				for(int i = 0; i<numberOfEnenmies;i++){
					enemyX[i]=Gdx.graphics.getWidth() - bee1.getWidth() / 2 + i * distance;

					enemyofSet[i] = (random.nextFloat()-0.5f)*(Gdx.graphics.getWidth()-200);
					enemyofSet2[i] = (random.nextFloat()-0.5f)*(Gdx.graphics.getWidth()-200);
					enemyofSet3[i] = (random.nextFloat()-0.5f)*(Gdx.graphics.getWidth()-200);

					enemyCircles[i] = new Circle();
					enemyCircles2[i] = new Circle();
					enemyCircles3[i] = new Circle();



				}

				acceleration = 0;
				score=0;
				scoredEnemy=0;

			}
		}

		batch.draw(bird,birdX,birdY,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()/10);
		font.draw(batch,String.valueOf(score),100,200);
		batch.end();

		birdCircle.set(birdX+Gdx.graphics.getWidth()/30,birdY+Gdx.graphics.getWidth()/20-25,Gdx.graphics.getWidth() / 30);
		//shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		//shapeRenderer.setColor(Color.BLACK);
		//shapeRenderer.circle(birdCircle.x,birdCircle.y,birdCircle.radius);


		for(int i =0 ; i <numberOfEnenmies;i++){
			//shapeRenderer.circle(enemyX[i]+Gdx.graphics.getWidth()/30,Gdx.graphics.getHeight()/2+enemyofSet[i]+Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth()/30);
			//shapeRenderer.circle(enemyX[i]+Gdx.graphics.getWidth()/30,Gdx.graphics.getHeight()/2+enemyofSet2[i]+Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth()/30);
			//shapeRenderer.circle(enemyX[i]+Gdx.graphics.getWidth()/30,Gdx.graphics.getHeight()/2+enemyofSet3[i]+Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth()/30);

			if (Intersector.overlaps(birdCircle,enemyCircles[i]) || Intersector.overlaps(birdCircle,enemyCircles2[i]) || Intersector.overlaps(birdCircle,enemyCircles3[i])){
				gameState=2;
			}



		}
		//shapeRenderer.end();

	}
	
	@Override
	public void dispose () {
		
	}
}
