package com.example.project;

//Enemy only need constructor and getCoords() getRowCol()
public class Enemy extends Sprite  { //child  of Sprite
    private String enemy;
    
    public Enemy(int x, int y) { //initalizing the enemy constructor
        super(x, y);
        enemy = "🦹";
    }
    
    @Override
    public String getEmoji(){
        return enemy;
    }


    //the methods below should override the super class 

    @Override
    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Enemy:" + super.getCoords();
    }

    @Override
    public String getRowCol(int size){ //return "Enemy:"+row col
    return "Enemy:" + super.getRowCol(size);
    }
}