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
            //draw w
            runWorld(viz);

            //set pause for visualization
            try{
                Thread.sleep(1,1);
            }
            catch(InterruptedException e){}
            solutionLength+=1;
            Cell current = stack.pop();
            if (current.discovered) continue;
            current.discovered=true;
            solutionLength+=1;
            if (current.coords.x==maze.finish.x && current.coords.y==maze.finish.y) {
                drawSolution();
                return;
            }
            if(current.coords.y>0 && maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)).type!=1 && !maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x,current.coords.y-1));
                stack.push(cell);
                continue;
            }
            if(current.coords.x>0 && maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)).type!=1 && !maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x-1,current.coords.y));
                stack.push(cell);
                continue;
            }
            if(current.coords.x<maze.getWidth()-1 && maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)).type!=1 && !maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x+1,current.coords.y));
                stack.push(cell);
                continue;
            }
            if(current.coords.y<maze.getHeight()-1 && maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)).type!=1 && !maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)).discovered){
                Cell cell = maze.getCell(new Coordinates(current.coords.x,current.coords.y+1));
                stack.push(cell);
                continue;
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

interface AbleToSearch {
    public void Search(Cell start);
}

/*

public class DFS extends SearchAlgorithm implements AbleToSearch{
    public DFS(Maze maze, Visualization pviz){
        super(maze);
        this.viz = pviz;
    }
    public void Search(){
        int a=0;
        if(maze.start.x == maze.finish.x && maze.start.y == maze.finish.y) {
            maze.imaze[maze.start.x][maze.start.y].type=3;
            runWorld(viz);
            System.out.println("trying");

        }
        else {
            maze.imaze[maze.start.x][maze.start.y].type=1;
            for (int k = -1; k < 2; k++) {
                for (int l = -1; l < 2; l++) {
                    System.out.println("trying");
                    if (k == 0 && l == 0)
                        continue;
                    if (maze.imaze[maze.start.x + k][maze.start.y + l].type == 0) {
                        a = Search(maze.start.x + k, maze.start.y + l);
                        if (a != 0) {
                            maze.imaze[maze.start.x][maze.start.y].type=3;
                            runWorld(viz);
                            break;
                        }
                    }
                }
                if (a != 0) {
                    break;
                }
            }
            super.solutionLength = a;
        }
    }
    public int Search(int startx, int starty){
    int a = 0;
    maze.imaze[maze.start.x][maze.start.y].type=1;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k == 0 && l == 0)
                    continue;
                if(startx == maze.finish.x && starty == maze.finish.y) {
                    maze.imaze[maze.start.x][maze.start.y].type=3;
                    runWorld(viz);
                    a = 1;
                    break;
                }
                if (maze.imaze[startx + k][starty + l].type == 0) {
                    a = Search(maze.start.x + k, maze.start.y + l);
                    if (a != 0) {
                        maze.imaze[maze.start.x][maze.start.y].type=3;
                        runWorld(viz);
                        a++;
                        break;
                    }
                }
            }
            if (a != 0) {
                break;
            }
        }
        return a;
    }

    public void runWorld(Visualization viz){
        viz.displayMaze(maze);
    }
}

 interface AbleToSearch{
    public void Search();
}

*/