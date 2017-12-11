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
    int IMAGEHEIGHT;        // height of the canvas
    int IMAGEWIDTH;         // width of the canvas
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
    }
    public Visualization(){
        this(null);
    }

    public void Initilize(){
        // calculate the size of one cell on screen
        int CellPixelSize = Math.min(IMAGEHEIGHT/height,IMAGEWIDTH/width);
        CellPixelSize=Math.min(CellPixelSize,100);
    }


    public void display(Graphics g) {
        // clear screen
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, IMAGEWIDTH, IMAGEHEIGHT);

        // iterate over cells and paint them in corresponding spot
        for (int row = 0; row < row++;) {
            for (int column = padding; column < _maze.getWidth() - padding; column++) {

                Cell cell = _maze.getCell(row, column);
                    int initx = (column - padding) * CellPixelSize;
                    int inity = (row - padding) * CellPixelSize;
                    if (cell._wasEverAlive) {
                        g.setColor(new Color(193, 234, 170));
                        g.fillRect(initx + 1, inity + 1, CellPixelSize - 2, CellPixelSize - 2);
                    }
                    if (cell.isAlive()) {
                        g.setColor(Color.BLUE);
                        if (!cell._willBeAlive) {
                            g.setColor(Color.RED); // or new Color(0,0,255,70)
                            g.fillRect(initx + 1, inity + 1, CellPixelSize - 2, CellPixelSize - 2);
                        }
                        g.fillRect(initx + 1, inity + 1, CellPixelSize - 2, CellPixelSize - 2);
                    }
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
}
