import java.util.ArrayList;
import java.util.List;

public class DFS extends SearchLab implements Searchable{
    /*
    Constructor
     */
    public DFS(Maze a){
        super(a);
    }
    public void Searchable(){
        int a;
        if(maze.startingX == maze.endX && maze.startingY == maze.endY) {
            maze.imaze[maze.startingX][maze.startingY]==3;
            runWorld();
        }
        else {
            for (int k = -1; k < 2; k++) {
                for (int l = -1; l < 2; l++) {
                    if (k == 0 && l == 0)
                        continue;
                    if (maze.imaze[maze.startingX + k][maze.startingY + l] == 0) {
                        a = Searchable(maze.startingX + k, maze.startingY + l);
                        if (a != 0) {
                            maze.imaze[maze.startingX][maze.startingY]==3;
                            runWorld();
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
    public int Searchable(int startingX, int startingY){
    int a = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k == 0 && l == 0)
                    continue;
                if(startingX == maze.endX && startingY == maze.endY) {
                    maze.imaze[maze.startingX][maze.startingY]==3;
                    runWorld();
                    a = 1;
                    break;
                }
                if (maze.imaze[startingX + k][startingY + l] == 0) {
                    a = Searchable(maze.startingX + k, maze.startingY + l);
                    if (a != 0) {
                        maze.imaze[maze.startingX][maze.startingY]==3;
                        runWorld();
                        a++;
                        break;
                    }
                }
            }
            if (a != 0) {
                break;
            }
        }
    }
    /*
        Changes the appearance of the maze according to the search status
     */
    public void runWorld(){
        viz.display(maze.imaze);
    }
}
