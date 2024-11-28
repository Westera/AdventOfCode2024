package aocUtils;

import java.util.*;

/**
 * Utility class for common graph algorithms.
 */
public class GraphUtils {

    /**
     * Performs a breadth-first search (BFS) on the given graph starting from the specified node.
     *
     * @param graph the graph represented as a map where the key is a node and the value is the list of adjacent nodes
     * @param start the starting node for the BFS
     * @return a list of nodes in the order they were visited during the BFS
     */
    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                queue.addAll(graph.getOrDefault(node, Collections.emptyList()));
            }
        }
        
        return visited;
    }

    /**
     * Performs a depth-first search (DFS) on the given graph starting from the specified node.
     *
     * @param graph the graph represented as a map where the key is a node and the value is the list of adjacent nodes
     * @param start the starting node for the DFS
     * @return a list of nodes in the order they were visited during the DFS
     */
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                stack.addAll(graph.getOrDefault(node, Collections.emptyList()));
            }
        }
        
        return visited;
    }
}