package org.example.CustomImplementation;

import org.example.CustomImplementation.Graph;

public class GraphRepresentation {
    public static void main(String[] args) {
        int[][] adMatrix = {
                {0,1,0,0,1},
                {1,0,1,0,1},
                {0,1,0,1,0},
                {0,0,1,0,1},
                {1,1,0,1,0}
        };
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(2,3);
        graph.addEdge(1,2);
        graph.addEdge(3,4);
        graph.addEdge(0,4);
        graph.addEdge(1,4);

        graph.printAdjList();
        graph.bfs(0);
    }
}
