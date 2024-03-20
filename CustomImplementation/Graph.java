package org.example.CustomImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    List<ArrayList<Integer>> adjList = new ArrayList<>();


    Graph(int v){
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u , int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printAdjList(){
        for (int i = 0; i < adjList.size(); i++) {

            System.out.print(i+"-->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public void bfs(int v){
        int  V = adjList.size();
        boolean[] visited = new boolean[V];
        visited[v] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while (!q.isEmpty()){
            int vertex = q.remove();
            System.out.print(vertex+" ");
            for (int i = 0; i < adjList.get(vertex).size(); i++) {
                int av = adjList.get(vertex).get(i);

                if (!visited[av]){
                    q.add(av);
                    visited[av] = true;
                }
            }
        }
    }
}
