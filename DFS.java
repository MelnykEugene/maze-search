// Algorithm from wikipedia
// Code by us

import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;

public class DFS extends SearchAlgorithm implements AbleToSearch{
    Stack<Cell> stack = new Stack<Cell>();
    public DFS(Maze maze, Visualization pviz){
        super(maze,pviz);
        this.viz = pviz;
    }
    public void Search(Cell start,int wait){
        runWorld(viz);
        solutionLength=1;
        stack.push(start);
        while (!stack.empty()){
            solutionLength+=1;
            Cell current = stack.peek();
            current.type=7;

            current.current=true; //used for visualization only

            //if solution reached - draw the math and be done
            if (current.coords.x==maze.finish.x && current.coords.y==maze.finish.y) {
                drawSolution();
                return;
            }

            current.discovered=true;

            //looks at all for sides and selects suitable neighbours (not-discovered, not-walls, not-outside of bouds) and adds them to collection
            ArrayList<Cell> UnvisitedNeighbours=new ArrayList<>();
            if(current.coords.y>0 && maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)).type!=1 && !maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x,current.coords.y-1));
                UnvisitedNeighbours.add(cell);
            }
            if(current.coords.x>0 && maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)).type!=1 && !maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x-1,current.coords.y));
                UnvisitedNeighbours.add(cell);
            }
            if(current.coords.y<maze.getHeight()-1 && maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)).type!=1 && !maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x,current.coords.y+1));
                UnvisitedNeighbours.add(cell);
            }
            if(current.coords.x<maze.getWidth()-1 && maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)).type!=1 && !maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x+1,current.coords.y));
                UnvisitedNeighbours.add(cell);
            }

            //if not a single neighbour is found - deem the cell as closed
            if (UnvisitedNeighbours.size()==0){
                stack.pop();
                current.type=8;
            }
            //if neighbours are found - select one of them and follow it (by adding to the stack of open cells)
            else{
                for(Cell neighbour:UnvisitedNeighbours){
                    neighbour.type=6;
                }
                Random rand = new Random();

                stack.push(UnvisitedNeighbours.get(rand.nextInt(UnvisitedNeighbours.size())));
            }
            runWorld(viz);

            try{
                Thread.sleep(wait,1);
            }
            catch(InterruptedException e){}

            current.current=false;
        }

    }
    public void drawSolution(){
        //at this point stack contains the solution
        for (Cell cell : stack){
            cell.type=2;
        }
        runWorld(viz);
        System.out.println(solutionLength);

    }
    public void runWorld(Visualization viz){
        viz.displayMaze(maze);
    }
}
