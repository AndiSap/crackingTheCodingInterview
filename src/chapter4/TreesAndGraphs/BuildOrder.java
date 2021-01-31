package chapter4.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a list of projects and dependencies, find a build order that allows the project to be built
 *
 * Very similar to topological sort
 */
public class BuildOrder {
    /**
     * 1: Build graph with incoming and outgoing edges (keep track of incoming)
     * 2: have buildOrder array and toBeProcessed pointer
     * 3: put all nodes with 0 dependencies in buildOrder array
     * 4: set toBeProcessed to 0
     * 5: while toBeProcesses < number of total nodes
     * 6: get node from toBeProcessed index -> for all child nodes remove dependencies
     * 7: if dependency of a child node is 0 -> add to buildOrder
     * 8: increment toBeProcessed and repeat from #5
     */
    public ProjectNode[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();

        for(String[] dependency : dependencies) {
            String from = dependency[0];
            String to = dependency[1];
            graph.addEdge(from, to);
        }

        return graph;
    }

    public ProjectNode[] orderProjects(ArrayList<ProjectNode> nodes) {
        ProjectNode[] buildOrder = new ProjectNode[nodes.size()]; // solution
        int endOfList = addZeroDependencies(buildOrder, nodes, 0); // get current end of list

        int toBeProcessed = 0; // pointer to first element
        while(toBeProcessed < buildOrder.length) {
            ProjectNode current = buildOrder[toBeProcessed]; // get current element from list "queue"

            if(current == null) return null; // no remaining projects with 0 dependencies

            ArrayList<ProjectNode> neighbors = current.getNeighbors();

            for(ProjectNode neighbor : neighbors) { // decrement dependency for every neighbor
                neighbor.decrementDependencies();
            }

            endOfList = addZeroDependencies(buildOrder, neighbors, endOfList);
            toBeProcessed++;
        }

        return buildOrder;
    }

    public int addZeroDependencies(ProjectNode[] buildOrder, ArrayList<ProjectNode> nodes, int offset) {
       for(ProjectNode node : nodes) {
           if(node.getNumberOfDependencies() == 0) {
               buildOrder[offset] = node;
               offset++;
           }
       }
        return offset;
    }

    class ProjectNode {
        ArrayList<ProjectNode> neighbors = new ArrayList<>();
        HashMap<String, ProjectNode> map = new HashMap<>();
        private String name;
        private int dependencies = 0;

        public ProjectNode(String name) { this.name = name; }

        public void addNeighbor(ProjectNode node) {
            if(!map.containsKey(node.getName())){
                neighbors.add(node);
                map.put(node.getName(), node);
                node.incrementDependencies();
            }
        }

        public void incrementDependencies() { dependencies++; }
        public void decrementDependencies() { dependencies--; }
        public ArrayList<ProjectNode> getNeighbors() { return neighbors; }
        public String getName() { return name;}
        public int getNumberOfDependencies() { return dependencies; }

    }

    class Graph {
        ArrayList<ProjectNode> nodes = new ArrayList<>();
        HashMap<String, ProjectNode> map = new HashMap<>();

        public ProjectNode getOrCreateNode(String name) {
            if(!map.containsKey(name)) {
                ProjectNode node = new ProjectNode(name);
                nodes.add(node);
                map.put(name, node);
            }

            return map.get(name);
        }

        public void addEdge(String from, String to) {
            ProjectNode start = getOrCreateNode(from);
            ProjectNode end = getOrCreateNode(to);
            start.addNeighbor(end);
        }

        public ArrayList<ProjectNode> getNodes() {
            return nodes;
        }
    }
}
