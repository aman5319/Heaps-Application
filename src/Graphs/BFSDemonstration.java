package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by amidezcod on 20/6/17.
 */
public class BFSDemonstration {
    static Graph graph = new Graph(4);

    // printing BFS tracversal
    static void bfs(int startingVertex, int noOfVertices) {
        /* boolean visited array to keep track of vertex with are visited
            and by default all are false
        */
        boolean[] visited = new boolean[noOfVertices];
        /*
        queue to insert the visted vertex
         */

        LinkedList<Integer> integerQueue = new LinkedList<>();


        // inserting the first vertex
        integerQueue.add(startingVertex);

        //making the firstVertex as visited
        visited[startingVertex] = true;


        int visitedVertex;

        while (integerQueue.size() != 0) {
            // deleting the first vertex from queue
            visitedVertex = integerQueue.poll();
            //printing the visitedVertex
            System.out.println(visitedVertex);

            //iterating over the each  adjancey array  using iterator
            Iterator<Integer> integerIterator = graph.adj[visitedVertex].listIterator();
            while (integerIterator.hasNext()) {

                //taking the element from the iteraator
                int i = integerIterator.next();
                //checking if it is visted or not  if not not the add the vertex to queue
                //and make it visited true
                if (!visited[i]) {
                    integerQueue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // adding vertices in adjancey list format
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("The Bfs traversal is ");
        bfs(1, 4);

    }


}
