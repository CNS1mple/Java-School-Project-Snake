package cn.itcast.snake.entities;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import cn.itcast.snake.util.Global;

public class Ground extends Point{
	
	private int[][] rocks = new int[Global.WIDTH][Global.HEIGHT];
	
	public Ground(){
		for(int x = 0; x < Global.WIDTH; x++){
			rocks[x][0] = 1;
			rocks[x][Global.HEIGHT - 1] = 1;
		}	
	}
	public void newGround(Point p){
		rocks[p.x][p.y] = 1;
	}
	
	public boolean isSnakeEatRock(Snake snake){
		for(int x = 0; x < Global.WIDTH; x++){
			for(int y = 0; y < Global.HEIGHT; y++){
				if(rocks[x][y] == 1 &&
						(x == snake.getHead().x && y == snake.getHead().y) ){
					return true;
				}
			}
		}
		return false;
	}
	public Point getPoint(){
		Random random = new Random();
		int x = 0, y = 0;
		do{
		x = random.nextInt(Global.WIDTH);
		y = random.nextInt(Global.HEIGHT);
		}while(rocks[x][y] == 1);
		return new Point(x, y);
	}
	public void drawMe(Graphics g){
		
		System.out.println("Ground's drawMe");
		
		g.setColor(Global.ROCK_COLOR);
		for(int x = 0; x < Global.WIDTH; x++){
			for(int y = 0; y < Global.HEIGHT; y++){
				if(rocks[x][y] == 1){
					g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
							Global.CELL_SIZE, Global.CELL_SIZE, true);	
				}
			}
		}
	}
}