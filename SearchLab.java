import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchLab{
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
    public long timeRequired;
    /*
        Constructor: Setting up everything.
     */

    public SearchLab(Maze a){
        maze = a;
        solutionLength = Integer.MAX_VALUE;
        timeRequired = System.currentTimeMillis();
    }
    /*
        Get the current solutionlength;
     */
    public int getSolutionLength() {
        return solutionLength;
    }
}
