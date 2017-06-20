package Graphs;

import java.util.LinkedList;

/**
 * Created by amidezcod on 20/6/17.
 */
public class Graph {
    int vertices;
    LinkedList<Integer> adj[];

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int vert, int j) {
        adj[vert].add(j);
    }
}
