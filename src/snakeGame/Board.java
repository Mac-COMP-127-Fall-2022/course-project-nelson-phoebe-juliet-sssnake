package snakeGame;

import edu.macalester.graphics.*;

import java.awt.Color;
import java.util.ArrayList;



public class Board {
    //the snake game
    private CanvasWindow canvas;
    private Image bg;
    private static final int CANVAS_WIDTH = 640, CANVAS_HEIGHT = 720, border = 20;

    private boolean gameScreen = false;
    private boolean startScreen = true;
    private boolean restartScreen = false;
    private boolean difficultyScreen = false;
    private boolean newGame = false;

    Image startScreenImage = new Image(0, 0, "start-difficulty-gameover/start.png");
    Image difficultyImage = new Image(0, 0, "start-difficulty-gameover/difficulty.png");
    Image gameoverImage = new Image(0, 0, "start-difficulty-gameover/gameover.png");
    Image bgImage = new Image(0, 0, "level-backgrounds/g_bg.png");

    private Point clickPos = new Point(0, 0);

    private String level;

    private GraphicsText win = new GraphicsText("win!");

    private ArrayList<Point> gridPointList;

    public Board(){

        canvas = new CanvasWindow("Snake Game", CANVAS_WIDTH, CANVAS_HEIGHT);
        gridPointList = new ArrayList<Point>();
        this.level = "r";
        

    }

    public double getCanvasWidth(){
        return CANVAS_WIDTH;
    }

    public double getCanvasHeight(){
        return CANVAS_HEIGHT;
    }

    public double getBorder(){
        return border;
    }

    public void setClickPos(Point position) {
        this.clickPos = position;
    }

    public boolean clickOnStart() {
        // check if click is on the start button
        if (clickPos.getX() > 70 && clickPos.getX() < 582) {
            if (clickPos.getY() > 541 && clickPos.getY() < 701) {
                return true;
            } else { return false; }
        } else { return false; }
    }

    public boolean clickOnRestart() {
        // check if click is on the restart button
        if (clickPos.getX() > 58 && clickPos.getX() < 582) {
            if (clickPos.getY() > 573 && clickPos.getY() < 707) {
                return true;
            } else { return false; }
        } else { return false; }
    }

    public String clickOnDifficulty() {
        System.out.println(clickPos);
        // check if click is on the a difficulty button, if so, which
        if (clickPos.getY() > 373 && clickPos.getY() < 565) {
            if (clickPos.getX() > 26 && clickPos.getX() < 211) {
                return "g";
            } if (clickPos.getX() > 224 && clickPos.getX() < 410) { 
                return "b";
            } if (clickPos.getX() > 416 && clickPos.getX() < 608) { 
                return "r";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private ArrayList<Point> getGridPointList() {
        for (int column = border; column < 640-border; column+=((640-border*2)/20)) {
            for (int row = border+80; row < 700-border; row+=((640-border*2)/20)) {
                gridPointList.add(new Point(column, row));
            }
        }
        // System.out.println(gridPointList);
        return gridPointList;
    }
    private void win(){
        canvas.removeAll();
        win.setCenter(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
        canvas.add(win);
    }
    

    public static void main(String[] args) {
        Board board = new Board();
        board.playSnake();
    }


    public void playSnake() {

        gridPointList = getGridPointList();

        canvas.add(bgImage);

        FoodManager foodManager = new FoodManager(canvas, gridPointList);
        foodManager.makeFood();

        ImageManager imageManager = new ImageManager(level);

        SnakeManager snakeManager = new SnakeManager(gridPointList, canvas, border, foodManager, imageManager);

        

        // create a small body before game starts
        snakeManager.moveSnake();
        snakeManager.moveSnake();

        canvas.onKeyDown(event -> {
            snakeManager.changeDirection(event.getKey());
        });

        canvas.onClick(event -> {
            setClickPos(event.getPosition());
        });

        
        canvas.add(difficultyImage);
        canvas.add(startScreenImage);
        

        canvas.draw();


        canvas.animate(() -> {
            
            if(startScreen) {
                if (clickOnStart()){
                    canvas.remove(startScreenImage);
                    canvas.draw();
                    difficultyScreen = true;
                    startScreen = false;
                }
            }

            if (difficultyScreen) {
                String difficultySeclection = clickOnDifficulty();
                if (difficultySeclection != null) {
                    this.level = difficultySeclection;
                    imageManager.setLevel(difficultySeclection);
                    snakeManager.setLevel(difficultySeclection);
                    bgImage.setImagePath(imageManager.getBgImage());
                    gameScreen = true;
                    newGame = true;
                    difficultyScreen = false;
                }
            }

            if(gameScreen){


                if(newGame) {
                    canvas.remove(difficultyImage);
                    snakeManager.moveSnake();
                    canvas.draw();
                    canvas.pause(1000);
                    newGame = false;
                }

                canvas.pause(100);
                snakeManager.moveSnake();
                String collisionTest = snakeManager.checkCollision(foodManager);
                if(collisionTest != "no"){
                    if (collisionTest == "food"){
                        foodManager.resetFood(snakeManager.getSnake(),snakeManager.getSnakeHead());
                        snakeManager.snakeGrow(foodManager);
                    }

                    if (collisionTest == "snake"||collisionTest == "border"){
                        snakeManager.stop();
                    }
                };
                if(snakeManager.getScore()>=300){
                    win();
                }
                canvas.draw();
            }
        });
    }
}
