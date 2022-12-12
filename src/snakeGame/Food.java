package snakeGame;

import edu.macalester.graphics.*;

/**
 * A class that defines food.
 */
public class Food extends Block{
    // instance variables
    private Block foodShape;
    private double blockSize,topLX,topLY;

    /**
    * Constructor for the food class.
     *
     * @param topLX        The top left x-position of the food
     * @param topLY        The top left y-position of the food
     */
    public Food(double topLX, double topLY){
        super(topLX, topLY);
        this.topLX = topLX;
        this.topLY = topLY;
        foodShape = new Block(topLX, topLY);
    }

    /**
     * Returns the shape of the block.
     */
    @Override
    public GraphicsObject getShape() {
        return foodShape.getShape();
    }

    /**
     * Returns the shape of the food.
     */
    public Block getFoodShape() {
        return foodShape;
    }

    /**
     * Moves this block's upper left corner to the given
     * y-position, preserving its size.
     */
    @Override
    public void setTopLY(double newTopLY) {
        this.topLY = newTopLY;
    }

    /**
     * Moves this block's upper left corner to the given
     * x-position, preserving its size.
     */
    @Override
    public void setTopLX(double newTopLX) {
        this.topLX = newTopLX;
    }

    /**
     * Moves this block's upper left corner to the given
     * position, preserving its size. 
     */
    @Override
    public void setPosition(double topLX, double topLY) {
        foodShape.setPosition(topLX, topLY);
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
     * Returns the size of the block.
     */
    @Override
    public double getBlockSize(){
        return blockSize;
    }
}
