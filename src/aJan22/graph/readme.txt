**DFS vs BFS**<br>
shortest path on simple graph -> bfs.   It first finds all the vertices that are one edge away from the starting point, then all the vertices that are two edges away, and so on. This is useful if you’re trying to find the shortest path from the starting vertex to a given vertex.<br>
all possible results->bfs<br>
when using weighter graphs -> Dijstra finds the shortest distance. Dijkstra is greedy

DFS: stack, BFS: queue, Dijkstra: Min Priority Queue


Algos
DFS, BFS, Dijkstra, Bellman-ford, Topological sort

Optional Reading: 
Minimum spanning tree, Prims algorith
------------------------------------------------------------------------------------------------------------------------
994. Rotting Oranges  BFS.

Solution:
1) find all inital rotton tomatoes and store in Queue of int[2] (seed)
how to count steps ?
The outer loop runs as long as the queue is not empty.
 Run the innerloop for the queue size. Everytime the inner loop ends, count the steps
  Add the neighbors of the rotten cell back to the queue. Use a direction matrix to go to the neighbors

Finally if there are no fresh cells, return the steps. else return -1.
------------------------------------------------------------------------------------------------------------------------
200. Number of Islands

Soln: BFS or DFS.  Need to mark the already visited cells in the input grid itself
------------------------------------------------------------------------------------------------------------------------


