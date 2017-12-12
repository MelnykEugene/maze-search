public class DFS extends SearchAlgorithm implements AbleToSearch{
    public DFS(Maze maze, Visualization pviz){
        super(maze);
        this.viz = pviz;
    }
    public void Search(){
        int a=0;
        runWorld(viz);
    }
    public void runWorld(Visualization viz){
        viz.displayMaze(maze);
    }
}

interface AbleToSearch {
    public void Search();
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