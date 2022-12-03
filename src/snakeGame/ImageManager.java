package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;


public class ImageManager {

    public ImageManager() {

    }
    public String getSnakeHeadImage(SnakeHead snake, String direction){

        if(direction == "up"){
            return "snake-parts/bsnake_head_up.png";
        }
        if(direction == "down"){
            return "snake-parts/bsnake_head_down.png";
        }
        if(direction == "left"){
            return "snake-parts/bsnake_head_left.png";
        }
        else {
            return "snake-parts/bsnake_head_right.png";
        }
    }

    public String getSnakePieceImage(SnakePiece snake, String direction){
        if(direction == "up"){
            return "snake-parts/bsnake_body_up.png";
        }
        if(direction == "down"){
            return "snake-parts/bsnake_body_down.png";
        }
        if(direction == "left"){
            return "snake-parts/bsnake_body_left.png";
        }
        if(direction == "right"){
            return "snake-parts/bsnake_body_right.png";
        }
        else  {
            return null;
        }
    }

    public String getSnakeEndImage(SnakePiece snake, String direction){
        if(direction == "up"){
            return "snake-parts/bsnake_end_up.png";
        }
        if(direction == "down"){
            return "snake-parts/bsnake_end_down.png";
        }
        if(direction == "left"){
            return "snake-parts/bsnake_end_left.png";
        }
        if(direction == "right"){
            return "snake-parts/bsnake_end_right.png";
        }
        else  {
            return null;
        }
    }

    public String getSnakeCurveImage(SnakePiece snake, String directionBefore, String directionAfter){

        if (directionBefore == "up" && directionAfter == "left") {
            return "snake-parts/bsnake_curve_up-left.png"; 
        } if (directionBefore == "up" && directionAfter == "right") {
            return "snake-parts/bsnake_curve_up-right.png";
        }

        if (directionBefore == "down" && directionAfter == "left") {
            return "snake-parts/bsnake_curve_down-left.png";
        } if (directionBefore == "down" && directionAfter == "right") {
            return "snake-parts/bsnake_curve_down-right.png";
        } 
        
        if (directionBefore == "left" && directionAfter == "down") {
            return "snake-parts/bsnake_curve_left-down.png";
        } if (directionBefore == "left" && directionAfter == "up") {
            return "snake-parts/bsnake_curve_left-up.png";
        } 
        
        if (directionBefore == "right" && directionAfter == "down") {
            return "snake-parts/bsnake_curve_right-down.png";
        } if (directionBefore == "right" && directionAfter == "up") {
            return "snake-parts/bsnake_curve_right-up.png";
        } 

        else {
            return null;
        }
        
    }}
