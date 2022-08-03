* When using custom DS like TreeNode or TrieNode, during the construction of the tree/trie
 check to see if augmenting with things like no. of right or left childern, or index position etc. can help later with the solution.

* fix for a mistake in div conq:  mid = (start + end) / 2 + 1;
                        start = mid; end = mid - 1;
* binary search  
    m =  (l + h) /2  + 1  
    l = m,  h = m - 1  
    variation :
    l <= h    m =   (l + h) / 2, l = m+ 1, h = m - 1      

    
Streams/Lamda

* populating a map with lists for value :   someMap.computeIfAbsent(key, l -> new ArrayList<>()).add(value );
* max priority queue with comparator lamda :  Queue<Integer> queue = new PriorityQueue<>( (a, b) -> b - a); poll gives the max vallue
* min priority queue with comparator lamda :  Queue<Integer> queue = new PriorityQueue<>( (a, b) -> a - b); poll gives the min value
* finding max in an integer array:  dist.values().stream().mapToInt(i -> i).max().getAsInt();
* toArray: result.stream().mapToInt(i -> i).toArray()
* PQ: comparator example:         Queue<MazeState> graph = new PriorityQueue<>(Comparator.comparing(MazeState::getDistance).thenComparing(MazeState::getDirection) );
* Comparator :Comparator.comparing() - natural order , thenComparing,  reversed() - reversed natural order


Graphs
* dfs uses stack. BFS - Queue,  Dijkstra uses P Queue.
* Among dfs, bfs and dijkstra, dfs is probably the easiest to code, since the recursive call implicity keeps track of the state
   as opposed to using BFS, where the state has to be stored in a queue *
* its better to use a int visited[] array instead of a map. This is because int visited[] can be used to store more than 2 states - unvisited, visiting visited.
    useful in detecting cycles during dfs

Maps
* GetorDefualt\
 Map<Integer, Integer> counter : counter.put(num, counter.getOrDefault(num, 0) + 1)
* Compute if Absent
     map.computeIfAbsent( key , k -> new ArrayList<>()).add(value);   
* TreeMaps:  find largest value, insert, delete values all in O(logn) time.     

Sets  
* TreeSet:  headSet (returns elements lesser), tailSet (returns elements greater) in O(n)
                        For O(logn) implement a BST in case of integers.
                       
DP   
* Top down is usually good / better for decision problems.   
* Bottom up is usually good for interleaving sub problems.    



Arrays   
* To copy one array to another: System.ArrayCopy (src, srcPos, dest, destPos, Length)
* To initialize an array. Arrays.fill(arr, val)   
* Check array equivalence Arrays.equals   
* To print arrays: Arrays.toString   
* Sort an array:   Arrays.sort(arr, (a, b) -> a[1] - b[1]); args:  T[] generic array and comparator.   
* Print a 2d araray:         Arrays.stream(intervals).forEach(x -> System.out.println(" " + x[0] + "," + x[1] ));

Data Structures:   
D*eque<Integer> stack/queue = new LinkedList<>() / ArrayDeque;

Bitwise:
x = -4;  x >> 1 = -2  
x =  4;  x >> 1 = 2 

Backtracking:
```
    def backtrack(Path, Seletion List  ):
      if meet the End Conditon:
         result.add(Path)
         return

    for seletion in Seletion List:
         select
         backtrack(Path, Seletion List)
         deselect
```
Enums: (refer maze2, maze3)
use constructor, values.
name() gives the enum literal
Objects.equals compares enum with null check
Enumerate through enum ({Enum}.values):  for (Direction dir: Arrays.asList(Direction.values()))

Big(0)
* backtracking algos are usually O(n!)  - see burst balloons. Memoization can reduce the number of states.
* when calculating Big O, look for number of states. Example in TD DP, the memo variable can give you the number of states 

----------------------------------------------------------------------------------------------------------------------------------------------------
Topics sorted by most commonly asked:
------------------------------------
dynamic programming\
graphs\
greedy *\
trees *\
binary search *\
stack *\
Other DS: heap, linkedlists \
two pointers *\
design *\
back track \
div and conq\
sliding window 

Advanced  
MST, Uniton Find, Fenwick (BIT), Segment Tree

----------------------------------------------------------------------------------------------------------------------------------------------------
System Design resources:<br>
[System design primer](https://github.com/donnemartin/system-design-primer)<br>
[Awesome scalability](https://github.com/binhnguyennus/awesome-scalability)

[Gossip Protocol/ Cassandra](https://docs.datastax.com/en/cassandra-oss/2.1/cassandra/architecture/architectureGossipAbout_c.html)<br>
[Dynamo DB - Key Value Store - Replication]( https://www.allthingsdistributed.com/2007/10/amazons_dynamo.html)
                :  consistent hashing, vector clocks, tunable consistency, sloppy quorum,  hinted handoff, merkel tree



Must Watch:   
Tips right before an interview - https://www.youtube.com/watch?v=LQFsEwcCO1E&ab_channel=TechLead
