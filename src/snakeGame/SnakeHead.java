package snakeGame;

import edu.macalester.graphics.*;

public class SnakeHead extends Block{

    private Block snakeHeadShape;
    private double blockSize,topLX,topLY;
    private ImageManager imageManager;

    public SnakeHead(double topLX, double topLY, ImageManager imageManager){
        super(topLX, topLY);

        this.imageManager = imageManager;
        this.topLX = topLX;
        this.topLY = topLY;
        snakeHeadShape = new Block(topLX, topLY);
        this.blockSize = snakeHeadShape.getBlockSize();
    }
    
    @Override
    public GraphicsObject getShape() {
        return snakeHeadShape.getShape();
    }

    public void setSnakeHeadImg(String direction){
        snakeHeadShape.setImgPath(imageManager.getSnakeHeadImage(this, direction));
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
