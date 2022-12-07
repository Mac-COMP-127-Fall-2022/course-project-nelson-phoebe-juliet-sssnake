package snakeGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class SnakeManager {
    private ArrayList<SnakePiece> snake = new ArrayList<>();
    private Map<SnakePiece, String> snakeDirection = new HashMap<>();
    private double headX, headY, newHeadX, newHeadY;
    private CanvasWindow canvas;
    private SnakeHead snakeHead;
    private ImageManager imageManager;
    private boolean move = true;

    private String direction;
    private String newDirection;

    private double border;
    
    private String level;



    public SnakeManager(ArrayList<Point> gridPointList, CanvasWindow canvas, double border, FoodManager foodManager, ImageManager imageManager) {

        newDirection = "up";
        direction = "up";

        this.imageManager = imageManager;
        this.level = imageManager.getLevel();

        this.border = border;

        this.canvas = canvas;

        snakeHead = new SnakeHead(gridPointList.get(50).getX(), gridPointList.get(50).getY(), imageManager);

        this.canvas.add(snakeHead.getShape());

        snakeGrow(foodManager);
        snakeGrow(foodManager);

        headX = snakeHead.getTopLX();
        headY = snakeHead.getTopLY();

    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String checkCollision(FoodManager foodManager) {
        if (snakeHead.getTopLX() == foodManager.getFoodX() && snakeHead.getTopLY() == foodManager.getFoodY()) {
            return "food";
        }

        for (SnakePiece snakePiece : snake) {
            if (snakeHead.getTopLX() == snakePiece.getTopLX() && snakeHead.getTopLY() == snakePiece.getTopLY()) {
                return "snake";
            }
        }

        if (headX < border || headY > canvas.getHeight() - border - snakeHead.getBlockSize()
            || headX > canvas.getWidth() - border - snakeHead.getBlockSize() || headY < border) {
            return "border";
        }

        else {
            return "no";
        }
    }

    public void changeDirection(Key key) {
        if (key == Key.LEFT_ARROW) {
            if (direction != "right") {
                newDirection = "left";
            }
        }
        if (key == Key.RIGHT_ARROW) {
            if (direction != "left") {
                newDirection = "right";
            }
        }

        if (key == Key.DOWN_ARROW) {
            if (direction != "up") {
                newDirection = "down";
            }
        }
        if (key == Key.UP_ARROW) {
            if (direction != "down") {
                newDirection = "up";
            }
        }
    }


    public void moveSnake() {
        if (move) {
            if (ifHeadOnBound()) {
                // for each snake piece set position to the previous one's
                for (int pieceNumber = snake.size(); pieceNumber > 0; pieceNumber--) {
                    if(pieceNumber == 1){

                        snake.get(pieceNumber-1).setPosition(headX, headY);
                        snake.get(pieceNumber-1).setTopLX(headX);
                        snake.get(pieceNumber-1).setTopLY(headY);


                        if (direction != snakeDirection.get(snake.get(pieceNumber-1))){
                            snake.get(pieceNumber-1).setSnakeCurveImg(snakeDirection.get(snake.get(pieceNumber-1)), direction);;
                        } else {
                            snake.get(pieceNumber-1).setSnakePieceImg(direction);
                        }

                        snakeDirection.replace(snake.get(pieceNumber-1), direction);

                    } else {

                        snake.get(pieceNumber-1).setPosition(snake.get(pieceNumber-2).getTopLX(),
                        snake.get(pieceNumber-2).getTopLY());
                        snake.get(pieceNumber-1).setTopLX(snake.get(pieceNumber-2).getTopLX());
                        snake.get(pieceNumber-1).setTopLY(snake.get(pieceNumber-2).getTopLY());

                        if (pieceNumber-1==snake.size()-1) {
                            snakeDirection.replace(snake.get(pieceNumber-1), snakeDirection.get(snake.get(pieceNumber-2)));
                            snake.get(pieceNumber-1).setSnakeEndImg(snakeDirection.get(snake.get(pieceNumber-2)));
                        } else {
                            if (snakeDirection.get(snake.get(pieceNumber-1)) != (snakeDirection.get(snake.get(pieceNumber-2)))) {
                                snakeDirection.replace(snake.get(pieceNumber-1), snakeDirection.get(snake.get(pieceNumber-2)));
                                snake.get(pieceNumber-1).setSnakeCurveImg((snakeDirection.get(snake.get(pieceNumber))), (snakeDirection.get(snake.get(pieceNumber-2))));
                            } else {
                                snakeDirection.replace(snake.get(pieceNumber-1), snakeDirection.get(snake.get(pieceNumber-2)));
                                snake.get(pieceNumber-1).setSnakePieceImg(snakeDirection.get(snake.get(pieceNumber-2)));
                            }
                        }

                    }

                } // for loop

                headY = newHeadY;
                headX = newHeadX;
                snakeHead.setPosition(headX, headY);

            } // if head not on bounds
        } // if moving
    } // method
    


    private boolean ifHeadOnBound() {

        if (level == "g" || level == "r") {
            direction = newDirection;
        }

        if (direction == "up") {
            newHeadY = headY - snakeHead.getBlockSize();
            newHeadX = headX;
        }

        if (direction == "down") {
            newHeadY = headY + snakeHead.getBlockSize();
            newHeadX = headX;
        }

        if (direction == "left") {
            newHeadX = headX - snakeHead.getBlockSize();
            newHeadY = headY;
        }

        if (direction == "right") {
            newHeadX = headX + snakeHead.getBlockSize();
            newHeadY = headY;
        }

        if (level == "b") {
            direction = newDirection;
        }
        
        snakeHead.setSnakeHeadImg(direction);

        if (newHeadX >= border && newHeadX <= canvas.getWidth() - border - snakeHead.getBlockSize()
            && newHeadY >= border+80 && newHeadY <= canvas.getHeight() - border - snakeHead.getBlockSize()) {
            return true;
        } else {
            return false;
        }
    }

    public double getSnakeHeadX() {
        return headX;
    }

    public double getSnakeHeadY() {
        return headY;
    }

    public void snakeGrow(FoodManager foodManager) {
        SnakePiece snakeBody;
        if (direction == "up") {
            if (snake.size() == 0) {
                snakeBody = new SnakePiece(getSnakeHeadX(), getSnakeHeadY() + snakeHead.getBlockSize(), imageManager);
            } else {
                snakeBody = new SnakePiece(snake.get(snake.size() - 1).getTopLX(),
                    snake.get(snake.size() - 1).getTopLY() + snakeHead.getBlockSize(), imageManager);
            }
        } else if (direction == "down") {
            if (snake.size() == 0) {
                snakeBody = new SnakePiece(getSnakeHeadX(), getSnakeHeadY() - snakeHead.getBlockSize(), imageManager);
            } else {
                snakeBody = new SnakePiece(snake.get(snake.size() - 1).getTopLX(),
                    snake.get(snake.size() - 1).getTopLY() - snakeHead.getBlockSize(), imageManager);
            }
        } else if (direction == "left") {
            if (snake.size() == 0) {
                snakeBody = new SnakePiece(getSnakeHeadX() + snakeHead.getBlockSize(), getSnakeHeadY(), imageManager);
            } else {
                snakeBody = new SnakePiece(snake.get(snake.size() - 1).getTopLX() + snakeHead.getBlockSize(),
                    snake.get(snake.size() - 1).getTopLY(), imageManager);
            }
        } else {// direction == "right"
            if (snake.size() == 0) {
                snakeBody = new SnakePiece(getSnakeHeadX() - snakeHead.getBlockSize(), getSnakeHeadY(), imageManager);
            } else {
                snakeBody = new SnakePiece(snake.get(snake.size() - 1).getTopLX() - snakeHead.getBlockSize(),
                    snake.get(snake.size() - 1).getTopLY(), imageManager);
            }
        }

        snake.add(snakeBody);
        snakeDirection.put(snakeBody, direction);
        canvas.add(snakeBody.getShape());

    }
    public void stop() {
        move = false;
    }

    public ArrayList<SnakePiece> getSnake() {
        return snake;
    }

    public SnakeHead getSnakeHead() {
        return snakeHead;
    }

    public String getSnakeBodyDirection(SnakePiece snake) {
        return snakeDirection.get(snake);
    }
}