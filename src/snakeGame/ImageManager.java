package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;


public class ImageManager {
    public void setSnakeHeadImage(SnakeHead snake){
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
}
