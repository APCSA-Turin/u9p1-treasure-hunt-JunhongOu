package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;


    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
       super(x, y);
       treasureCount = 0;
       numLives = 2;
    }



    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}
    @Override
    public String getRowCol(int size){ 
    return "Player:" + super.getRowCol(size);
    }
    @Override
    public String getCoords(){ 
        return "Player:" + super.getCoords();
    }


  
    //move method should override parent class, sprite
    
    @Override
    public void move(String direction) { //move the (x,y) coordinates of the player
        if (direction.equals("w")){ //Shifts the y coordinate by one upwards
            setY(getY() + 1);
        }
        if (direction.equals("a")){ //Shifts the x coordinate by one to the left
            setX(getX() - 1);
        }
        if (direction.equals("s")){ //Shifts the y coordinate by one downwards
            setY(getY() - 1);
        }
        if (direction.equals("d")){ //Shifts the x coordinate by one to the right
            setX(getX() + 1);
        }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    /*if (isValid(size, direction)){ //If the player's direction can be done on a grid with a specific size, player moves in that direction
            move(direction);
    } */
    
    if (obj instanceof Enemy){ //If the object is enemy, lives deducted and check if lives = 0
            numLives--;
            if (numLives == 0){
                win = false;
        }
    }
        
    else if (obj instanceof Treasure && !(obj instanceof Trophy)){ //If the object is treasure, treasureCount increases per encounter
            treasureCount++;
    }
        
    else if (obj instanceof Trophy){ //If the object is trophy, checks to see if the required amounts of treasures were obtained as well
            if (treasureCount == numTreasures && obj instanceof Trophy){
            win = true;
        }
    }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        if (direction.equals("w") && getY() + 1 >= size){
            return false;
        }
        if (direction.equals("a") && getX() - 1 < 0){
            return false;
        }
        if (direction.equals("s") && getY() - 1 < 0){
            return false;
        }
        if (direction.equals("d") && getX() + 1 >= size){
            return false;
        }
        else{
            return true;
        }
    }
}



