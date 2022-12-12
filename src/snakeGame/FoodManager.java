package snakeGame;

import java.util.Random;
import edu.macalester.graphics.*;
import java.util.ArrayList;

/**
 * This class keeps track of creating the food for the snake and
 * destroying it when collsion has occured between itself and the head
 * of the snake.
 */
public class FoodManager {
    // instance variables
    private Random r = new Random();
    private CanvasWindow canvas;
    private Food food;
    private ArrayList<Point> gridPointList;
    private Point foodPos;
    private ImageManager imageManager;
    private String foodType;

    /**
    * Constructor for the FoodManager class.
    **/
    public FoodManager(CanvasWindow canvas, ArrayList<Point> gridPointList, String level, ImageManager imageManager){
        this.canvas = canvas;
        this.imageManager = imageManager;
        this.gridPointList = gridPointList;
        foodPos = new Point(0,0);
        food = new Food(foodPos.getX(), foodPos.getY());
    }

    /**
    * Returns the type of food.
    */
    public String getFoodType() {
        return foodType;
    }

    /**
    * Returns the upper left x-position of the food.
    */
    public double getFoodX() {
        return foodPos.getX();
    }

    /**
    * Returns the upper left y-position of the food.
    */
    public double getFoodY() {
        return foodPos.getY();
    }

    /**
    * Generates a food randomly and adds its corresponding
    * image to the canvas.
    */
    public void makeFood(ArrayList<SnakePiece> snake, SnakeHead head) { 
        randomlySetFoodType();
        randomlySetFoodPos(food,snake,head);
        food.getFoodShape().setImgPath(imageManager.getFoodImage(foodType));
        canvas.add(food.getShape());
    }

    /**
    * Randomly selects a type of food, depending on the probabilty
    * for its type to be selected (30% of the time its a bug, 70%
    * of the time it is a fruit).
    */
    private void randomlySetFoodType(){
        int randomInt = r.nextInt(100);
        if(randomInt<=30){
            foodType = "bug";
        }else{
            foodType = "fruit";
        }
    }

    /**
    * Randomly sets the position of the food within the canvas and
    * ensures it is not set on the snake. 
    */
    private void randomlySetFoodPos(Food food,ArrayList<SnakePiece> snake, SnakeHead head) {
        ArrayList<Point> foodPointList = new ArrayList<Point>();
        for(Point p: gridPointList){
            for(SnakePiece s: snake){
                if(p.getX()!=s.getTopLX()&&p.getY()!=s.getTopLY()){
                    foodPointList.add(p);
                }
            }
            if(p.getX()==head.getTopLX()&&p.getY()==head.getTopLY()){
                foodPointList.remove(p);
            }
        }
        int randomInt = r.nextInt(foodPointList.size());
        foodPos = foodPointList.get(randomInt);
        food.getShape().setPosition(foodPos);
    }
}
