package snakeGame;

public class ImageManager {

    private String level;

    public ImageManager(String level) {
        this.level = level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public String getImagePathString(String folder, String picture) {
        return folder + "/" + level + picture + ".png";
    }

    public String getBgImage(){
        return getImagePathString("level-backgrounds", "_bg");
    }


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

    public String getSnakeCurveImage(SnakePiece snake, String directionBefore, String directionAfter){

        if (directionBefore == "down" && directionAfter == "left") {
            return getImagePathString("snake-parts", "snake_curve_up-left");
        } if (directionBefore == "down" && directionAfter == "right") {
            return getImagePathString("snake-parts", "snake_curve_up-right");
        }

        if (directionBefore == "up" && directionAfter == "left") {
            return getImagePathString("snake-parts", "snake_curve_down-left");
        } if (directionBefore == "up" && directionAfter == "right") {
            return getImagePathString("snake-parts", "snake_curve_down-right");
        } 
        
        if (directionBefore == "left" && directionAfter == "down") {
            return getImagePathString("snake-parts", "snake_curve_right-down");
        } if (directionBefore == "left" && directionAfter == "up") {
            return getImagePathString("snake-parts", "snake_curve_right-up");
        } 
        
        if (directionBefore == "right" && directionAfter == "down") {
            return getImagePathString("snake-parts", "snake_curve_left-down");
        } if (directionBefore == "right" && directionAfter == "up") {
            return getImagePathString("snake-parts", "snake_curve_left-up");
        } 

        else {
            return null;
        }
        
    }
    public String getFoodImage(String food){

        if(food  == "bug"){
            return getImagePathString("food", "bug");
        } else{
            return getImagePathString("food", "fruit");
        }
    }
}
    
