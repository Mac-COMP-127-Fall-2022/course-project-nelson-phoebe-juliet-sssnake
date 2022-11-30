package snakeGame;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.*;

import java.util.ArrayList;

public class FoodManager {
    //randomly put the rectangle in different places
    private Random r = new Random();
    private CanvasWindow canvas;
    private Food food;
    private ArrayList<Point> gridPointList;
    private Point foodPos;


    public FoodManager(CanvasWindow canvas, ArrayList<Point> gridPointList){
        this.canvas = canvas;

        this.gridPointList = gridPointList;
        //remove points of the snake

        foodPos = (new Point(0,0));

        food = new Food(foodPos.getX(), foodPos.getY());
        
    }

    public void makeFood() {
        int randomInt = r.nextInt(gridPointList.size());
        foodPos = gridPointList.get(randomInt);
        setFoodPos(food);

        //if // food position is at the same position as snake then do again

        canvas.add(food.getShape());
    }

    public Food getFood() {
        return food;
    }

    public void resetFood() {
        canvas.remove(food.getShape());
        int randomInt = r.nextInt(gridPointList.size());
        foodPos = gridPointList.get(randomInt);
        setFoodPos(food);

        //if // food position is at the same position as snake then do again

        canvas.add(food.getShape());
    }

    public void setFoodPos(Food food) {
        food.getShape().setPosition(foodPos);
    }

    public double getFoodX() {
        return foodPos.getX();
    }

    public double getFoodY() {
        return foodPos.getY();
    }
}
