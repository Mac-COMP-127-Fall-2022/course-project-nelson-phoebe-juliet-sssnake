package snakeGame;

import edu.macalester.graphics.*;

/**
 * A class that defines a snake piece, used to create the body
 * of the snake.
 */
public class SnakePiece extends Block{
    // instance variables
    private Block snakePieceShape;
    private double blockSize,topLX,topLY;
    private ImageManager imageManager;

    /**
     * Constructor for the SnakePiece class.  
     */    
    public SnakePiece(double topLX, double topLY, ImageManager imageManager){
        super(topLX, topLY);
        this.topLX = topLX;
        this.topLY = topLY;
        this.imageManager = imageManager;
        snakePieceShape = new Block(topLX, topLY);
        this.blockSize = snakePieceShape.getBlockSize();
    }
    
    /**
     * Returns the shape of the snake piece.
     */
    @Override
    public GraphicsObject getShape() {
        return snakePieceShape.getShape();
    }

    /**
     * Moves this snake piece's upper left corner to the given
     * y-position, preserving its size.
     */
    @Override
    public void setTopLY(double newTopLY) {
        this.topLY = newTopLY;
    }

    /**
     * Moves this snake piece's upper left corner to the given
     * x-position, preserving its size.
     */
    @Override
    public void setTopLX(double newTopLX) {
        this.topLX = newTopLX;
    }

    /**
     * Moves this snake piece's upper left corner to the given
     * position, preserving its size. 
     */
    @Override
    public void setPosition(double topLX, double topLY) {
        snakePieceShape.setPosition(topLX, topLY);
    }

    /**
     * Assigns the correct image to the snake piece depending
     * on the direction the head is facing.
     */
    public void setSnakePieceImg(String direction){
        snakePieceShape.setImgPath(imageManager.getSnakePieceImage(this, direction));
        
    }

    /**
     * Assigns the correct image to the tail of the snake depending
     * on the direction the head is facing.
     */
    public void setSnakeEndImg(String direction){
        snakePieceShape.setImgPath(imageManager.getSnakeEndImage(this, direction));
    }

    /**
     * Assigns the correct image to the curve of the snake, depending
     * on how the head changes directions.
     */
    public void setSnakeCurveImg(String directionBefore, String directionAfter){
        snakePieceShape.setImgPath(imageManager.getSnakeCurveImage(this, directionBefore, directionAfter));
    }

    /**
     * Returns the snake piece's upper left y-position.
     */
    @Override
    public double getTopLY() {
        return topLY;
    }

    /**
     * Returns the snake piece's upper left s-position.
     */
    @Override
    public double getTopLX() {
        return topLX;
    }

    /**
     * Returns the size of the block piece.
     */
    @Override
    public double getBlockSize(){
        return blockSize;
    }
}
