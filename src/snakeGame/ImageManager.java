package snakeGame;

import edu.macalester.graphics.GraphicsObject;

/**
 * This class keeps track of generating images for the snake
 * body and the food, depending on the level. 
 */
public class ImageManager {
    // instance variables
    private String level;
    private int i;
    private boolean c = true;

    /**
    * Constructor for the ImageManager class.
    **/
    public ImageManager(String level) {
        this.level = level;
        i = 0;
    }

    /**
    * Assigns a level of difficulty. 
    */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
    * Returns the level of difficulty. 
    */
    public String getLevel() {
        return level;
    }

    /**
    * Moves the snake across the canvas, allowing 
    * for it to start over once the snake has left the screen.
    */
    public void animateSnake(GraphicsObject snake) {
        if (snake.getPosition().getX() < 650) {
            i = i + 3;
            snake.setPosition(-600+i,0);
        } else {
            snake.setPosition(-600,0);
            i = 0;
        }
    }

    /**
    * Moves the cloud image up and down.
    */
    public void animateCloud(GraphicsObject cloud) {
        if (c) {
            cloud.setPosition(0,cloud.getPosition().getY()+0.25);
            if (cloud.getPosition().getY()>5) {
                c = false;
            }
        } else {
            cloud.setPosition(0,cloud.getPosition().getY()-0.25);
            if (cloud.getPosition().getY()<-5) {
                c = true;
            }
        }
    }

    /**
    * Returns the corresponding image of the folder and picture parameters.
    */
    public String getImagePathString(String folder, String picture) {
        return folder + "/" + level + picture + ".png";
    }

    /**
    * Returns the blue background image.
    */
    public String getBgImage(){
        return getImagePathString("level-backgrounds", "_bg");
    }

    /**
    * Assigns the image of the snake head depending on which direction it
    * is facing (up,down,right,left).
    */
    public String getSnakeHeadImage(SnakeHead snake, String direction){
        if(direction == "up"){
            return getImagePathString("snake-parts", "snake_head_up");
        }
        if(direction == "down"){
            return getImagePathString("snake-parts", "snake_head_down");
        }
        if(direction == "left"){
            return getImagePathString("snake-parts", "snake_head_left");
        }
        else {
            return getImagePathString("snake-parts", "snake_head_right");
        }
    }

    /**
    * Assigns the correct snake images to the body of the snake depending
    * on which direction the head is facing (up,down,right,left).
    */
    public String getSnakePieceImage(SnakePiece snake, String direction){
        if(direction == "up"){
            return getImagePathString("snake-parts", "snake_body_up");
        }
        if(direction == "down"){
            return getImagePathString("snake-parts", "snake_body_down");
        }
        if(direction == "left"){
            return getImagePathString("snake-parts", "snake_body_left");
        }
        if(direction == "right"){
            return getImagePathString("snake-parts", "snake_body_right");
        }
        else  {
            return null;
        }
    }

    /**
    * Assigns the correct snake end image to the rear of the body of the snake 
    * depending on which direction the head is facing (up,down,right,left).
    */
    public String getSnakeEndImage(SnakePiece snake, String direction){
        if(direction == "up"){
            return getImagePathString("snake-parts", "snake_end_up");
        }
        if(direction == "down"){
            return getImagePathString("snake-parts", "snake_end_down");
        }
        if(direction == "left"){
            return getImagePathString("snake-parts", "snake_end_left");
        }
        if(direction == "right"){
            return getImagePathString("snake-parts", "snake_end_right");
        }
        else  {
            return null;
        }
    }

    /**
    * Assigns the correct curved snake image to the body of the snake where the
    * head of the snake changes directions. 
    */
    public String getSnakeCurveImage(SnakePiece snake, String directionBefore, String directionAfter){
        // down to left turn
        if (directionBefore == "down" && directionAfter == "left") {
            return getImagePathString("snake-parts", "snake_curve_up-left");
        } 
        // down to right turn
        if (directionBefore == "down" && directionAfter == "right") {
            return getImagePathString("snake-parts", "snake_curve_up-right");
        }
        // up to left turn
        if (directionBefore == "up" && directionAfter == "left") {
            return getImagePathString("snake-parts", "snake_curve_down-left");
        } 
        // up to right turn
        if (directionBefore == "up" && directionAfter == "right") {
            return getImagePathString("snake-parts", "snake_curve_down-right");
        } 
        // left to down turn
        if (directionBefore == "left" && directionAfter == "down") {
            return getImagePathString("snake-parts", "snake_curve_right-down");
        } 
        // left to up turn
        if (directionBefore == "left" && directionAfter == "up") {
            return getImagePathString("snake-parts", "snake_curve_right-up");
        } 
        if (directionBefore == "right" && directionAfter == "down") {
            return getImagePathString("snake-parts", "snake_curve_left-down");
        } 
        // right to up turn
        if (directionBefore == "right" && directionAfter == "up") {
            return getImagePathString("snake-parts", "snake_curve_left-up");
        } 
        else {
            return null;
        }
    }

    /**
    * Returns the food image, either fruit or bug. 
    */
    public String getFoodImage(String food){
        if(food  == "bug"){
            return getImagePathString("food", "bug");
        } else{
            return getImagePathString("food", "fruit");
        }
    }
}
    
