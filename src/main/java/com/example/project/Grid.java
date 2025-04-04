package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                grid[i][j] = new Dot(i, j);
            }
        }
    }

 
    public Sprite[][] getGrid(){ //returns grid
        return grid;
    }



    public void placeSprite(Sprite s){ //Places sprite in the specified coordinate of the grid
        grid[size - s.getY() - 1][s.getX()] = s;
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
    grid[size-1-s.getY()][s.getX()] = s;
     int x = s.getX();
    int y = s.getY();
    if (direction.equals("w")){ //Places sprite one grid up
        y--;
    }
    if (direction.equals("a")){ //Places sprite one grid to the left
        x++;
    }
    if (direction.equals("s")){ //Places sprite one grid down
        y++;
    }
    if (direction.equals("d")){ //Places sprite one grid to the right
       x--;
    }
           
    if(x >= 0 && x < size && y >= 0 && y < size) {
        grid[size-1-y][x] = new Dot(x, y);
    }

       /* if (direction.equals("w")){ //Places sprite one grid up
            grid[s.getRow(size) + 1][s.getCol(size)] = s;
        }
        if (direction.equals("a")){ //Places sprite one grid to the left
            grid[s.getRow(size)][s.getCol(size) - 1] = s;
        }
        if (direction.equals("s")){ //Places sprite one grid down
            grid[s.getRow(size) - 1][s.getCol(size)] = s;
        }
        if (direction.equals("d")){ //Places sprite one grid to the right
            grid[s.getRow(size)][s.getCol(size) + 1] = s;
        } */
    }


    public void display() { //print out the current grid to the screen 
         for(Sprite[] row : grid) {
            for(Sprite cell : row) {
                if(cell instanceof Player) {
                    System.out.print("😊");
                } else if(cell instanceof Enemy) {
                    System.out.print("🔥");
} else if(cell instanceof Trophy) {
                    System.out.print("🏆");
                } else if(cell instanceof Treasure) {
                    System.out.print("💎");
                } else {
                    System.out.print("⬜");
                }
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
        System.out.println("██    ██  ██████  ██    ██      ██       ██████  ███████ ████████ ");
        System.out.println( "██ ██  ██    ██ ██    ██     ██      ██    ██ ██         ██    ");
        System.out.println(" ████   ██    ██ ██    ██     ██      ██    ██ ███████    ██ ");  
        System.out.println( " ██    ██    ██ ██    ██     ██      ██    ██      ██    ██ ");   
        System.out.println(" ██     ██████   ██████      ███████  ██████  ███████    ██ ");  
        System.out.println( "                                                           ");
                                                                
    }

    public void win(){ //use this method to display a win 
    System.out.println("██╗   ██╗ ██████╗ ██╗   ██╗  ██╗    ██╗   ██╗  ██╗    ██╗██╗");
    System.out.println("╚██╗ ██╔╝██╔═══██╗██║   ██║  ██║    ██║  ██║  ██╗    ██║ ██║");
    System.out.println("╚████╔╝ ██║   ██║██║   ██║   ██║██╗ ██║  ██║ ██╔██╗ ██║  ██║");
    System.out.println("╚██╔╝  ██║   ██║██║   ██║   ██║ ██╗██║  ██║  ██║╚██╗██║  ╚═╝");
    System.out.println(" ██║   ╚██████╔╝╚██████╔╝    ███╔███╔╝  ██║ ██║ ╚████║   ██╗");
    System.out.println(" ╚═╝    ╚═════╝  ╚═════╝     ╚══╝╚══╝   ╚═╝╚═╝   ╚═══╝   ╚═╝");      
                                
    }


}