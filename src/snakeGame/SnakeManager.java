package snakeGame;

import java.util.ArrayList;

import java.lang.String;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class SnakeManager {
    private ArrayList<SnakePiece> snake = new ArrayList<>();
    private double headX, headY,newHeadX,newHeadY;
    private int score=0;
    private CanvasWindow canvas;
    private SnakeHead snakeHead;
    private boolean move = true;
    private String direction;
    private double border;


    public SnakeManager(ArrayList<Point> gridPointList, CanvasWindow canvas, double border){

        direction = "up";

        this.border = border;
       
        snakeHead = new SnakeHead(gridPointList.get(50).getX(), gridPointList.get(50).getY() );

        headX = snakeHead.getTopLX();
        headY = snakeHead.getTopLY();

        this.canvas = canvas;

    }
    public void startSnake(){
        canvas.add(snakeHead.getShape());
    }

    public String checkCollision(FoodManager foodManager){
        if(snakeHead.getTopLX() == foodManager.getFoodX() && snakeHead.getTopLY() == foodManager.getFoodY()) {
            score+=10;
            return "food";
        }

        for (SnakePiece snakePiece : snake) {
            if(snakeHead.getTopLX()==snakePiece.getTopLX()&&snakeHead.getTopLY()==snakePiece.getTopLY()){
                return "snake";
            }
        }

        if (headX < border || headY > canvas.getHeight()-border-snakeHead.getBlockSize()|| headX > canvas.getWidth()- border- snakeHead.getBlockSize() || headY < border) {
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

        if(move){
            if(ifHeadOnBound()){
                //for each snake piece set position to the previous one's
                for(int pieceNumber=snake.size(); pieceNumber>0;pieceNumber--){
                    if(pieceNumber>1){
                        snake.get(pieceNumber-1).setPosition(snake.get(pieceNumber-2).getTopLX(), snake.get(pieceNumber-2).getTopLY());
                        snake.get(pieceNumber-1).setTopLX(snake.get(pieceNumber-2).getTopLX());
                        snake.get(pieceNumber-1).setTopLY(snake.get(pieceNumber-2).getTopLY());
                    }else{
                        snake.get(pieceNumber-1).setPosition(headX, headY);
                        snake.get(pieceNumber-1).setTopLX(headX);
                        snake.get(pieceNumber-1).setTopLY(headY);
                    }
                }
                headY = newHeadY;
                headX = newHeadX;
                snakeHead.setPosition(headX, headY);
            }
        }
    }

    private boolean ifHeadOnBound(){
        if(direction == "up"){
            newHeadY = headY - snakeHead.getBlockSize();
            newHeadX = headX;
        }

        if(direction == "down"){
            newHeadY = headY + snakeHead.getBlockSize();
            newHeadX = headX;
        }

        if(direction == "left"){
            newHeadX = headX - snakeHead.getBlockSize();
            newHeadY = headY;
        }

        if(direction == "right"){
            newHeadX = headX + snakeHead.getBlockSize();
            newHeadY = headY;
        }

        if(newHeadX>=border&&newHeadX<=canvas.getWidth()-border-snakeHead.getBlockSize()&&newHeadY>=border&&newHeadY<=canvas.getHeight()-border-snakeHead.getBlockSize()){
            return true;
        }else{
            return false;
        }
    }

    public double getSnakeHeadX() {
        return headX;
    }

    public double getSnakeHeadY() {
        return headY;
    }

    public void snakeGrow(FoodManager foodManager){
        SnakePiece snakeBody;
        if(direction == "up"){
            if(snake.size()==0){
                snakeBody = new SnakePiece(getSnakeHeadX(), getSnakeHeadY()+snakeHead.getBlockSize());
            }else{
                snakeBody = new SnakePiece(snake.get(snake.size()-1).getTopLX(), snake.get(snake.size()-1).getTopLY()+snakeHead.getBlockSize());
            }
        }else if(direction == "down"){
            if(snake.size()==0){
                snakeBody = new SnakePiece(getSnakeHeadX(), getSnakeHeadY()-snakeHead.getBlockSize());
            }else{
                snakeBody = new SnakePiece(snake.get(snake.size()-1).getTopLX(), snake.get(snake.size()-1).getTopLY()-snakeHead.getBlockSize());
            }
        }else if(direction == "left"){
            if(snake.size()==0){
                snakeBody = new SnakePiece(getSnakeHeadX()+snakeHead.getBlockSize(), getSnakeHeadY());
            }else{
                snakeBody = new SnakePiece(snake.get(snake.size()-1).getTopLX()+snakeHead.getBlockSize(), snake.get(snake.size()-1).getTopLY());
            }
        }else{//direction == "right"
            if(snake.size()==0){
                snakeBody = new SnakePiece(getSnakeHeadX()-snakeHead.getBlockSize(), getSnakeHeadY());
            }else{
                snakeBody = new SnakePiece(snake.get(snake.size()-1).getTopLX()-snakeHead.getBlockSize(), snake.get(snake.size()-1).getTopLY());
            }
        }
        snake.add(snakeBody);
        canvas.add(snakeBody.getShape());
    }
    
    public void stop(){
        move=false;
    }
    public int getScore(){
        return score;
    }
    public ArrayList<SnakePiece> getSnake(){
        return snake;
    }
    public SnakeHead getSnakeHead(){
        return snakeHead;
    }
}

