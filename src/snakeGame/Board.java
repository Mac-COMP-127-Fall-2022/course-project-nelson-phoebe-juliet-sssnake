package snakeGame;

import edu.macalester.graphics.*;

public class Board {
    //the snake game
    private CanvasWindow canvas;
    private static final int CANVAS_WIDTH = 600, CANVAS_HEIGHT = 600;
    public Board(){
        canvas = new CanvasWindow("Snake Game", CANVAS_WIDTH, CANVAS_HEIGHT);

    }
    public double getCanvasWidth(){
        return CANVAS_WIDTH;
    }
    public double getCanvasHeight(){
        return CANVAS_HEIGHT;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.playSnake();
    }

    public void playSnake() {
        FoodManager foodManager = new FoodManager(canvas);
        foodManager.makeFood();
    }
}
