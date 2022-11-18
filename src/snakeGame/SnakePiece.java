package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;

public class SnakePiece {
    //produces circles
    private Block snakePieceShape;
    private double topLX, topLY;

    public SnakePiece(double topLX, double topLY){
        this.topLX = topLX;
        this.topLY = topLY;
        snakePieceShape = new Block(topLX, topLY, Color.green);
    
    }
    //set all the following methods as private just so it will be easier to simplify later
    private double gettopLX(){
        return topLX;
    }
    private double gettopLY(){
        return topLY;
    }
    private void settopLX(double newtopLX){
        topLX = newtopLX;
    }
    private void settopLY(double newtopLY){
        topLY = newtopLY;
    }
    private GraphicsObject getSnakePieceShape(){
        return snakePieceShape.getShape();
    }
    private void renewSnakePieceLocation(){
        snakePieceShape.setPosition();
    }
}
