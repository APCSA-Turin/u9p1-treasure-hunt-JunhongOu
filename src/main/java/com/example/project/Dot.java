package com.example.project;

//Dot only needs a constructor
public class Dot extends Sprite{
    private String dot;
    
    public Dot(int x, int y){ //initalizing the Dot constructor
       super(x, y);
       dot = "☐";
    }

    @Override
    public String getEmoji(){
        return dot;
    }

}
