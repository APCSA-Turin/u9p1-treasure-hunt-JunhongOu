package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
          this.size = size;
          initialize(); //Creates the foundation of the game
          play(); //Begins the game

    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here, and to start the game
        Scanner scanner = new Scanner(System.in);

            grid.display(); //displays the game
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("What direction do you want to take?"); //Tells the player to input a direction key
            System.out.println("Amount of lives:  " + player.getLives()); //Prints out the player's lives
            System.out.println("Treasures: " + player.getTreasureCount()); //Prints out the player's treasure count 
            System.out.println("Current position of " + player.getCoords()); //Prints out the player's coordinates
            String key = scanner1.nextLine(); //The user inputs "WASD" for player movement


            Object direction = new Object();
            if (player.isValid(size, key)){ //If the player is within the boundary and can move in a certain direction
                switch(key){
                    
                    case "w" : direction = grid.getGrid()[(size - 1) - player.getY() - 1][player.getX()]; //shifts player up by 1
                    break;
                    
                    case "a" : direction = grid.getGrid()[(size - 1) - player.getY()][player.getX() - 1]; //shifts player left by 1
                    break;
                    
                    case "s" : direction = grid.getGrid()[(size - 1) - player.getY() + 1][player.getX()]; //shifts player down by 1
                    break;
                    
                    case "d" : direction = grid.getGrid()[(size - 1) - player.getY()][player.getX() + 1]; //shifts player right by 1
                    break;
                }
            }
            
            player.interact(grid.getGrid().length, key, treasures.length, direction); //For the game to function properly with each object interactions
            grid.placeSprite(player, key); //places sprite on the grid in respective to the direction

            

            if (player.getWin()){ //Win message after winning
                grid.win();
            }
            else{
                grid.gameover(); //Gameover message after losing
            }
          }
      
        public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        grid = new Grid(size); 
        player = new Player(0, 0);
        trophy = new Trophy (6, 6);
        Treasure treasure1 = new Treasure(8, 5);
        Treasure treasure2 = new Treasure(6, 7);
        Enemy enemy1 = new Enemy(4, 3);
        Enemy enemy2 = new Enemy(7, 8);
        enemies = new Enemy[2]; //Creates an enemy list
        enemies[0] = enemy1;
        enemies[1] = enemy2;
        treasures = new Treasure[2]; //Creates a treasures list
        treasures[0] = treasure1;
        treasures[1] = treasure2;
        grid.placeSprite(player);
        grid.placeSprite(trophy);

        for (Treasure t : treasures){ //Places each treasure on the grid
            grid.placeSprite(t);
        }
        
        for (Enemy e : enemies){ //Places each enemy on the grid
            grid.placeSprite(e);
        }
    }


    public static void main(String[] args) {
        Game game = new Game(10);
        
    }
}