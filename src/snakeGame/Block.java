package snakeGame;

import edu.macalester.graphics.*;

/**
 * A class that defines a block, used for creating the body of the snake and
 * food.
 */
public class Block{
    // instance variables
    private double blockSize;
    private Image shape;
    private double topLX;
    private double topLY;

    /**
    * Constructor for the block class.
    *
    * @param topLX        The top left x-position of the block
    * @param topLY        The top left y-position of the block
    */
    public Block(double topLX, double topLY){
        this.blockSize = 30;
        this.topLX = topLX;
        this.topLY = topLY;
        shape = new Image(topLX, topLY);
    }

    /**
    * Returns the shape of the block.
    */
    public GraphicsObject getShape(){
        return shape;
    }

    /**
    * Moves this block's upper left corner to the given
    * y-position, preserving its size.
    */
    public void setTopLY(double newTopLY) {
        this.topLY = newTopLY;
    }

    /**
    * Moves this block's upper left corner to the given
    * x-position, preserving its size. 
    */
    public void setTopLX(double newTopLX) {
        this.topLX = newTopLX;
    }

    /**
    * Moves this block's upper left corner to the given
    * position, preserving its size. 
    */
    public void setPosition(double topLX, double topLY) {
        shape.setPosition(topLX, topLY);
    }

    /**
    * Returns the block's upper left y-position.
    */
    public double getTopLY() {
        return topLY;
    }

    /**
    * Returns the block's upper left x-position.
    */
    public double getTopLX() {
        return topLX;
    }

    /**
    * Returns the size of the block.
    */
    public double getBlockSize(){
        return blockSize;
    }

    /**
    * Sets the block equal to a given image path.
    */
    public void setImgPath(String path){
        shape.setImagePath(path);
    }
}
