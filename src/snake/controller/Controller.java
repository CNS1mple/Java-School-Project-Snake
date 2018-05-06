package snake.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import snake.entities.Food;
import snake.entities.Ground;
import snake.entities.Snake;
import snake.listener.SnakeListener;
import snake.view.GamePanel;


public class Controller extends KeyAdapter implements SnakeListener{

	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;
	
	
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			snake.changeDirection(Snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(Snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(Snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(Snake.RIGHT);
			break;
			
		}
	}
	
	@Override
	public void snakeMoved(Snake snake) {
		
		if(snake.isEatBody()){
			snake.die();
		}
		if(ground.isSnakeEatRock(snake)){
			snake.die();
		}
		if(food.isSnakeEatFood(snake)){
			snake.eatFood();
			ground.newGround(ground.getPoint());
			food.newFood(ground.getPoint());
		}
		gamePanel.display(snake, food, ground);
	}
	
	public void newGame(){
		snake.start();
		food.newFood(ground.getPoint());
	}
}
