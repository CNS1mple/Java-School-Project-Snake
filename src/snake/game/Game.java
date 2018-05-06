package snake.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import snake.controller.Controller;
import snake.entities.Food;
import snake.entities.Ground;
import snake.entities.Snake;
import snake.util.Global;
import snake.view.GamePanel;


public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();
		Controller controller = new Controller(
				snake, food, ground, gamePanel);
		
		javax.swing.JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.setSize(Global.WIDTH * Global.CELL_SIZE,
				Global.HEIGHT * Global.CELL_SIZE);
		frame.setSize(Global.WIDTH * Global.CELL_SIZE + 10,
				Global.HEIGHT * Global.CELL_SIZE+ 35);
		frame.add(gamePanel, BorderLayout.CENTER);
		
		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);
		
		frame.addKeyListener(controller);
		
		frame.setVisible(true);
		controller.newGame();
	}

}
