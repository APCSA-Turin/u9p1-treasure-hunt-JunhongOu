package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Grid {
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { // initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Dot(i, j); // fills every part of the grid with dots
            }
        }
    }

    public Sprite[][] getGrid() { // returns grid
        return grid;
    }

    public void placeSprite(Sprite s) { // Places sprite in the specified coordinate of the grid
        grid[size - s.getY() - 1][s.getX()] = s;
    }

    public void placeSprite(Sprite s, String direction) { // place sprite in a new spot on the grid based on direction
        grid[size - 1 - s.getY()][s.getX()] = s;

        int xCoord = s.getX(); // getting the x-coord of the sprite
        int yCoord = s.getY(); // getting the y-coord of the sprite

        if (direction.equals("w")) { // Places sprite one grid up
            yCoord--;
        }
        if (direction.equals("a")) { // Places sprite one grid to the left
            xCoord++;
        }
        if (direction.equals("s")) { // Places sprite one grid down
            yCoord++;
        }
        if (direction.equals("d")) { // Places sprite one grid to the right
            xCoord--;
        }

        if (xCoord >= 0 && xCoord < size && yCoord >= 0 && yCoord < size) { // Preventing out of index error
            grid[size - 1 - yCoord][xCoord] = new Dot(xCoord, yCoord); // Fills the previous grid plot with a dot
        }
    }

    public void display() { // print out the current grid to the screen
        for (Sprite[] row : grid) { // Going through every part of the grid
            for (Sprite cell : row) { // prints out each sprite for the Treasure Hunt game
                if (cell instanceof Player) { // if cell is an instance of the Player class
                    System.out.print("😎");
                } 
                else if (cell instanceof Enemy) { // if cell is an instance of the Enemy class
                    System.out.print("👿");
                } 
                else if (cell instanceof Trophy) { // if cell is an instance of the Trophy class
                    System.out.print("🏆");
                } 
                else if (cell instanceof Treasure) { // if cell is an instance of the Treasure class
                    System.out.print("💰");
                } 
                else {
                    System.out.print("⬜"); // prints out a dot when it isn't the above instances
                }
            }
            System.out.println();
        }
    }

    public void gameover() { // use this method to display a loss
        System.out.println("██    ██  ██████  ██    ██      ██       ██████  ███████ ████████ ");
        System.out.println("██ ██  ██    ██ ██    ██     ██      ██    ██ ██         ██    ");
        System.out.println(" ████   ██    ██ ██    ██     ██      ██    ██ ███████    ██ ");
        System.out.println(" ██    ██    ██ ██    ██     ██      ██    ██      ██    ██ ");
        System.out.println(" ██     ██████   ██████      ███████  ██████  ███████    ██ ");
        System.out.println("                                                           ");

    }

    public void win() { // use this method to display a win
        System.out.println("██╗   ██╗ ██████╗ ██╗   ██╗  ██╗    ██╗   ██╗  ██╗    ██╗██╗");
        System.out.println("╚██╗ ██╔╝██╔═══██╗██║   ██║  ██║    ██║  ██║  ██╗    ██║ ██║");
        System.out.println("╚████╔╝ ██║   ██║██║   ██║   ██║██╗ ██║  ██║ ██╔██╗ ██║  ██║");
        System.out.println("╚██╔╝  ██║   ██║██║   ██║   ██║ ██╗██║  ██║  ██║╚██╗██║  ╚═╝");
        System.out.println(" ██║   ╚██████╔╝╚██████╔╝    ███╔███╔╝  ██║ ██║ ╚████║   ██╗");
        System.out.println(" ╚═╝    ╚═════╝  ╚═════╝     ╚══╝╚══╝   ╚═╝╚═╝   ╚═══╝   ╚═╝");

    }

}