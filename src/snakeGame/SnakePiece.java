package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;

public class SnakePiece extends Block{

    private Block snakePieceShape;
    private double blockSize,topLX,topLY;

    public SnakePiece(double topLX, double topLY){
        super(topLX, topLY);
        this.topLX = topLX;
        this.topLY = topLY;
        snakePieceShape = new Block(topLX, topLY);
        this.blockSize = snakePieceShape.getBlockSize();
        // snakePieceShape.setColor(Color.GRAY);
    }
    
    @Override
    public GraphicsObject getShape() {
        return snakePieceShape.getShape();
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
        snakePieceShape.setPosition(topLX, topLY);
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
