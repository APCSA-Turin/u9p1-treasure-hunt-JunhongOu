package com.example.project;

public class Sprite {
    private int x, y;
    private String emoji;
    
    public Sprite(int x, int y) { //initializes the Sprite constructor
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;} //returns the x-coord
    public int getY(){return y;} //returns the y-coord

    public void setX(int newX){ //sets x to the new X-coord
       x = newX;
    }
    public void setY(int newY){ //sets y to the new Y-coord
        y = newY;
    }

    public String getEmoji(){ //returns emoji
        return emoji;
    }

    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "(" + getX() + "," + getY() + ")";
    }

    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        return "[" + (size - y - 1) + "]" + "[" + x + "]";
    }

    public int getRow(int size){ //The y is used here so that the sprite placement becomes accurate
        //returns the row that the sprite is in
        return size - y - 1;
    }
    public int getCol(int size){ //returns the column that the sprite is in
        return x;
    }
    

    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }



}
