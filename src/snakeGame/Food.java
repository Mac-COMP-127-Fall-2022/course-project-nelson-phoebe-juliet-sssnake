package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;

public class Food extends Block{

    private Block foodShape;
    private double blockSize,topLX,topLY;

    public Food(double topLX, double topLY){
        super(topLX, topLY);

        this.topLX = topLX;
        this.topLY = topLY;
        foodShape.setColor(Color.RED);
    }

    @Override
    public GraphicsObject getShape() {
        return foodShape.getShape();
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
        foodShape.setPosition(topLX, topLY);
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
