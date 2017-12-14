import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

public class mainApp extends JFrame {
    public JPanel mainPanel;
    private JLabel logDataLabel;
    private JPanel userInputPanel;
    private JPanel algoSelectionPanel;
    private JPanel mazeSelectionPanel;
    private JPanel visualization;
    private JTextField textField1;
    private JTextField textField2;
    private JButton generateFromFileButton;
    private JButton generateFromSelectionButton;
    private JList list1;
    private JButton runMazeButton;

    public static void main(String[] argv) throws FileNotFoundException {
        System.out.println("USAGE:");
        System.out.println("Name of file | Type of solver | Delay time between frames in ms(Not necessary)");
        //System.out.println("Example => spanishinquisition.txt BFS 3");
        System.out.println("random | Width | Height | Type of solver | Delay time between in ms(Not necessary)");
        //System.out.println("Example => random 20 30 DFS");
        System.out.println("recursive | Width | Height | Type of solver | Delay time between frames in ms(Not necessary)");
        //System.out.println("Example => recursive 30 40 Dijkstra 8");

        if (argv[0] == "random") {
            Maze maze = new Maze(Integer.parseInt(argv[1]),Integer.parseInt(argv[2]));
            Visualization viz =new Visualization(maze);
            if()
        }
    }
}
    /*public static void ProgramStarter(Maze maze, SearchAlgorithm solver, int viewtime) {
        solver.Search(maze.getCell(maze.start), viewtime);
        System.out.println("FUCK YOU?");
    }
    public static void ProgramStarter(Maze maze, SearchAlgorithm solver) {
        solver.Search(maze.getCell(maze.start), 20);
    }


    public static void usage() {
        System.out.println("USAGE:");
        System.out.println("Name of file | Type of solver | Delay time between frames in ms(Not necessary)");
        //System.out.println("Example => spanishinquisition.txt BFS 3");
        System.out.println("random | Width | Height | Type of solver | Delay time between in ms(Not necessary)");
        //System.out.println("Example => random 20 30 DFS");
        System.out.println("recursive | Width | Height | Type of solver | Delay time between frames in ms(Not necessary)");
        //System.out.println("Example => recursive 30 40 Dijkstra 8");
    }

    public static void main(String[] argv) throws FileNotFoundException {
        try {
            if (argv[0] == "random") {
                Maze maze = new Maze(Integer.parseInt(argv[1]), Integer.parseInt(argv[2]));
                maze.generateRandom();
                Visualization viz = new Visualization(maze);
                SearchAlgorithm alg = new SearchAlgorithm(maze, viz);
                if (argv.length == 5) {
                    if (argv[3] == "BFS")
                        alg = new BFS(maze, viz);
                    else if (argv[3] == "DFS")
                        alg = new DFS(maze, viz);
                    else if (argv[3] == "Dijkstra")
                        alg = new DJKS(maze, viz);
                    ProgramStarter(maze, alg, Integer.parseInt(argv[4]));
                } else {
                    maze.generateRandom();
                    if (argv[3] == "BFS")
                        alg = new BFS(maze, viz);
                    else if (argv[3] == "DFS")
                        alg = new DFS(maze, viz);
                    else if (argv[3] == "Dijkstra")
                        alg = new DJKS(maze, viz);
                    ProgramStarter(maze, alg, 20);
                }
            } else if (argv[0] == "recursive") {
                Maze maze = new Maze(Integer.parseInt(argv[1]), Integer.parseInt(argv[2]));
                Visualization viz = new Visualization(maze);
                maze.generateRecursiveBacktracker(viz, Integer.parseInt(argv[4]));
                SearchAlgorithm alg = new SearchAlgorithm(maze, viz);
                if (argv.length == 5) {
                    if (argv[3] == "BFS")
                        alg = new BFS(maze, viz);
                    else if (argv[3] == "DFS")
                        alg = new DFS(maze, viz);
                    else if (argv[3] == "Dijkstra")
                        alg = new DJKS(maze, viz);
                    ProgramStarter(maze, alg, Integer.parseInt(argv[4]));
                } else {
                    maze.generateRecursiveBacktracker(viz, 2);
                    if (argv[3] == "BFS")
                        alg = new BFS(maze, viz);
                    else if (argv[3] == "DFS")
                        alg = new DFS(maze, viz);
                    else if (argv[3] == "Dijkstra")
                        alg = new DJKS(maze, viz);
                    ProgramStarter(maze, alg, 2);
                }
            } else {
                Maze maze = new Maze(argv[0]);
                if (argv.length == 3) {
                    if (argv[1] == "BFS") {
                        Visualization viz = new Visualization(maze);
                        BFS alg = new BFS(maze, viz);
                        ProgramStarter(maze, alg, Integer.parseInt(argv[2]));
                    }
                    else if (argv[1] == "DFS") {
                        Visualization viz = new Visualization(maze);
                        DFS alg = new DFS(maze, viz);
                        ProgramStarter(maze, alg, Integer.parseInt(argv[2]));
                    }
                    else if (argv[1] == "Dijkstra") {
                        Visualization viz = new Visualization(maze);
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg, Integer.parseInt(argv[2]));
                    }
                } else if(argv.length==2) {
                    if (argv[1] == "BFS") {
                        Visualization viz = new Visualization(maze);
                        BFS alg = new BFS(maze, viz);
                        ProgramStarter(maze, alg);
                    }
                    else if (argv[1] == "DFS")
                    {
                        Visualization viz = new Visualization(maze);
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg);
                    }
                    else if (argv[1] == "Dijkstra")
                    {
                        Visualization viz = new Visualization(maze);
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg);
                    }
                }
                else throw new RuntimeException("wrong input");
            }
        } catch (Exception e) {
            usage();
        }
    }
}*/

/*

public class mainApp extends JFrame{
    public JPanel mainPanel;
    private JLabel logDataLabel;
    private JPanel userInputPanel;
    private JPanel algoSelectionPanel;
    private JPanel mazeSelectionPanel;
    private JPanel visualization;
    private JTextField textField1;
    private JTextField textField2;
    private JButton generateFromFileButton;
    private JButton generateFromSelectionButton;
    private JList list1;
    private JButton runMazeButton;


    public static void main(String[] argv) throws FileNotFoundException {
        Maze maze = new Maze("maze.txt");
        Visualization viz = new Visualization(maze);
        maze.generateRandom();
        DJKS solver = new DJKS(maze,viz);
        solver.Search(maze.getCell(maze.start),1);
    }
}
*/
