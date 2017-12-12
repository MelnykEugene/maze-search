import java.util.Random;
import java.util.Scanner;
/*

//https://algs4.cs.princeton.edu/41graph/Maze.java.html

public class MazeGenerator
{
    private int wid;
    private int hei;
    private Cell[][] imaze;
    private boolean[][] north;
    private boolean[][] south;
    private boolean[][] east;
    private boolean[][] west;
    private boolean[][] state;

    public MazeGenerator(int width, int height)
    {
        wid = width;
        hei = height;
        state = new boolean[wid][hei];
        imaze = new Cell[wid][hei];
        setupMaze();
    }

    public void setState()
    {
        for (int x = 0; x < wid; x++)
        {
            state[x][0] = true;
            state[x][hei-1] = true;
        }
        for (int y = 0; y < hei; y++)
        {
            state[0][y] = true;
            state[wid-1][y] = true;
        }
    }

    public void setWalls() {
        north = new boolean[wid][hei];
        south = new boolean[wid][hei];
        east = new boolean[wid][hei];
        west = new boolean[wid][hei];
        for (int x = 0; x < wid; x++) {
            for (int y = 0; y < hei; y++) {
                north[x][y] = true;
                south[x][y] = true;
                east[x][y] = true;
                west[x][y] = true;

            }
        }
    }

        public void generateMaze(int starX, int starY) {
            state[starX][starY] = true;
            while (!state[x+1][y] || !state[x][y+1] || !state[x-1][y] || !state[x][y-1])
            {
                while (true)
                {
                    int route = (int)(Math.random() * 4);
                    if (r == 0 && !state[x+1][y])
                    {
                        west[x+1][y] = false;
                        east[x][y] = false;
                        generateMaze(x+1, y);
                    }
                    else if (r == 1 && !state[x][y+1])
                    {
                        south[x][y+1] = false;
                        north[x][y] = false;
                        generateMaze(x, y + 1);
                    }
                    else if (r == 2 && !state[x-1][y])
                    {
                        east[x-1][y] = false;
                        west[x][y] = false;
                        generateMaze(x-1, y);
                    }
                    else if (r == 3 && !state[x][y-1])
                    {
                        north[x][y-1] = false;
                        south[x][y] = false;
                        generateMaze(x, y-1);
                    }
                }
            }
        }
    }

    public void setupMaze()
    {
        setState();
        setWalls();
        generateMaze(1,1);
        for (int x = 0; x < wid; x++)
        {
            for (int y = 0; y < hei; y++)
            {
                if (north[x][y])
                {
                    imaze[x][y+1] = 1;
                }
                if (south[x][y])
                {
                    imaze[x][y-1] = 1;
                }
                if (east[x][y])
                {
                    imaze[x+1][y] = 1;
                }
                if (west[x][y])
                {
                    imaze[x-1][y] = 1;
                }

            }
        }
    }

    public int[][] getMaze()
    {
        return imaze;
    }
}

*/