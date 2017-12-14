# maze-search
Implements general maze-searching with real-time vizualisation 

usage is displayed in program on wrong input

first argument is generation method 
	random - randomly sets walls. no guaranteed solution
	recursive - recursive backtracker based generation. Guaranteed access to any cell from any cell

Then follows a pair : width, height

then follows search method: 
	BFS
	DFS with random direction
	DIJKSTRA - guarantees shortest path and usually takes the least time

last optional parameter - time between frames of animation

USAGE : java mainApp generation_method width height solver (wait_time)
