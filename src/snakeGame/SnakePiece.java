package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;
import javax.swing.plaf.ColorUIResource;

public class SnakePiece {
    //produces circles
    private Ellipse snakePieceShape;
    private double centerX, centerY, radius;
    private final Color SNAKE_COLOR = new ColorUIResource(0, 0, 0);
    public SnakePiece(double centerX, double centerY){
        this.centerX = centerX;
        this.centerY = centerY;
        snakePieceShape = new Ellipse(centerX, centerY, radius, radius);
        snakePieceShape.setFillColor(SNAKE_COLOR);
        snakePieceShape.setStroked(false);
    }
    //set all the following methods as private just so it will be easier to simplify later
    private double getCenterX(){
        return centerX;
    }
    private double getCenterY(){
        return centerY;
    }
    private void setCenterX(double newCenterX){
        centerX = newCenterX;
    }
    private void setCenterY(double newCenterY){
        centerY = newCenterY;
    }
    private Ellipse getSnakePieceShape(){
        return snakePieceShape;
    }
    private void renewSnakePieceLocation(){
        snakePieceShape.setCenter(centerX, centerY);
    }
}
