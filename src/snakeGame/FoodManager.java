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

        food = new Food(0, 0);
        foodPos = (new Point(0,0));
    }

    public void makeFood() {
        int randomInt = r.nextInt(gridPointList.size());
        foodPos = gridPointList.get(randomInt);
        setFoodPos(food);

        //if // food position is at the same position as snake then do again

        canvas.add(food.getShape());
    }

    public void setFoodPos(Food food) {
        food.getShape().setPosition(foodPos);
    }
}
