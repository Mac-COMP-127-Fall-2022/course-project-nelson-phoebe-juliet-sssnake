package snakeGame;

import edu.macalester.graphics.*;
import java.util.ArrayList;

public class Board {
    //the snake game
    private CanvasWindow canvas;
    private static final int CANVAS_WIDTH = 640, CANVAS_HEIGHT = 720, BORDER = 20;
    private int speed = 100;
    private String level;
    private ArrayList<Point> gridPointList;

    private boolean gameScreen = false;
    private boolean startScreen = true;
    private boolean difficultyScreen = false;
    private boolean instructionScreen = false;
    private boolean newGame = false;
    private boolean youWinScreen = false;
    private boolean gameOverScreen = false;

    Image startScreenImage = new Image(0, 0, "start-difficulty-gameover/start.png");
    Image difficultyImage = new Image(0, 0, "start-difficulty-gameover/difficulty.png");
    Image gameoverImage = new Image(0, 0, "start-difficulty-gameover/gameover.png");
    Image bgImage = new Image(0, 0, "level-backgrounds/g_bg.png");
    Image instructionImage = new Image(0, 0, "start-difficulty-gameover/instructions.png");
    Image youWinImage = new Image(0, 0, "start-difficulty-gameover/youwin.png");
    Image startScreenSnakeImage = new Image(0, 0, "start-difficulty-gameover/start-snake.png");
    Image difficultyCloudImage = new Image(0, 0, "start-difficulty-gameover/difficulty-cloud.png");

    private Point clickPos = new Point(0, 0);


    public Board(){
        canvas = new CanvasWindow("Snake Game", CANVAS_WIDTH, CANVAS_HEIGHT);
        gridPointList = new ArrayList<Point>();
        level = "r";
    }

    private void setClickPos(Point position) {
        clickPos = position;
    }

    private boolean clickOnStart() {
        // check if click is on the start button
        if (clickPos.getX() > 70 && clickPos.getX() < 582) {
            if (clickPos.getY() > 541 && clickPos.getY() < 701) {
                return true;
            } else { return false; }
        } else { return false; }
    }

    private boolean clickOnRestart() {
        // check if click is on the restart button
        if (clickPos.getX() > 58 && clickPos.getX() < 582) {
            if (clickPos.getY() > 573 && clickPos.getY() < 707) {
                return true;
            } else { return false; }
        } else { return false; }
    }

    private boolean clickOnInstructions() {
        // check if click is on the restart button
        if (clickPos.getX() > 218 && clickPos.getX() < 589) {
            if (clickPos.getY() > 552 && clickPos.getY() < 654) {
                return true;
            } else { return false; }
        } else { return false; }
    }

    private String clickOnDifficulty() {
        
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
        for (int column = BORDER; column < 640-BORDER; column+=((640-BORDER*2)/20)) {
            for (int row = BORDER+80; row < 700-BORDER; row+=((640-BORDER*2)/20)) {
                gridPointList.add(new Point(column, row));
            }
        }
        return gridPointList;
    }

    private void setLevel(String level){
        if (level == "g"){
            speed = 150;
        }
        if (level == "b"){
            speed = 100;
        }
        if (level == "r"){
            speed = 50;
        }
    }


