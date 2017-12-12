import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
public class Visualization extends JPanel {

    String generateMethod;  // how to regenerate maze
    String solveMethod;     // how to solve maze
    int IMAGEWIDTH=1680;         // width of the canvas
    int IMAGEHEIGHT=1000;        // height of the canvas
    Maze _maze;
    int height;
    int width;
    int CellPixelSize;

    //selects color to paint a certain cell with
    private Color chooseColor(Cell cello){
        //if yellow shows than something is not handled
        Color result = Color.YELLOW;
        if (cello.type==0) result= Color.WHITE;
        if (cello.type==1) result= new Color(70,70,200,200);
        if (cello.discovered) result= new Color(0,200,0,180);
        if (cello.type==4||cello.type==5) result= Color.GREEN;
        if (cello.type==2) result= Color.RED;
        if (cello.current) result = Color.MAGENTA;
        return result;
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
        JFrame frame = new JFrame("maze search");
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
                Cell cell = _maze.getCell(new Coordinates(x,y));
                int initx = (x) * CellPixelSize;
                int inity = (y) * CellPixelSize;
                //System.out.println(initx);
                g.setColor(chooseColor(cell));
                g.fillRect(initx, inity, CellPixelSize, CellPixelSize);
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
