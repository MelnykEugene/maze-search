import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;

public class Maze
{
    public Cell[][] imaze;
    public Coordinates start;
    public Coordinates finish;

    //maze knows its width and height so they can be easily retrived later
    private int width;
    private int height;

    //file-based constructor
    public Maze(String filename) throws FileNotFoundException {
        File given = new File(filename);
        Scanner dataspec = new Scanner(given);
        int widthl = 0;
        int heightl = 0;
        while (dataspec.hasNextLine())
        {
            String line = dataspec.nextLine();
            widthl = line.length();
            heightl++;
        }
        Scanner mazescan = new Scanner(given);
        Cell[][] maze= new Cell[widthl][heightl];
        int currentLoc = 0;
        while (mazescan.hasNextLine())
        {
            String currentRow = mazescan.nextLine();
            for(int i = 0; i < maze.length; i++)
            {
                char part = currentRow.charAt(i);
                maze[i][currentLoc] = new Cell(Character.getNumericValue(part),new Coordinates(i,currentLoc));
            }
            currentLoc++;
        }


        //sets the local variables
        imaze = maze;
        width = widthl;
        height = heightl;
        start=new Coordinates(0,0);
        finish=new Coordinates(width-1,height-1);
        imaze[start.x][start.y] = new Cell(4,new Coordinates(start.x,start.y));
        imaze[finish.x][finish.y] = new Cell(5,new Coordinates(finish.x,finish.y));
    }

    //constucts a maze full of "empty cells"
    public Maze(int pwidth,int pheight,int xstart,int ystart, int xfinish, int yfinish){
        imaze=new Cell[pwidth][pheight];
        for (int x =0; x< pwidth; x++){
            for (int y =0; y< pheight; y++){
                imaze[x][y]=new Cell(1,new Coordinates(x,y));
            }
        }
        start=new Coordinates(xstart,ystart);
        finish=new Coordinates(xfinish,yfinish);
        this.height=pheight;
        this.width=pwidth;
    }
    //constructor for when the initial and final points are not provided
    public Maze(int pwidth,int pheight){
        this(pwidth,pheight,0,0,pwidth-1,pheight-1);
    }

    //generates the maze by randomly putting walls
    public void generateRandom(){
        Random rand=new Random();
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                int wallOrNotWall=rand.nextInt(101)>5 ? 0 : 1;
                imaze[x][y]=new Cell(wallOrNotWall,new Coordinates(x,y));
            }
        }
        imaze[start.x][start.y] = new Cell(4,new Coordinates(start.x,start.y));
        imaze[finish.x][finish.y] = new Cell(5,new Coordinates(finish.x,finish.y));
    }

    //generates the maze using algorithms similar to recursive backtracker
    public void generateRecursiveBacktracker(Visualization viz,int wait){
        Stack<Cell> stack = new Stack<Cell>();

        this.start=new Coordinates(1,1);
        this.finish=new Coordinates(this.getWidth()-2,this.getHeight()-2);

        this.getCell(this.start).type=4;
        this.getCell(this.finish).type=5;

        Cell current = this.getCell(this.start);
        current.visited=true;
        
        //current is not a wall
        current.type=0;

        while(hasUnvisited()){
            current.current=true;
            viz.displayMaze(this);
            try{
                Thread.sleep(wait,0);
            }
            catch(InterruptedException e){}
            current.current=false;

            ArrayList<Cell> potentialNeighbours=new ArrayList<>();
            ArrayList<Cell> potentialFarNeighbours=new ArrayList<>();

            //consider the two far (with a gap of one cell) neighbours from current
            //potentially destroying a wall between current and far neighbour
            if(current.coords.y>1 && !this.getCell(new Coordinates(current.coords.x,current.coords.y-2)).visited){
                Cell cell = this.getCell(new Coordinates(current.coords.x,current.coords.y-1));
                potentialNeighbours.add(cell);
                cell = this.getCell(new Coordinates(current.coords.x,current.coords.y-2));
                potentialFarNeighbours.add(cell);
            }
            if(current.coords.x>1  && !this.getCell(new Coordinates(current.coords.x-2,current.coords.y)).visited){
                Cell cell = this.getCell(new Coordinates(current.coords.x-1,current.coords.y));
                potentialNeighbours.add(cell);
                cell = this.getCell(new Coordinates(current.coords.x-2,current.coords.y));
                potentialFarNeighbours.add(cell);
            }
            if(current.coords.y<this.getHeight()-2 && !this.getCell(new Coordinates(current.coords.x,current.coords.y+2)).visited){
                Cell cell = this.getCell(new Coordinates(current.coords.x,current.coords.y+1));
                potentialNeighbours.add(cell);
                cell = this.getCell(new Coordinates(current.coords.x,current.coords.y+2));
                potentialFarNeighbours.add(cell);
            }
            if(current.coords.x<this.getWidth()-2 && !this.getCell(new Coordinates(current.coords.x+2,current.coords.y)).visited){
                Cell cell = this.getCell(new Coordinates(current.coords.x+1,current.coords.y));
                potentialNeighbours.add(cell);
                cell = this.getCell(new Coordinates(current.coords.x+2,current.coords.y));
                potentialFarNeighbours.add(cell);
            }

            //if there are potential neighbours - pick one at random and move to that cell as current while removing walls
            if (!(potentialNeighbours.size()==0)){
                Random rand=new Random();
                int index = rand.nextInt(potentialNeighbours.size());
                potentialNeighbours.get(index).type=0;
                potentialNeighbours.get(index).visited=true;
                potentialFarNeighbours.get(index).visited=true;
                potentialFarNeighbours.get(index).type=0;
                current = potentialFarNeighbours.get(index);
                stack.push(current);
            }
            else if(!stack.empty()){
                current=stack.pop(); }
            else {
                return;
            }
        }
    }

    //helper method for recursive generator
    private boolean hasUnvisited(){
        for (int x =0; x<width;x++){
            for(int y =0; y<height;y++){
                if (!(this.getCell(new Coordinates(x,y)).visited)) return true;
            }
        }
        return false;
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
