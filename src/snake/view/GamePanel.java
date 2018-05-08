package snake.view;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import snake.entities.Food;
import snake.entities.Ground;
import snake.entities.Snake;
import snake.util.Global;


public class GamePanel extends JPanel{
	
	private Snake snake;
	private Food food;
	private Ground ground;
	public void display(Snake snake, Food food, Ground ground){
		System.out.println("GamePanel's display");
		this.snake = snake;
		this .food = food;
		this.ground = ground;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//÷ÿ–¬œ‘ æ
		g.setColor(Global.GAME_PANEL_COLOR);
		g.fillRect(0, 0, Global.WIDTH * Global.CELL_SIZE,
				Global.HEIGHT * Global.CELL_SIZE + 50);
		
		if(ground != null && snake != null && food != null){
			this.ground.drawMe(g);
			this.snake.drawMe(g);
			this.food.drawMe(g);
		}
	}
}