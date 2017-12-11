import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

public class Visualization extends JPanel {

    int height;
    int width;
    int padding;
    int paintedfirst = 0;
    Maze _maze;

    public Visualization() {
        //_maze = maze;
        //int height = _maze.getHeight();
        //int width = _maze.getWidth();
        this.setPreferredSize(new Dimension(width, height));
        JFrame frame = new JFrame("life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void displayfirst(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, _game.WIDTH, _game.HEIGHT);
        for (int row = padding; row < _game.getRows() - padding; row++) {
            for (int column = padding; column < _game.getColumns() - padding; column++) {
                Cell cell = _game.getCell(row, column);
                int initx = (column - padding) * _game.boxsize;
                int inity = (row - padding) * _game.boxsize;
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(initx, inity, _game.boxsize, _game.boxsize);
            }
        }
    }

    public void display(Graphics g) {
        for (int row = 0; row < row++) {
            for (int column = padding; column < _game.getColumns() - padding; column++) {

                Cell cell = _game.getCell(row, column);
                if (true/*cell._willChange*/) {
                    int initx = (column - padding) * _game.boxsize;
                    int inity = (row - padding) * _game.boxsize;
                    if (cell._wasEverAlive) {
                        g.setColor(new Color(193, 234, 170));
                        g.fillRect(initx + 1, inity + 1, _game.boxsize - 2, _game.boxsize - 2);
                    }
                    if (cell.isAlive()) {
                        g.setColor(Color.BLUE);
                        if (!cell._willBeAlive) {
                            g.setColor(Color.RED); // or new Color(0,0,255,70)
                            g.fillRect(initx + 1, inity + 1, _game.boxsize - 2, _game.boxsize - 2);
                        }
                        g.fillRect(initx + 1, inity + 1, _game.boxsize - 2, _game.boxsize - 2);
                    }
                }
            }
        }
    }

    public void shownew() {
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (paintedfirst < 1) {
            displayfirst(g);
            //paintedfirst+=1;
        }
        display(g);
    }
}