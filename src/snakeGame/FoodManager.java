package snakeGame;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;

public class FoodManager {
    //randomly put the rectangle in different places
    private Random r = new Random();
    private CanvasWindow canvas;
    private Food food;
    private double foodCenterX, foodCenterY, maxCenterX, minCenterX, maxCenterY, minCenterY, boundary, topLX, topLY;


    public FoodManager(CanvasWindow canvas){
        this.canvas = canvas;
        topLX = r.nextInt()*(maxCenterX-minCenterX);
        topLY = r.nextDouble()*(maxCenterY-minCenterY);
        food = new Food(0, 0);
        
        this.canvas.add(food.getFoodShape());
    }
    public void resetFood(){
        foodCenterX = minCenterX + r.nextDouble()*(maxCenterX-minCenterX);
        foodCenterY = minCenterY + r.nextDouble()*(maxCenterY-minCenterY);
        food.getFoodShape().setCenter(foodCenterX,foodCenterY);
    }

    public void makeFood(CanvasWindow canvas) {
        foodCenterX = minCenterX + r.nextDouble()*(maxCenterX-minCenterX);
        foodCenterY = minCenterY + r.nextDouble()*(maxCenterY-minCenterY);
        food.getFoodShape().setPosition(topLX, topLY);
        canvas.add(food.getFoodShape());

    }
}
