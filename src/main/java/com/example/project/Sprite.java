package com.example.project;

public class Sprite {
    private int x, y;
    private String emoji;
    
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}//placeholder
    public int getY(){return y;}

    public void setX(int newX){
       x = newX;
    }
    public void setY(int newY){
        y = newY;
    }

    public String getEmoji(){
        return emoji;
    }

    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "(" + getX() + "," + getY() + ")";
    }

    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        return "[" + (size - y - 1) + "]" + "[" + x + "]";
    }

    public int getRow(int size){ //The y is used here so that the sprite placement becomes accurate
        return size - y - 1;
    }
    public int getCol(int size){
        return x;
    }
    

    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }



}
