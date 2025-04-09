package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;


    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2, initializes the Player constructor
       super(x, y);
       treasureCount = 0;
       numLives = 2;
       win = false;
    }

    public int getTreasureCount(){return treasureCount;} //returns treasureCount
    public int getLives(){return numLives;} //returns player's lives
    public boolean getWin(){return win;} //returns if the player wins or loses
    
    @Override
    public String getRowCol(int size){ //Returns the plot that the player is on for the grid
    return "Player:" + super.getRowCol(size);
    }
    
    @Override
    public String getCoords(){ //Returns the player's coordinates
        return "Player:" + super.getCoords();
    }

    public boolean winOrLose(){
        return win;
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

    if (obj instanceof Enemy){ //If the object is enemy, lives deducted and check if lives = 0 to end the game with a loss
            numLives--;
            if (numLives == 0){
                win = false;
            }
    }
        
    else if (obj instanceof Treasure && !(obj instanceof Trophy)){ //If the object is treasure, treasureCount increases per encounter
            treasureCount++;
    }
        
   else if (treasureCount == numTreasures && obj instanceof Trophy){ //If the object is trophy, checks to see if the required amounts of treasures were obtained as well 
        //The game ends with a win if all treasures and trophy was obtained
            win = true;
        }
    }



    public boolean isValid(int size, String direction){ //check grid boundaries
        if (direction.equals("w") && getY() + 1 >= size){ //returns false if player can't move up
            return false;
        }
        if (direction.equals("a") && getX() - 1 < 0){ //returns false if player can't move left
            return false;
        }
        if (direction.equals("s") && getY() - 1 < 0){ //returns false if player can't move down
            return false;
        }
        if (direction.equals("d") && getX() + 1 >= size){ //returns false if player can't move right
            return false;
        }
        else{
            return true; //returns true if all of the above statements are invalid
        }
    }

}



