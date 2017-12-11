import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

public class Visualization extends JPanel {

    int height;             // height of maze in cells
    int width;              // width of maze in cells
    int IMAGEHEIGHT=1050;        // height of the canvas
    int IMAGEWIDTH=1680;         // width of the canvas
    String generateMethod;  // how to regenerate maze
    String solveMethod;     // how to solve maze
    Maze _maze;             // local copy of maze
    int CellPixelSize;      // size of one square cell in pixel


    public Visualization(Maze maze) {
        //_maze = maze;
        //int height = _maze.getHeight();
        //int width = _maze.getWidth();
        this.setPreferredSize(new Dimension(width, height));
        JFrame frame = new JFrame("life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
        _maze = maze;
        height=_maze.getHeight();
        width=_maze.getWidth();
    }
    public Visualization(){
        this(null);
    }

    public void Initilize(){
        // calculate the size of one cell on screen
        int CellPixelSize = Math.min(IMAGEHEIGHT/height,IMAGEWIDTH/width);
        CellPixelSize=Math.min(CellPixelSize,100);
    }


    private void display(Graphics g) {
        // clear screen
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, IMAGEWIDTH, IMAGEHEIGHT);
        // iterate over cells and draw them in corresponding spot with color depending on state of the Cell;
        for (int x = 0; x < width++;) {
            for (int y = 0; y < height; y++) {
                Cell cell = _maze.getCell(x, y);
                    int initx = (x) * CellPixelSize;
                    int inity = (y) * CellPixelSize;
                        g.setColor(new Color(193, 234, 170));
                        g.fillRect(initx + 1, inity + 1, CellPixelSize - 2, CellPixelSize - 2);
                        System.out.println(1);
            }
        }
    }

    public void shownew() {
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        display(g);
    }

    //selects color to paint a certain cell with
    private Color chooseColor(Cell cello){
        if (cello.type==0) return Color.WHITE;
        else return Color.BLUE;
    }
}
