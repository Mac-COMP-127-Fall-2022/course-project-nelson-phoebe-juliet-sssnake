package snakeGame;

import java.util.ArrayList;

import java.lang.String;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class SnakeManager {
    private ArrayList<SnakePiece> snake = new ArrayList<>();
    private double snakeLength;
    private ArrayList<Point> gridPointList;
    private double headX, headY;
    private CanvasWindow canvas;
    private SnakeHead snakeHead;
    
    private String direction;


    public SnakeManager(ArrayList<Point> gridPointList, CanvasWindow canvas){

        direction = "up";

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

    public String checkCollision(FoodManager foodManager){
        if(snakeHead.getTopLX() == foodManager.getFoodX() && snakeHead.getTopLY() == foodManager.getFoodY()) {
            return "food";
        }

        for (SnakePiece snakePiece : snake) {
            if(snakeHead.getShape().getElementAt(headX, headY) == snakePiece.getShape()) {
                return "snake";
            }
        }

        if (headX < 0 || headY > canvas.getHeight() || headX > canvas.getWidth() || headY < 0) {
            return "border";
        }

        else {
            return "no";
        }
    }

    public void changeDirection(Key key) {
        if( key == Key.LEFT_ARROW) {
            if(direction != "right") {
                direction = "left";
            }
        }

        if( key == Key.RIGHT_ARROW) {
            if(direction != "left") {
                direction = "right";
            }
        }

        if( key == Key.DOWN_ARROW) {
            if(direction != "up") {
                direction = "down";
            }
        }
        if( key == Key.UP_ARROW) {
            if(direction != "down") {
                direction = "up";
            }
        }
    }

    public void moveSnake() {
        //for each snake piece set position to the previous one's
        for(int pieceNumber=0; pieceNumber<snake.size();pieceNumber++){
            if(pieceNumber==0){
                snake.get(pieceNumber).setPosition(headX, headY);
            }else{
                snake.get(pieceNumber).setPosition(snake.get(pieceNumber-1).getTopLX(), snake.get(pieceNumber-1).getTopLY());
            }
        }

        if(direction == "up"){
            headY -= snakeHead.getBlockSize();
        }

        if(direction == "down"){
            headY += snakeHead.getBlockSize();
        }

        if(direction == "left"){
            headX -= snakeHead.getBlockSize();
        }

        if(direction == "right"){
            headX += snakeHead.getBlockSize();
        }

        
        snakeHead.setPosition(headX, headY);
    }

    public double getSnakeHeadX() {
        return headX;
    }

    public double getSnakeHeadY() {
        return headY;
    }

    public void snakeGrow(FoodManager foodManager){
        SnakePiece snakeBody;
        if(snake.size()==0){
            snakeBody = new SnakePiece(getSnakeHeadX(), getSnakeHeadY());
        }else{
            snakeBody = new SnakePiece(snake.get(snake.size()-1).getTopLX(), snake.get(snake.size()-1).getTopLY());
        }
        snake.add(snakeBody);
        canvas.add(snakeBody.getShape());
        System.out.println("getfood");
    }
}

