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