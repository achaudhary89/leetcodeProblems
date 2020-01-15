package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CycleDetection {
}

class Graph{
    int V;
    List<List<Integer>> adjacent;

    public Graph(int V){
        this.V = V;
        adjacent    =   new ArrayList<List<Integer>>(V);
        for (int i = 0; i < V ; i++){
            adjacent.add(i, new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination){
        adjacent.get(source).add(destination);
    }

    //public boolean isCyclic()



}
