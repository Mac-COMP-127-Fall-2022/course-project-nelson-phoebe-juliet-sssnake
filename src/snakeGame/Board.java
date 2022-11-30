package snakeGame;

import edu.macalester.graphics.*;

import java.util.ArrayList;



public class Board {
    //the snake game
    private CanvasWindow canvas;
    private static final int CANVAS_WIDTH = 610, CANVAS_HEIGHT = 610, border = 5;
    private boolean running = true;
    private GraphicsText win = new GraphicsText("win!");
    
    

    private ArrayList<Point> gridPointList;

    public Board(){
        canvas = new CanvasWindow("Snake Game", CANVAS_WIDTH, CANVAS_HEIGHT);
        gridPointList = new ArrayList<Point>();

    }
    public double getCanvasWidth(){
        return CANVAS_WIDTH;
    }
    public double getCanvasHeight(){
        return CANVAS_HEIGHT;
    }
    public double getBorder(){
        return border;
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
    private void win(){
        running = false;
        canvas.removeAll();
        win.setCenter(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
        canvas.add(win);
    }
    

    public static void main(String[] args) {
        Board board = new Board();
        board.playSnake();
    }



    public void playSnake() {

        

        gridPointList = getGridPointList();
        // showGridPoints();
        FoodManager foodManager = new FoodManager(canvas, gridPointList);
        foodManager.makeFood();

        SnakeManager snakeManager = new SnakeManager(gridPointList, canvas,border);
        snakeManager.startSnake();

        canvas.onKeyDown(event -> {
            snakeManager.changeDirection(event.getKey());
        });

        canvas.draw();
        canvas.pause(3000);


        canvas.animate(() -> {
            if(running){
                canvas.pause(200);

                
                snakeManager.moveSnake();

                String collisionTest = snakeManager.checkCollision(foodManager);

                if(collisionTest != "no"){

                    if (collisionTest == "food"){
                        foodManager.resetFood(snakeManager.getSnake(),snakeManager.getSnakeHead());
                        snakeManager.snakeGrow(foodManager);
                    }

                    if (collisionTest == "snake"||collisionTest == "border"){
                        snakeManager.stop();
                    }
                };
                if(snakeManager.getScore()>=300){
                    win();
                }
            }
        });
    }
}
