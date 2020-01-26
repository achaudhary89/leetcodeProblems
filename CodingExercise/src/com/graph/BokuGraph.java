package com.graph;

import java.util.ArrayList;
import java.util.List;

/*
This graph problem was asked at an interview with boku; the problem states that find all possible paths from source to destination
The graph contains a cycle bit the max number of edges traverse are already given; so in case of a cycle the the path from A to B will be
considered till the point max is not breached
 */
public class BokuGraph {
    int res;
    int count;
    class Node{
        int val;
        List<Node> childNodes;
        public Node(int val){
            this.val    =   val;
            this.childNodes = new ArrayList<>();
        }
    }

  /*  public int numberOfPath(Node destination){

    }*/
}
