package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.plaf.ColorUIResource;

public class Food {
    //produce small circles
    private Block foodShape;
    private double blockSize;
    private final Color FOOD_COLOR = new ColorUIResource(0, 0, 0);

    // private double centerX;
    // private double centerY;

    private double topLX;
    private double topLY;


    public Food(double topLX, double topLY){

        foodShape = new Block(topLX, topLY, Color.red);

        this.topLX = topLX;
        this.topLY = topLY;

        // centerX = topLX + blockSize/2;
        // centerY = topLY + blockSize/2;

        // foodShape.setFillColor(FOOD_COLOR);
        // foodShape.setStroked(false);
    }

    public GraphicsObject getFoodShape() {
        return foodShape.getShape();
    }
}
