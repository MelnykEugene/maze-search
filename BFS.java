// Algorithm from wikipedia
// Code by us

import java.util.LinkedList;
import java.util.ArrayList;

// will be used to build path back when solution is found
//GENERICS ARE USED(GOOD)
//user-defined data structure which is (GOOD)
class Tuple<K,V>{
    public K k;
    public V v;
    public Tuple(K k, V v){
        this.k=k;
        this.v=v;
    }
}

public class BFS extends SearchAlgorithm implements AbleToSearch{
    //stores open cells, the ones which will be called on further iterations
    LinkedList<Cell> open = new LinkedList<Cell>();

    //stores closed cells, the ones which we do not want to ever call again
    ArrayList<Cell> closed = new ArrayList<>();

    //stores Cell - (previus cell) data to construct the path after search is concluded
    ArrayList<Tuple<Cell,Cell>> map = new ArrayList<Tuple<Cell,Cell>>();

    public BFS(Maze maze, Visualization pviz){
        super(maze,pviz);
        this.viz = pviz;
    }

    public void Search(Cell pstart,int wait){
        maze.start=pstart.coords;
        solutionLength=1;
        open.add(pstart);
        while (!open.isEmpty()){
            solutionLength+=1;

            Cell current = open.remove();
            current.current=true;
            if(!closed.contains(current)) closed.add(current);
            current.type=8;

            //if solution reached - draw the math and be done
            if (current.coords.x==maze.finish.x && current.coords.y == maze.finish.y){
                ConstructPath(wait);
                return;
            }

            //looks at all for sides and selects suitable neighbours (not-closed, not-walls, not-outside of bouds) and adds them to collection
            ArrayList<Cell> potentials=new ArrayList<>();

            if (current.coords.y>0 && !closed.contains(maze.getCell(new Coordinates(current.coords.x,current.coords.y-1))) && maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)).type!=1) {
                if (!open.contains(maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)))) open.add(maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)));
                maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)).type=6;
                map.add(new Tuple<>(maze.getCell(new Coordinates(current.coords.x,current.coords.y-1)),current));

            }
            if (current.coords.x>0 && !closed.contains(maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)))&& maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)).type!=1) {
                if (!open.contains(maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)))) open.add(maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)));
                maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)).type=6;
                map.add(new Tuple<>(maze.getCell(new Coordinates(current.coords.x-1,current.coords.y)),current));

            }
            if (current.coords.y<maze.getHeight()-1 && !closed.contains(maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)))&& maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)).type!=1) {
                if (!open.contains(maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)))) open.add(maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)));
                maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)).type=6;
                map.add(new Tuple<>(maze.getCell(new Coordinates(current.coords.x,current.coords.y+1)),current));

            }
            if (current.coords.x<maze.getWidth()-1 && !closed.contains(maze.getCell(new Coordinates(current.coords.x+1,current.coords.y))) && maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)).type!=1) {
                if (!open.contains(maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)))) open.add(maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)));
                maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)).type=6;
                map.add(new Tuple<>(maze.getCell(new Coordinates(current.coords.x+1,current.coords.y)),current));
            }

            runWorld(viz);
            try{
                Thread.sleep(wait,1);
            }

            catch(InterruptedException e){}
            current.current=false;
        }
    }
    public void ConstructPath(int wait){
        ArrayList<Cell> path = new ArrayList<Cell>();
        Cell current = maze.getCell(maze.finish);
        while ((current.coords.x!=maze.start.x) || (current.coords.y!=maze.start.y)){
            path.add(current);
            for(Tuple<Cell,Cell> tuple :map ){
                if (tuple.k==current) current=tuple.v;
            }
        }
        path.add(maze.getCell(maze.start));

        for(Cell cell : path){
            cell.type=2;
            try{
                Thread.sleep(wait,1);
            }
            catch(InterruptedException e){}
            runWorld(viz);
        }
        System.out.println(solutionLength);


    }
    public void runWorld(Visualization viz){
        viz.displayMaze(maze);
    }
}
