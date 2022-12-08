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

    private ImageManager imageManager;

    private String foodType;

    private String level;


    public FoodManager(CanvasWindow canvas, ArrayList<Point> gridPointList, String level, ImageManager imageManager){
        this.canvas = canvas;

        this.level = level;

        this.imageManager = imageManager;

        

        this.gridPointList = gridPointList;
        //remove points of the snake

        foodPos = (new Point(0,0));

        food = new Food(foodPos.getX(), foodPos.getY());
        // food.setImgPath("food/bbug.png");
        
    }

    public void makeFood(ArrayList<SnakePiece> snake, SnakeHead head) { 
        randomlySetFoodType();
        randomlySetFoodPos(food,snake,head);
        food.getFoodShape().setImgPath(imageManager.getFoodImage(foodType));
        canvas.add(food.getShape());
    }

    public void setFoodImage(){
        food.getFoodShape().setImgPath(imageManager.getFoodImage(foodType));
    }

    private void randomlySetFoodType(){
        int randomInt = r.nextInt(100);
        if(randomInt<=25){
            foodType = "bug";
        }else{
            foodType = "fruit";
        }
    }

    public void setLevel(String newLevel) {
        level = newLevel;
    }

    public String getFoodType() {
        return foodType;
    }

    public Food getFood() {
        return food;
    }

    public void randomlySetFoodPos(Food food,ArrayList<SnakePiece> snake, SnakeHead head) {
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

    public double getFoodX() {
        return foodPos.getX();
    }

    public double getFoodY() {
        return foodPos.getY();
    }
}
