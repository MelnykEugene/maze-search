// Algorithm from wikipedia
// Code by us

import javafx.scene.layout.Priority;
import sun.misc.Queue;

import java.util.*;
import java.util.Collections.*;
import java.util.function.DoubleBinaryOperator;

public class DJKS extends SearchAlgorithm implements AbleToSearch{
    //stores open cells, the ones which will be called on further iterations
    LinkedList<Cell> open = new LinkedList<Cell>();

    //stores closed cells, the ones which we do not want to ever call again
    ArrayList<Cell> closed = new ArrayList<>();

    //stores Cell - (previus cell) data to construct the path after search is concluded
    ArrayList<Tuple<Cell,Cell>> map = new ArrayList<Tuple<Cell,Cell>>();

    public DJKS(Maze maze, Visualization pviz){
        super(maze,pviz);
        this.viz = pviz;
    }
    public void Search(Cell start,int wait) {
        solutionLength = 1;

        // our cell-distance dictionary
        HashMap<Cell, Double> dist = new HashMap<Cell, Double>();

        // our cell-previouscell dictionary
        HashMap<Cell, Cell> prev = new HashMap<Cell, Cell>();

        //our priority que of tuples(priority,cell)
        //priority comparator is based on priority of cell
        LinkedList<Cell> que = new LinkedList<Cell>();

        for (int x = 0; x < maze.getWidth(); x++) {
            for (int y = 0; y < maze.getHeight(); y++) {
                Cell cell = maze.getCell(new Coordinates(x, y));
                if (x != maze.start.x || y != maze.start.y) {
                    dist.put(cell, Double.POSITIVE_INFINITY);
                    prev.put(cell, null);
                }
                que.add(cell);
            }
        }
        dist.put(maze.getCell(maze.start),0.0);

        while (!que.isEmpty()) {
            Cell current=null;
            for (Cell cell:que){
                double min = Double.POSITIVE_INFINITY;
                if (dist.get(cell)<min){
                    current=cell;
                    min = dist.get(cell);
                }
            }

            que.remove(current);
            current.type=8;

            if (current.coords.x == maze.finish.x && current.coords.y == maze.finish.y) {
                drawSolution(prev,wait);
                System.out.println("gucci");
                return;
            }

            if (current.coords.y > 0 && maze.getCell(new Coordinates(current.coords.x, current.coords.y - 1)).type != 1) {
                Cell neighbourv = maze.getCell(new Coordinates(current.coords.x, current.coords.y - 1));
                Double alt = dist.get(current) + 1;
                if (alt < dist.get(neighbourv)) {
                    dist.put(neighbourv, alt);
                    prev.put(neighbourv, current);
                                   }
            }
            if (current.coords.x > 0 && maze.getCell(new Coordinates(current.coords.x - 1, current.coords.y)).type != 1) {
                Cell neighbourv = maze.getCell(new Coordinates(current.coords.x-1, current.coords.y ));
                Double alt = dist.get(current) + 1;
                if (alt < dist.get(neighbourv)) {
                    dist.put(neighbourv, alt);
                    prev.put(neighbourv, current);
                }
            }
            if (current.coords.y < maze.getHeight() - 1 && maze.getCell(new Coordinates(current.coords.x, current.coords.y + 1)).type != 1) {
                Cell neighbourv = maze.getCell(new Coordinates(current.coords.x, current.coords.y + 1));
                Double alt = dist.get(current) + 1;
                if (alt < dist.get(neighbourv)) {
                    dist.put(neighbourv, alt);
                    prev.put(neighbourv, current);
                }
            }

            if (current.coords.x < maze.getWidth() - 1 && maze.getCell(new Coordinates(current.coords.x + 1, current.coords.y)).type != 1) {
                Cell neighbourv = maze.getCell(new Coordinates(current.coords.x+1, current.coords.y));
                Double alt = dist.get(current) + 1;
                if (alt < dist.get(neighbourv)) {
                    dist.put(neighbourv, alt);
                    prev.put(neighbourv, current);
                }
            }
            try{
                Thread.sleep(wait,1);
            }
            catch(InterruptedException e){}
            runWorld(viz);
        }
    }

    public void drawSolution(HashMap<Cell, Cell> prev,int wait){
        ArrayList<Cell> path = new ArrayList<Cell>();
        Cell current=maze.getCell(maze.finish);
        while(prev.get(current)!=null){
            path.add(current);
            current = prev.get(current);
        }
        path.add(maze.getCell(maze.finish));

        for(Cell cell : path){
            cell.type=2;
            try{
                Thread.sleep(wait,1);
            }
            catch(InterruptedException e){}
            runWorld(viz);
        }
    }
    public void runWorld(Visualization viz){
        viz.displayMaze(maze);
    }
}
