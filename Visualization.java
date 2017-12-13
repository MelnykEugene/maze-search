import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
public class Visualization extends JPanel {

    int IMAGEWIDTH=1680;         // width of the canvas
    int IMAGEHEIGHT=1000;        // height of the canvas

    Maze _maze;                  // local copy of maze to display

    int height;
    int width;

    int CellPixelSize;

    //selects color to paint a certain cell with
    private Color chooseColor(Cell cello){
        //if yellow shows then something is not handled correctly
        Color result = Color.YELLOW;
        if (cello.type==0) result= Color.WHITE;
        if (cello.type==1) result= new Color(70,70,200,200);
        if (cello.type==7) result= Color.RED;
        if (cello.type==8) result= new Color(0,255,0,100);
        if (cello.type==6) result = new Color(0,200,250,250);
        if (cello.current) result = Color.MAGENTA;
        if (cello.type==2) result= Color.RED;
        if (cello.type==4||cello.type==5) result= Color.GREEN;
        return result;
    }

    public Visualization(Maze maze){
        _maze = maze;
        height=_maze.getHeight();
        width=_maze.getWidth();
        //constructor calculates the pixel size of one cell on screen based on the amount of cells to display
        CellPixelSize = Math.min(IMAGEHEIGHT/height,IMAGEWIDTH/width);
        CellPixelSize = Math.min(CellPixelSize,40);

        this.setPreferredSize(new Dimension(IMAGEWIDTH, IMAGEHEIGHT));
        JFrame frame = new JFrame("maze search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
    }

    //what gets called from outside the class
    //basically re-runs code in paintComponent
    public void displayMaze(Maze maze){
        _maze = maze;
        height=_maze.getHeight();
        width=_maze.getWidth();
        this.repaint();
    }

    //opening up the gui window

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // clear screen
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, IMAGEWIDTH, IMAGEHEIGHT);

        // iterate over cells and draw them in corresponding spot with color depending on state of the Cell;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Cell cell = _maze.getCell(new Coordinates(x,y));
                int initx = (IMAGEWIDTH-width*CellPixelSize)/2 + x*CellPixelSize;
                int inity = (IMAGEHEIGHT-height*CellPixelSize)/2 + y*CellPixelSize;
                //System.out.println(initx);
                g.setColor(chooseColor(cell));
                g.fillRect(initx, inity, CellPixelSize, CellPixelSize);
            }
        }
    }

}
