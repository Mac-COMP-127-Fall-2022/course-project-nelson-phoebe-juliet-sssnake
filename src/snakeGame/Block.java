package snakeGame;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class Block{

    private double blockSize;
    private Rectangle shape;

    private double topLX;
    private double topLY;

    public Block(double topLX, double topLY, Color color){
        this.blockSize = 30;

        this.topLX = topLX;
        this.topLY = topLY;

        shape = new Rectangle(topLX, topLY, blockSize, blockSize);

        // centerX = topLX + blockSize/2;
        // centerY = topLY + blockSize/2;

        shape.setFillColor(color);
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

    public void setPosition() {
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

}
