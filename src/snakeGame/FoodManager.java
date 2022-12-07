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
        // food.setImgPath("food/bbug.png");
        
    }

    public void makeFood(ArrayList<SnakePiece> snake, SnakeHead head) { 
        randomlySetFoodPos(food);
        while (foodIsOnSnake(snake, head)) {
            randomlySetFoodPos(food);
        }
        canvas.add(food.getShape());
    }

    public Food getFood() {
        return food;
    }

    private boolean foodIsOnSnake(ArrayList<SnakePiece> snake, SnakeHead head){
        for(SnakePiece s: snake){
            if(food.getTopLX()==s.getTopLX()&&food.getTopLY()==s.getTopLY()){
                return true;
            }
        }
        if(food.getTopLX()==head.getTopLX()&&food.getTopLY()==head.getTopLY()){
            return true;
        }
        return false;
    }

    public void randomlySetFoodPos(Food food) {
        int randomInt = r.nextInt(gridPointList.size());
        foodPos = gridPointList.get(randomInt);
        food.getShape().setPosition(foodPos);
    }

    public double getFoodX() {
        return foodPos.getX();
    }

    public double getFoodY() {
        return foodPos.getY();
    }
}
