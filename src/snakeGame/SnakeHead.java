package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;

public class SnakeHead extends Block{

    private Block snakeHeadShape;
    private double blockSize,topLX,topLY;

    public SnakeHead(double topLX, double topLY){
        super(topLX, topLY);
        
        this.topLX = topLX;
        this.topLY = topLY;
        snakeHeadShape = new Block(topLX, topLY);
        this.blockSize = snakeHeadShape.getBlockSize();
        snakeHeadShape.setImgPath("snake-parts/bsnake_head_up.png");
    }
    
    @Override
    public GraphicsObject getShape() {
        return snakeHeadShape.getShape();
    }

    @Override
    public void setTopLY(double newTopLY) {
        this.topLY = newTopLY;
    }

    @Override
    public void setTopLX(double newTopLX) {
        this.topLX = newTopLX;
    }

    @Override
    public void setPosition(double topLX, double topLY) {
        snakeHeadShape.setPosition(topLX, topLY);
        this.topLX = topLX;
        this.topLY = topLY;
    }

    @Override
    public double getTopLY() {
        return topLY;
    }

    @Override
    public double getTopLX() {
        return topLX;
    }

    @Override
    public double getBlockSize(){
        return blockSize;
    }
}
