package aocUtils;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphUtilsTest {

    @Test
    void testBfs() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, List.of(4));
        graph.put(3, List.of(4));
        graph.put(4, Collections.emptyList());
        
        List<Integer> bfsResult = GraphUtils.bfs(graph, 1);
        assertEquals(Arrays.asList(1, 2, 3, 4), bfsResult);
    }

    @Test
    void testDfs() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, List.of(4));
        graph.put(3, List.of(4));
        graph.put(4, Collections.emptyList());

        List<Integer> dfsResult = GraphUtils.dfs(graph, 1);
        assertEquals(Arrays.asList(1, 3, 4, 2), dfsResult);
    }
}