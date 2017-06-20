package Graphs;

import java.util.Iterator;

/**
 * Created by amidezcod on 20/6/17.
 */
public class DFSDemonstration {
    static Graph graph = new Graph(4);

    private static void DFS(int startingVertex, int noOfVertices) {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                DFSRecursive(startingVertex, visited);
            }
        }
    }

    private static void DFSRecursive(int startingVertex, boolean visited[]) {
        visited[startingVertex] = true;
        System.out.print(startingVertex+" ");
        Iterator<Integer> integerIterator = graph.adj[startingVertex].listIterator();
        while (integerIterator.hasNext()) {
            int i = integerIterator.next();
            //checking if it is visted or not  if not not the add the vertex to queue
            //and make it visited true
            if (!visited[i]) {
                visited[i] = true;
                DFSRecursive(i , visited);
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
        System.out.println("The Dfs traversal is ");
        DFS(2, 4);

    }
}
