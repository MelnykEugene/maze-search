// Algorithm from wikipedia
// Code by us

import java.util.Stack;

public class DFS extends SearchAlgorithm implements AbleToSearch{
    Stack<Cell> stack = new Stack<Cell>();
    public DFS(Maze maze, Visualization pviz){
        super(maze);
        this.viz = pviz;
    }
    public void Search(Cell start){
        runWorld(viz);
        solutionLength=1;
        stack.push(start);
        while (!stack.empty()){
            //set pause for visualization


            solutionLength+=1;
            Cell current = stack.pop();

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
