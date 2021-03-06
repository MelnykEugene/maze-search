import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchAlgorithm {
    /*
        Copy of the grid so that the initial maze stays intact and the changes are made to the local copy only
     */
    public Maze maze;
    /*
        Number of iterations required to solve
     */
    public int solutionLength;
    /*
        Stores the time required to solve (determined inside the search methods)
     */
    public long timeStarted;
    /*
        Constructor: Setting up everything.
     */
    Visualization viz;

    public SearchAlgorithm(Maze pmaze, Visualization viz){
        this.maze = pmaze;
        this.viz=viz;
        solutionLength = 0;
        timeStarted = System.currentTimeMillis();
    }
    /*
        Get the current solutionlength;
     */
    public int getSolutionLength() {
        return solutionLength;
    }
    public long getTimeRequired(){ return timeStarted; }
    public void Search(Cell a, int i){}
}

interface AbleToSearch {
    public void Search(Cell start,int wait);
}