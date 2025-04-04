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
          initialize();
          play();   
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

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Treasure Hunt, what's your name? (Write name to continue dialogue)");
        String name = scanner.nextLine();
        System.out.println("Alright " + name + ", My name is Captain Mario and I will be your guide.");
        System.out.println("Before you get hyped, here are a few reminders that I need to mention.");
        System.out.println( "First, watch out for your lives. You only start out with two.");
        System.out.println("Second, there are many enemies during the treasure hunt, interacting with any enemies will deduct one life.");
        System.out.println("Third, your goal in this goal is to obtain all treasures and the trophy once you're done with treasures.");
        System.out.println("Fourth, you can not go beyond the border boundaries, don't even try.");
        System.out.println("Fifth, WASD for movement. I know, that's very groundbreaking ._.");
        System.out.println("Enough yapping from me. To start the game, type in \"Yes\" if you are prepared, \"No\" if not.");
        String response = scanner.nextLine();
        if (response.equals("Yes")){
           
        }
        else if (response.equals("No")){
            System.out.print("Alright, don't waste my time next time.");
        }
        
        while(true){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop

     
            }
            
     
    }

    public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        player = new Player(size, size); 
        //treasures = new Treasure(, );
        
       
        
   
    }

    public static void main(String[] args) {
        
    }
}