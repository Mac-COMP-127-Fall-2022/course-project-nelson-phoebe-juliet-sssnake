package snakeGame;

import edu.macalester.graphics.*;


public class SnakePiece extends Block{

    private Block snakePieceShape;
    private double blockSize,topLX,topLY;
    private ImageManager imageManager;

    public SnakePiece(double topLX, double topLY, ImageManager imageManager){
        super(topLX, topLY);
        this.topLX = topLX;
        this.topLY = topLY;

        this.imageManager = imageManager;

        snakePieceShape = new Block(topLX, topLY);
        this.blockSize = snakePieceShape.getBlockSize();
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

    public void setSnakePieceImg(String direction){
        snakePieceShape.setImgPath(imageManager.getSnakePieceImage(this, direction));
        
    }

    public void setSnakeEndImg(String direction){
        snakePieceShape.setImgPath(imageManager.getSnakeEndImage(this, direction));
    }

    public void setSnakeCurveImg(String directionBefore, String directionAfter){
        snakePieceShape.setImgPath(imageManager.getSnakeCurveImage(this, directionBefore, directionAfter));
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
