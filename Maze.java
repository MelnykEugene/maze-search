import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Maze
{   /*
    imaze is a integer matrix with values meaning the following:
    0-empty
    1-wall

    8-end
    9-start
    */
    public Cell[][] imaze;
    public Coordinates start;
    public Coordinates finish;
    private int width;
    private int height;

    public Maze(String filename) throws FileNotFoundException {
        File given = new File(filename);
        Scanner dataspec = new Scanner(given);
        int width = 0;
        int height = 0;
        while (dataspec.hasNextLine())
        {
            String line = dataspec.nextLine();
            width = line.length();
            height++;
        }
        Scanner mazescan = new Scanner(given);
        Cell[][] maze= new Cell[width][height];
        int currentLoc = 0;
        while (mazescan.hasNextLine())
        {
            String currentRow = mazescan.nextLine();
            for(int i = 0; i < maze.length; i++)
            {
                char part = currentRow.charAt(i);
                maze[currentLoc][i] = new Cell(Character.getNumericValue(part),new Coordinates(currentLoc,i));
            }
            currentLoc++;
        }
        imaze = maze;
    }


    public Maze(int pwidth,int pheight,int xstart,int ystart, int xfinish, int yfinish){
        imaze=new Cell[pwidth][pheight];
        for (int x =0; x< width; x++){
            for (int y =0; y< height; y++){
                imaze[x][y]=new Cell(0,new Coordinates(x,y));
            }
        }
        start=new Coordinates(xstart,ystart);
        finish=new Coordinates(xfinish,yfinish);
        this.height=pheight;
        this.width=pwidth;
    }

    public Maze(int pwidth,int pheight){
        this(pwidth,pheight,0,0,pwidth-1,pheight-1);
    }

    public void generateRandom(){
        Random rand=new Random();
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                int wallOrNotWall=rand.nextInt(101)>40 ? 0 : 1;
                imaze[x][y]=new Cell(wallOrNotWall,new Coordinates(x,y));
            }
        }
        imaze[start.x][start.y] = new Cell(4,new Coordinates(start.x,start.y));
        imaze[finish.x][finish.y] = new Cell(5,new Coordinates(finish.x,finish.y));
    }

    public Cell[][] getMaze()
    {
        return imaze;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Cell getCell(Coordinates coords){
        return imaze[coords.x][coords.y];
    }
}
