package snakeGame;

import edu.macalester.graphics.*;
import java.awt.Color;

/**
 * This class keeps track of the score of the game. The score
 * changes when the snake head collides with the food and depending
 * on the type of food, adds points (5 for fruit, 10 for bug).
 */
public class ScoreManager {
    // instance variables
    private int score = 0;
    private GraphicsText Score;
    private CanvasWindow canvas;
    private String level;
    private Color pink = new Color(227,181 ,190);
    private Color lightPurple = new Color(195,195 ,221);
    private Color lightGreen = new Color(177,197 ,119);

    /**
     * Constructor for the ScoreManager class. 
     */
    public ScoreManager(CanvasWindow canvas){
        this.canvas = canvas;
        Score = new GraphicsText("SCORE: "+score);
        Score.setPosition(160,60);
        Score.setFont(FontStyle.BOLD, 45);
    }

    /**
     * Increments the score by 10 if bug, 5 if fruit.
     */
    public void addScore(String food){
        if (food =="bug"){
            score+=10;
        } else {
            score+=5;
        }
        renewScoreGraphText();
    }

    /**
     * Changes the score to be zero.
     */
    public void setScoreZero(){
        score = 0;
    }

    /**
     * Resets the score equal to zero.
     */
    public void renewScoreGraphText(){
        Score.setText("SCORE: " + score);
    }

    /**
     * Places the score on the canvas.
     */
    public void addScoreToCanvas() {
        canvas.add(Score);
    }

    /**
     * Determines if the game has been won, which is at
     * 150 points.
     */
    public boolean win(){
        if(score>=150){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Changes the color of the score displayed on the screen
     * depending on the level. 
     */
    public void setLevel(String newLevel) {
        level = newLevel;
        if(level == "r"){
            Score.setFillColor(pink);
        }
        if(level == "b"){
            Score.setFillColor(lightPurple);
        }
        if(level == "g"){
            Score.setFillColor(lightGreen);
        }
    }
}
