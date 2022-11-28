package snakeGame;

import java.util.ArrayList;

import edu.macalester.graphics.*;

public class SnakeManager {
    private ArrayList<SnakePiece> snake = new ArrayList<>();
    private double snakeLength;
    private ArrayList<Point> gridPointList;
    private double headX, headY;
    private CanvasWindow canvas;
    private SnakeHead snakeHead;

    private boolean up, down, left, right;

    public SnakeManager(ArrayList<Point> gridPointList, CanvasWindow canvas){

        up = true;
        right = false;
        down = false;
        left = false;

        this.gridPointList = gridPointList;
       
        snakeHead = new SnakeHead(gridPointList.get(50).getX(), gridPointList.get(50).getY() );

        headX = snakeHead.getTopLX();
        headY = snakeHead.getTopLY();

        this.canvas = canvas;

        // snakeLength=5;
        // for(int l=1; l<snakeLength; l++){
        //     snake.add(new SnakePiece(l, l));
        // }
    }
    public void startSnake(){
        canvas.add(snakeHead.getShape());

    }

    public void moveSnake() {
        if(up){
            snakeHead.setPosition(headX, headY+snakeHead.getBlockSize());
            System.out.println("XXXX");
        }

        if(down){
            snakeHead.setPosition(headX, headY-snakeHead.getBlockSize());
        }

        if(left){
            snakeHead.setPosition(headX-snakeHead.getBlockSize(), headY);
        }

        if(right){
            snakeHead.setPosition(headX+snakeHead.getBlockSize(), headY);
        }

        headX = snakeHead.getTopLX();
        headY = snakeHead.getTopLY();
    }

}
