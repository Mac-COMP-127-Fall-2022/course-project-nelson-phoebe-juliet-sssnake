package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;

import javax.swing.plaf.ColorUIResource;

public class ScoreManager {
    private int score = 0;
    private GraphicsText Score;
    private CanvasWindow canvas;
    private String level;
    private Color pink = new Color(227,181 ,190);
    private Color lightPurple = new Color(195,195 ,221);
    private Color lightGreen = new Color(177,197 ,119);

    public ScoreManager(CanvasWindow canvas){
        this.canvas = canvas;
        Score = new GraphicsText("SCORE: "+score);
        Score.setPosition(160,60);
        Score.setFont(FontStyle.BOLD, 45);
    }

    public void addScore(String food){
        if (food =="bug"){
            score+=10;
        } else {
            score+=5;
        }
        
        Score.setText("SCORE: "+score);
    }

    public void setScore(int sc){
        score = sc;
    }
    public void renewScoreGraphText(){
        Score.setText("SCORE: " + score);
    }
    public int getScore(){
        return score;
    }
    public void addScoreToCanvas() {
        canvas.add(Score);
    }

    public boolean win(){
        if(score>=150){
            return true;
        }else{
            return false;
        }
    }
    public void setLevel(String level) {
        this.level = level;
        if(level == "r"){
            Score.setFillColor(pink);
        }
        if(level == "b"){
            Score.setFillColor(lightPurple);
        }if(level == "g"){
            Score.setFillColor(lightGreen);
        }
    }
}
