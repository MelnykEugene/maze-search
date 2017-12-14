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

    //these two methods actually start the search after maze/vizualization/solver were set
    public static void ProgramStarter(Maze maze, SearchAlgorithm solver, int viewtime) {
        solver.Search(maze.getCell(maze.start),viewtime);
    }
    public static void ProgramStarter(Maze maze, SearchAlgorithm solver) {
        solver.Search(maze.getCell(maze.start),0);
    }

    //displays usage information when incorrect input is given
    public static void usage() {
        System.out.println("Name of file | Type of solver | Delay time between frames in ms(Not necessary)");
        //System.out.println("Example => spanishinquisition.txt BFS 3");
        System.out.println("random | Width | Height | Type of solver | Delay time between in ms(Not necessary)");
        //System.out.println("Example => random 20 30 DFS");
        System.out.println("recursive | Width | Height | Type of solver | Delay time between frames in ms(Not necessary)");
        //System.out.println("Example => recursive 30 40 Dijkstra 8");
    }

    public static void main(String[] argv) throws FileNotFoundException {
        try {

            if (argv[0].equals("random")) {
                Maze maze = new Maze(Integer.parseInt(argv[1]), Integer.parseInt(argv[2]));
                maze.generateRandom();

                if (argv.length == 5)
                {

                    if (argv[3].equals("BFS")) {
                        Visualization viz = new Visualization(maze);
                        BFS alg = new BFS(maze, viz);
                        ProgramStarter(maze, alg, Integer.parseInt(argv[4]));
                    }

                    else if (argv[3].equals( "DFS")) {
                        Visualization viz = new Visualization(maze);
                        DFS alg = new DFS(maze, viz);
                        ProgramStarter(maze, alg, Integer.parseInt(argv[4]));
                    }

                    else if (argv[3].equals("Dijkstra")) {
                        Visualization viz = new Visualization(maze);
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg, Integer.parseInt(argv[4]));
                    }

                    else throw new Exception("invalid algorithm");

                } else if(argv.length==4)
                {
                    if (argv[3].equals("BFS"))
                    {
                        Visualization viz = new Visualization(maze);
                        BFS alg = new BFS(maze, viz);
                        ProgramStarter(maze, alg);
                    }

                    else if (argv[3].equals("DFS"))
                    {
                        Visualization viz = new Visualization(maze);
                        DFS alg = new DFS(maze, viz);
                        ProgramStarter(maze, alg);
                    }

                    else if (argv[3].equals("Dijkstra"))
                    {
                        Visualization viz = new Visualization(maze);
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg);
                    }

                    else throw new Exception("invalid algorithm");
                }
                else throw new Exception("invalid input");

            } else if (argv[0].equals("recursive"))
            {
                Maze maze = new Maze(Integer.parseInt(argv[1]), Integer.parseInt(argv[2]));
                if (argv.length == 5)
                {
                    if (argv[3].equals("BFS")){
                        Visualization viz = new Visualization(maze);
                        maze.generateRecursiveBacktracker(viz, Integer.parseInt(argv[4]));
                        BFS alg = new BFS(maze, viz);
                        ProgramStarter(maze, alg,Integer.parseInt(argv[4]));
                    }

                    else if (argv[3].equals("DFS"))
                    {
                        Visualization viz = new Visualization(maze);
                        maze.generateRecursiveBacktracker(viz, Integer.parseInt(argv[4]));
                        DFS alg = new DFS(maze, viz);
                        ProgramStarter(maze, alg,Integer.parseInt(argv[4]));
                    }

                    else if (argv[3].equals("Dijkstra"))
                    {
                        Visualization viz = new Visualization(maze);
                        maze.generateRecursiveBacktracker(viz, Integer.parseInt(argv[4]));
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg,Integer.parseInt(argv[4]));
                    }

                    else throw new Exception("invalid algorithm");

                } else if(argv.length==4) {
                    if (argv[3].equals("BFS"))
                    {
                        Visualization viz = new Visualization(maze);
                        maze.generateRecursiveBacktracker(viz, 2);
                        BFS alg = new BFS(maze, viz);
                        ProgramStarter(maze, alg);
                    }

                    else if (argv[3] .equals("DFS"))
                    {
                        Visualization viz = new Visualization(maze);
                        maze.generateRecursiveBacktracker(viz, 2);
                        DFS alg = new DFS(maze, viz);
                        ProgramStarter(maze, alg);
                    }

                    else if (argv[3].equals("Dijkstra")){
                        Visualization viz = new Visualization(maze);
                        maze.generateRecursiveBacktracker(viz, 2);
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg);
                    }

                    else throw new Exception("invalid algorithm");
                }
                else throw new Exception("invalid input");
            } else
                {
                Maze maze = new Maze(argv[0]);
                if (argv.length == 3)
                {
                    if (argv[1].equals("BFS"))
                    {
                        Visualization viz = new Visualization(maze);
                        BFS alg = new BFS(maze, viz);
                        ProgramStarter(maze, alg, Integer.parseInt(argv[2]));
                    }

                    else if (argv[1].equals("DFS"))
                    {
                        Visualization viz = new Visualization(maze);
                        DFS alg = new DFS(maze, viz);
                        ProgramStarter(maze, alg, Integer.parseInt(argv[2]));
                    }

                    else if (argv[1].equals("Dijkstra"))
                    {
                        Visualization viz = new Visualization(maze);
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg, Integer.parseInt(argv[2]));
                    }

                    else throw new RuntimeException("invalid input");

                } else if(argv.length==2)
                {
                    if (argv[1].equals("BFS")) {
                        Visualization viz = new Visualization(maze);
                        BFS alg = new BFS(maze, viz);
                        ProgramStarter(maze, alg);
                    }

                    else if (argv[1].equals("DFS"))
                    {
                        Visualization viz = new Visualization(maze);
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg);
                    }

                    else if (argv[1].equals("Dijkstra"))
                    {
                        Visualization viz = new Visualization(maze);
                        DJKS alg = new DJKS(maze, viz);
                        ProgramStarter(maze, alg);
                    }

                    else {throw new Exception("invalid algorithm");}
                }
                else throw new RuntimeException("invalid input");
            }
        } catch (Exception e) {
            usage();
        }
    }
}

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
