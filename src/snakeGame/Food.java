package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;
import javax.swing.plaf.ColorUIResource;

public class Food {
    //produce small circles
    private Ellipse foodShape;
    private double radius;
    private final Color FOOD_COLOR = new ColorUIResource(0, 0, 0);
    public Food(double centerX, double centerY){
        foodShape = new Ellipse(centerX, centerY, radius, radius);
        foodShape.setFillColor(FOOD_COLOR);
        foodShape.setStroked(false);
    }
    public Ellipse getFoodShape(){
        return foodShape;
    }
}
