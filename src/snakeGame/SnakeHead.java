package snakeGame;

import edu.macalester.graphics.*;

/**
 * A class that defines the snake head.
 */
public class SnakeHead extends Block{
    // instance variables
    private Block snakeHeadShape;
    private double blockSize,topLX,topLY;
    private ImageManager imageManager;

    /**
     * Constructor for the SnakeHead class. 
     */
    public SnakeHead(double topLX, double topLY, ImageManager imageManager){
        // instance variables
        super(topLX, topLY);
        this.imageManager = imageManager;
        this.topLX = topLX;
        this.topLY = topLY;
        snakeHeadShape = new Block(topLX, topLY);
        this.blockSize = snakeHeadShape.getBlockSize();
    }
    
    /**
     * Returns the shape of the head.
     */
    @Override
    public GraphicsObject getShape() {
        return snakeHeadShape.getShape();
    }

    /**
     * Assigns the snake head image depending on the direction it is facing.
     */
    public void setSnakeHeadImg(String direction){
        snakeHeadShape.setImgPath(imageManager.getSnakeHeadImage(this, direction));
    }

    /**
     * Moves the snake head's upper left corner to the given
     * y-position, preserving its size.
     */
    @Override
    public void setTopLY(double newTopLY) {
        this.topLY = newTopLY;
    }

    /**
     * Moves the snake head's upper left corner to the given
     * x-position, preserving its size.
     */
    @Override
    public void setTopLX(double newTopLX) {
        this.topLX = newTopLX;
    }

    /**
     * Moves the head's upper left corner to the given
     * position, preserving its size. 
     */
    @Override
    public void setPosition(double topLX, double topLY) {
        snakeHeadShape.setPosition(topLX, topLY);
        this.topLX = topLX;
        this.topLY = topLY;
    }

    /**
     * Returns the block's upper left y-position.
     */    
    @Override
    public double getTopLY() {
        return topLY;
    }

    /**
     * Returns the block's upper left x-position.
     */  
    @Override
    public double getTopLX() {
        return topLX;
    }

    /**
     * Returns the size of the snake head.
     */  
    @Override
    public double getBlockSize(){
        return blockSize;
    }
}
