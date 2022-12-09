package snakeGame;

import edu.macalester.graphics.*;

public class ScoreManager {
    private int score = 0;
    private GraphicsText Score;
    private CanvasWindow canvas;

    public ScoreManager(CanvasWindow canvas){
        this.canvas = canvas;
        Score = new GraphicsText("Score " + score);
        Score.setPosition(152,84);
        Score.setFont(FontStyle.ITALIC, 65);
    }

    public void addScore(String food){
        if (food =="bug"){
            score+=100;
        } else {
            score+=100;
        }
        
        Score.setText("Score " + score);
    }

    public void setScore(int sc){
        score = sc;
    }
    public int getScore(){
        return score;
    }
    public void addScoreToCanvas() {
        canvas.add(Score);
    }

    public boolean win(){
        if(score>=300){
            return true;
        }else{
            return false;
        }
    }
}
