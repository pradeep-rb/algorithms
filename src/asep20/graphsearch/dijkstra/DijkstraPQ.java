package asep20.graphsearch.dijkstra;

import com.sun.source.tree.BreakTree;
import javafx.util.Pair;

import java.util.*;

//https://algorithms.tutorialhorizon.com/dijkstras-shortest-path-algorithm-spt-adjacency-list-and-priority-queue-java-implementation/
public class DijkstraPQ {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge); //for undirected graph
        }

        public void dijkstra_GetMinDistances(int sourceVertex){

           // boolean[] SPT = new boolean[vertices];
            //distance used to store the distance of vertex from a source
           Map<Integer, Integer> distance = new HashMap<>();


            //Initialize priority queue
            //override the comparator to do the sorting based keys
            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                    //sort using distance values
                    int key1 = p1.getKey();
                    int key2 = p2.getKey();
                    return key1-key2;
                }
            });
            //create the pair for for the first index, 0 distance 0 index

            Pair<Integer, Integer> p0 = new Pair<>(0,0); // key is distance from source, value is destination
            //add it to pq
            pq.offer(p0);

            //while priority queue is not empty
            while(!pq.isEmpty()){
                //extract the min
                Pair<Integer, Integer> extractedPair = pq.poll();

                //extracted vertex
                int extractedVertex = extractedPair.getValue();
                if(distance.containsKey(extractedVertex)) continue;
                distance.put(extractedVertex, extractedPair.getKey());

                //iterate through all the adjacent vertices and update the keys
                LinkedList<Edge> list = adjacencylist[extractedVertex];
                for (int i = 0; i < list.size(); i++) {
                    Edge edge = list.get(i);
                    int destination = edge.destination;

                    int newKey =  distance.get(extractedVertex) + edge.weight ;

                    Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                    pq.offer(p);


                    }
            }
        printDijkstra(distance);
        return;
        }
            //print Shortest Path Tree
            //



        public void printDijkstra(Map<Integer, Integer> distmap){
            System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");

            for (Map.Entry<Integer, Integer>  entry: distmap.entrySet()) {
                System.out.println("vertex: " + entry.getKey() + " distance form source: " + entry.getValue());

            }

        }

        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 2);
            graph.addEdge(2, 3, 4);
            graph.addEdge(3, 4, 2);
            graph.addEdge(4, 5, 6);
            graph.dijkstra_GetMinDistances(0);
        }
    }
}