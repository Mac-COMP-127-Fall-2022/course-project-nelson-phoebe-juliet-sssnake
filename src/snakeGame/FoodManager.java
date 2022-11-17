package snakeGame;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;

public class FoodManager {
    //randomly put the circles in different places
    private Random r = new Random();
    private CanvasWindow canvas;
    private Food food;
    private double foodCenterX, foodCenterY, maxCenterX, minCenterX, maxCenterY, minCenterY, boundary;
    public FoodManager(CanvasWindow canvas){
        this.canvas = canvas;
        boundary = 5;
        //subject to change
        minCenterX = boundary;
        minCenterY = boundary;
        maxCenterX = canvas.getWidth()-boundary;
        maxCenterY = canvas.getHeight()-boundary;
        foodCenterX = minCenterX + r.nextDouble()*(maxCenterX-minCenterX);
        foodCenterY = minCenterY + r.nextDouble()*(maxCenterY-minCenterY);
        food = new Food(foodCenterX, foodCenterY);
        this.canvas.add(food.getFoodShape());
    }
    public void resetFood(){
        foodCenterX = minCenterX + r.nextDouble()*(maxCenterX-minCenterX);
        foodCenterY = minCenterY + r.nextDouble()*(maxCenterY-minCenterY);
        food.getFoodShape().setCenter(foodCenterX,foodCenterY);
    }
}
