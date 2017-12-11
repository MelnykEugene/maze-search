/*
Encapsulation of Cells in the maze

value of type corresponds to logic states of the cell:
0-empty
1-is a wall

 */

class Cell{
    int type;
    public Coordinates coords;
    public double weight;
    public Cell(int ptype, Coordinates pcoords){
        this.type=ptype;
        this.coords=pcoords;
        this.weight=1;
    }

}