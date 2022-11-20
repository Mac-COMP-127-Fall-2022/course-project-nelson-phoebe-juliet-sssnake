package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;

public abstract class Block{

    private double blockSize;
    private Rectangle shape;

    private double topLX;
    private double topLY;

    public Block(double topLX, double topLY){
        this.blockSize = 30;

        this.topLX = topLX;
        this.topLY = topLY;

        shape = new Rectangle(topLX, topLY, blockSize, blockSize);
        shape.setStroked(false);
    }    
    public GraphicsObject getShape(){
        return shape;
    }

    public void setTopLY(double newTopLY) {
        this.topLY = newTopLY;
    }

    public void setTopLX(double newTopLX) {
        this.topLX = newTopLX;
    }

    public void setPosition(double topLX, double topLY) {
        shape.setPosition(topLX, topLY);
    }

    public double getTopLY() {
        return topLY;
    }

    public double getTopLX() {
        return topLX;
    }
    public double getBlockSize(){
        return blockSize;
    }
    public void setColor(Color color){
        shape.setFillColor(color);
    }


}
