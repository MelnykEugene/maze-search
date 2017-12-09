import java.Random;
public class Maze
{   /*
    imaze is a integer matrix with values meaning the following:
    0-empty
    1-wall

    8-end
    9-start
    */
    private int[][] imaze;
    private Coordinates start;
    private Coordinates finish;

    public Maze()
    {
        File given = new File("mazeherefillinlater");
        Scanner detspec = new Scanner(given);
        int width = 0;
        int height = 0;
        while (dataspec.hasNextLine())
        {
            String line = dataspec.nextLine();
            width = line.length();
            height++;
        }
        Scanner mazescan = new Scanner(given);
        int[][] maze= new int[width][height];
        int currentLoc = 0;
        while (mazescan.hasNextLine())
        {
            String currentRow = mazescan.nextLine();
            for(int i = 0; i < maze.length; i++)
            {
                char part = currentRow.charAt(i);
                maze[currentLoc][i] = Character.getNumericValue(part);
            }
            currentLoc++;
        }
        imaze = maze;
    }


    public Maze(width,height,xstart,ystart,xfinish,yfinish){
        maze=new Cell[width,height];
        for (int x =0; x< width; x++){
            for (int y =0; y< height; y++){
                maze[x,y]==new Cell(0,new Coordinates(x,y));
            }
        }
    }
    public Maze(width,height){
        Maze(width,height,0,0,width-1,height-1);
    }

    public generateRandom(){
        rand=new Random();
        for (int x =0; x< width; x++){
            for (int y =0; y< height; y++){
                wallOrNotWall=rand.nextInt();
                maze[x,y]==new Cell(0,new Coordinates(x,y));
            }
        }
    }

    public int[][] getMaze()
    {
        return imaze;
    }
}
