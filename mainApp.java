import javax.swing.*;
import java.io.FileNotFoundException;

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

    public mainApp(Visualization viz){
        visualization=viz;
    }
    public static void main(String[] argv) throws FileNotFoundException {
        Maze maze = new Maze(200,100);

        maze.generateRandom();
        Visualization viz = new Visualization(maze);

//        JFrame frame = new JFrame("maze search");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setContentPane(new mainApp(viz).mainPanel);
//        frame.pack();
//        frame.setVisible(true);

        DFS solver = new DFS(maze,viz);
        solver.Search(maze.getCell(maze.start));
    }
}
