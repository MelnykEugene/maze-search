/*
Encapsulation of Cells in the maze

value of type corresponds to logic states of the cell:
0-empty
1-is a wall
2-conlusively part of solution
3-current
4-start
5-end
6-open (will be further called)
7-in stack (deemed as part of path)
8-visited (but no longer a part of stack)

 */

class Cell{
    int type;
    public Coordinates coords;
    public double weight;
    public boolean discovered=false;
    public boolean current = false;
    public boolean visited = false; //used for recursive maze-generator
                                    //this additional boolean var is required because in generator a cell can be both visited
                                    //and a wall

    public Cell(int ptype, Coordinates pcoords){
        this.type=ptype;
        this.coords=pcoords;
        this.weight=1;
    }

}