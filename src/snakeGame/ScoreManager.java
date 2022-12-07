package snakeGame;

import edu.macalester.graphics.*;

public class ScoreManager {
    private int score = 0;
    private GraphicsText Score;

    public void addScore(){
        score+=10;
    }
    public GraphicsText getScore(){
        Score = new GraphicsText("Score " + score);
        return Score;
    }
    public boolean win(){
        if(score>=300){
            return true;
        }else{
            return false;
        }
    }
}
