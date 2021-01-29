package chapter4.TreesAndGraphs;

import java.util.LinkedList;

public class RouteBtwNodes {

    /**
     * Given a directed graph, find if there is a route from source to destination
     */
    public boolean bfsSearch(Graph graph, Node source, Node destination) {
        LinkedList<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.nodes.length];
        queue.add(source);
        visited[source.value] = true;

        while(!queue.isEmpty()) {
            Node next = queue.poll();
            for(Node neighbor : next.getChildren()) {
                if(!visited[neighbor.value]) {
                    visited[neighbor.value] = true;
                    if(neighbor == destination)
                        return true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
}

class Graph {
    public Node[] nodes;
}

abstract class Node {
    public Node[] children;
    public int value;
    public Node[] getChildren() { return children; }
}
