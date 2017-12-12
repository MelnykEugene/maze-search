import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

public class Visualization extends JPanel {

    String generateMethod;  // how to regenerate maze
    String solveMethod;     // how to solve maze
    int IMAGEWIDTH=1680;         // width of the canvas
    int IMAGEHEIGHT=1050;        // height of the canvas
    Maze _maze;
    int height;
    int width;
    int CellPixelSize;

    //selects color to paint a certain cell with
    private static Color chooseColor(Cell cello){
        if (cello.type==0) return Color.WHITE;
        if (cello.type==3) return Color.RED;
        if (cello.type==4||cello.type==5) return Color.RED;

        else return Color.BLUE;
    }

    public  void displayMaze(Maze maze){

        _maze = maze;
        height=_maze.getHeight();
        width=_maze.getWidth();
        CellPixelSize = Math.min(IMAGEHEIGHT/height,IMAGEWIDTH/width);
        CellPixelSize=Math.min(CellPixelSize,100);
        this.repaint();
    }
    public Visualization(Maze maze) {
        //_maze = maze;
        //int height = _maze.getHeight();
        //int width = _maze.getWidth();
        this.setPreferredSize(new Dimension(IMAGEWIDTH, IMAGEHEIGHT));
        JFrame frame = new JFrame("life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
    }

    private void display(Graphics g) {
        // clear screen
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, IMAGEWIDTH, IMAGEHEIGHT);

        // iterate over cells and draw them in corresponding spot with color depending on state of the Cell;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Cell cell = _maze.getCell(x, y);
                int initx = (x) * CellPixelSize;
                int inity = (y) * CellPixelSize;
                //System.out.println(initx);
                g.setColor(chooseColor(cell));
                g.fillRect(initx + 1, inity + 1, CellPixelSize - 2, CellPixelSize - 2);
            }
        }
    }

    public void shownew(Maze maze) {
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        display(g);
    }

}