    public void playSnake() {

        gridPointList = getGridPointList();

        canvas.add(bgImage);

        ImageManager imageManager = new ImageManager(level);
        FoodManager foodManager = new FoodManager(canvas, gridPointList,level, imageManager);
        ScoreManager scoreManager = new ScoreManager(canvas);
        SnakeManager snakeManager = new SnakeManager(gridPointList, canvas, BORDER, foodManager, imageManager);
        

        // create a small body before game starts
        snakeManager.moveSnake();

        foodManager.makeFood(snakeManager.getSnake(),snakeManager.getSnakeHead());

        canvas.onKeyDown(event -> {
            snakeManager.changeDirection(event.getKey());
        });

        canvas.onClick(event -> {
            setClickPos(event.getPosition());
        });

        canvas.add(difficultyImage);
        canvas.add(difficultyCloudImage);
        canvas.add(instructionImage);
        canvas.add(startScreenImage);
        canvas.add(startScreenSnakeImage);
        startScreenSnakeImage.setPosition(-600,0);
        
        canvas.draw();

        canvas.animate(() -> {
            
            if(startScreen) {
                imageManager.animateSnake(startScreenSnakeImage);
                canvas.draw();
                
                if (clickOnStart()){
                    canvas.remove(startScreenImage);
                    canvas.remove(startScreenSnakeImage);
                    
                    canvas.draw();
                    instructionScreen = true;
                    startScreen = false;
                    clickPos = new Point(0,0);
                }
            }

            if(instructionScreen) {
                if (clickOnInstructions()){
                    canvas.remove(instructionImage);
                    canvas.draw();
                    difficultyScreen = true;
                    instructionScreen = false;
                }
            }

            if (difficultyScreen) {

                imageManager.animateCloud(difficultyCloudImage);

                String difficultySeclection = clickOnDifficulty();
                if (difficultySeclection != null) {

                    level = difficultySeclection;
                    imageManager.setLevel(difficultySeclection);
                    snakeManager.setLevel(difficultySeclection);
                    scoreManager.setLevel(difficultySeclection);

                    foodManager.makeFood(snakeManager.getSnake(),snakeManager.getSnakeHead());

                    bgImage.setImagePath(imageManager.getBgImage());
                    setLevel(difficultySeclection);

                    snakeManager.resetSnake();

                    gameScreen = true;
                    newGame = true;
                    difficultyScreen = false;
                }
            }

            if(gameScreen){
                if(newGame) {
                    canvas.remove(difficultyImage);
                    canvas.remove(difficultyCloudImage);
                    snakeManager.moveSnake();
                    scoreManager.addScoreToCanvas();
                    canvas.draw();
                    canvas.pause(1000);
                    newGame = false;
                }
                canvas.pause(speed);

                snakeManager.moveSnake();
                String collisionTest = snakeManager.checkCollision(foodManager);
                if(collisionTest != "no"){
                    if (collisionTest == "food"){
                        scoreManager.addScore(foodManager.getFoodType());
                        foodManager.makeFood(snakeManager.getSnake(),snakeManager.getSnakeHead());
                        snakeManager.snakeGrow(foodManager);
                    }

                    if (collisionTest == "border"){
                        snakeManager.stop();
                        gameScreen = false;
                        gameOverScreen = true;
                        newGame = true;
                    }

                    if(collisionTest == "snake"){
                        gameScreen = false;
                        gameOverScreen = true;
                        newGame = true;
                    }
                }

                if(scoreManager.win()){
                    gameScreen = false;
                    youWinScreen = true;
                    newGame = true;
                }

                canvas.draw();
            }

            if(youWinScreen) {
                if(newGame){
                    scoreManager.setScoreZero();;
                    scoreManager.renewScoreGraphText();
                    canvas.add(youWinImage);
                    newGame=false;
                }
                if(clickOnRestart()){
                    canvas.remove(youWinImage);
                    canvas.add(difficultyImage);
                    canvas.add(difficultyCloudImage);

                    canvas.draw();
                    
                    youWinScreen = false;
                    difficultyScreen = true;
                }
            }

            if(gameOverScreen) {
                if(newGame){
                    scoreManager.setScoreZero();;
                    scoreManager.renewScoreGraphText();
                    canvas.add(gameoverImage);
                    newGame=false;
                }
                if(clickOnRestart()){
                    canvas.remove(gameoverImage);
                    canvas.add(difficultyImage);
                    canvas.add(difficultyCloudImage);

                    canvas.draw();

                    gameOverScreen = false;
                    difficultyScreen = true;
                }
            }
        });
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.playSnake();
    }
}
