// Algorithm from wikipedia
// Code by us
/*
import java.util.LinkedList;
import java.util.ArrayList;

public class BFS extends SearchAlgorithm implements AbleToSearch{
    LinkedList<Cell> open = new LinkedList<Cell>();
    ArrayList<Cell> closed = new ArrayList<Cell>();
    public BFS(Maze maze, Visualization pviz){
        super(maze);
        this.viz = pviz;
    }
    public void Search(Cell start){
        runWorld(viz);
        solutionLength=1;
        open.add(start);
        while (!open.isEmpty()){

            solutionLength+=1;
            Cell current = open.();

            if (current.discovered) continue; //don't do anything on previously visited cells

            current.current=true; //used for visualization only

            runWorld(viz);

            try{
                Thread.sleep(10,1);
            }
            catch(InterruptedException e){}

            current.current=false; //used for visualization only


            current.discovered=true;

            solutionLength+=1;
            if (current.coords.x==maze.finish.x && current.coords.y==maze.finish.y) {
                drawSolution();
                return;
            }
            if(current.coords.y>0 && maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)).type!=1 && !maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x,current.coords.y-1));
                stack.push(cell);
            }
            if(current.coords.x>0 && maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)).type!=1 && !maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x-1,current.coords.y));
                stack.push(cell);
            }
            if(current.coords.y<maze.getHeight()-1 && maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)).type!=1 && !maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x,current.coords.y+1));
                stack.push(cell);
            }
            if(current.coords.x<maze.getWidth()-1 && maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)).type!=1 && !maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x+1,current.coords.y));
                stack.push(cell);
            }
        }

    }
    public void drawSolution(){
        for (Cell cell : stack){
            cell.type=2;
        }
        runWorld(viz);
    }
    public void runWorld(Visualization viz){
        viz.displayMaze(maze);
    }
}
*/