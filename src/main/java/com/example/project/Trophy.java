package com.example.project;

//only needs a constructor
public class Trophy extends Treasure { //child of treasure
    private String trophy;
    
    public Trophy(int x, int y){ //initializing the trophy constructor
        super(x, y);
        trophy = "🏆";
    }

    @Override
    public String getEmoji(){
        return trophy;
    }
}
