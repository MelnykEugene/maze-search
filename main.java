import java.io.FileNotFoundException;

public class main{
    public static void main(String[] argv) throws FileNotFoundException {
        Maze maze = new Maze(200,100);
        maze.generateRandom();
        Visualization viz = new Visualization(maze);
        DFS solver = new DFS(maze,viz);
        solver.Search(maze.getCell(maze.start));
    }
}