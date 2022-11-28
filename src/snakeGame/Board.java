package snakeGame;

import edu.macalester.graphics.*;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.text.AttributeSet.ColorAttribute;


public class Board {
    //the snake game
    private CanvasWindow canvas;
    private static final int CANVAS_WIDTH = 610, CANVAS_HEIGHT = 610, border = 5;
    

    private ArrayList<Point> gridPointList;

    public Board(){
        canvas = new CanvasWindow("Snake Game", CANVAS_WIDTH, CANVAS_HEIGHT);
        gridPointList = new ArrayList();

    }
    public double getCanvasWidth(){
        return CANVAS_WIDTH;
    }
    public double getCanvasHeight(){
        return CANVAS_HEIGHT;
    }

    private ArrayList<Point> getGridPointList() {
        for (int column = border; column < canvas.getWidth()-border; column+=((canvas.getWidth()-border*2)/20)) {
            for (int row = border; row < canvas.getWidth()-border; row+=((canvas.getHeight()-border*2)/20)) {
                gridPointList.add(new Point(column, row));
            }
        }
        // System.out.println(gridPointList);
        return gridPointList;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.playSnake();
    }

    // public void showGridPoints() {
        

    //     int i = 0;
    //     for (Point point : gridPointList) {
            
    //         Block rect = new Block(point.getX(), point.getY());

    //         if (i ==0 ){
    //             i =1;
    //             rect.setColor(Color.RED);
    //         }

    //         else if (i == 1) {
    //             i = 2;
    //             rect.setColor(Color.GREEN);
    //         }
    
    //         else {
    //             i = 0;
    //             rect.setColor(Color.BLUE);
    //         }

    //         // rect.setColor(new Color(60,100,i));
    //         canvas.add(rect.getShape());
    //     }
    // }



    public void playSnake() {

        boolean running = true;

        gridPointList = getGridPointList();
        // showGridPoints();
        FoodManager foodManager = new FoodManager(canvas, gridPointList);
        foodManager.makeFood();

        SnakeManager snakeManager = new SnakeManager(gridPointList, canvas);
        snakeManager.startSnake();
        
        while (running){
            snakeManager.moveSnake();
            canvas.pause(1000);
            canvas.draw();
        }

    }
}
