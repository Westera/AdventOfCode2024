package utils;

import java.util.*;

public class GraphUtils {
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