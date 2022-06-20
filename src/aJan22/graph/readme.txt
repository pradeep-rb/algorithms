Todo:
    1345. Jump Game IV
    1306. Jump Game III
    967. Numbers With Same Consecutive Differences
    269h. Alien Dictionary
    505. The Maze II  -> redo using dfs/bfs with dijkstra
    1391 https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
    1485. Clone Binary Tree With Random Pointer

**DFS vs BFS**<br>
shortest path on simple graph -> bfs.   It first finds all the vertices that are one edge away from the starting point, then all the vertices that are two edges away, and so on. This is useful if you’re trying to find the shortest path from the starting vertex to a given vertex.<br>
all possible results->bfs<br>
when using weighted graphs -> Dijstra finds the shortest distance. Dijkstra is greedy

DFS: stack, BFS: queue, Dijkstra: Min Priority Queue
** Among dfs, bfs and dijkstra, dfs is probably the easiest to code, since the recursive call implicity keeps track of the state
 as opposed to using BFS, where the state has to be stored in a queue **


Algos
DFS, BFS, Dijkstra,  Topological sort

Topological Sort:
2 algorithms :  Kahn's and DFS based
* Dfs : Recursively explore every vertex in graph. After exploring all neighbors of the vertex, add the vertex to the front of the list
https://www.interviewcake.com/concept/java/topological-sort
* Kahns: Put all 0 degree vertex in a Q. Remove vertex, put it end of list, for every neighbor v', decrease its in degree by 1.
if v' in-degree is 0, add it to the Q.
https://www.baeldung.com/cs/dag-topological-sort

Dijkstra Algorithms:
https://leetcode.com/list/53js48ke/
Hard: 882,499

Optional Reading: 
Bellman-ford, Minimum spanning tree, Prims algorithm
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

Soln: BFS or DFS.  Need to mark the already visited cells in the input grid rather than a separate ds
------------------------------------------------------------------------------------------------------------------------
743. Network Delay Time
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
If it is impossible for all the n nodes to receive the signal, return -1.

Solution:  Maintain a map of distances from the src: (also serves the purpose showing if a node has been visited)
------------------------------------------------------------------------------------------------------------------------
210  Course Schedule 2. Topological sort by DFS
The tricky part is cycle detection.  DFS alone requires only two states : not visited and visited
Cycle detection needs a 3rd state : visiting.
------------------------------------------------------------------------------------------------------------------------
329. Longest Increasing Path in a Matrix
Solution:  DFS + memoization
DFS becuase, it is easier to code, use memoization.
the implementation with DFS seems pretty straightforward.
    However, its simple only because we are looking for an increasing sequence and hence there are no cycles.
    We don't have to explicitly detect cycles which is usually the case in DFS.
    If this isn't obvious at first, you might end up writing complicated code.
------------------------------------------------------------------------------------------------------------------------







