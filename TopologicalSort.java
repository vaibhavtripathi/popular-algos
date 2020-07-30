import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class TopologicalSort {
    public void visitAndProcess(Integer vertex, Set<Integer> visited, Map<Integer, List<Integer>> m, Stack<Integer> sortedStack) {
        if (visited.contains(vertex)) return;
        visited.add(vertex);
        List<Integer> adj = m.getOrDefault(vertex, new ArrayList<>());
        for (Integer neighbourV : adj) {
            visitAndProcess(neighbourV, visited, m, sortedStack);
        }
        sortedStack.push(vertex);
    }

    public List<Integer> sort(List<int[]> edges) {
        Map<Integer, List<Integer>> dependents = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> adj = dependents.getOrDefault(edge[0], new LinkedList<>());
            adj.add(edge[1]);
            dependents.put(edge[0], adj);
        }
        Stack<Integer> sortedStack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer vertex : dependents.keySet()) {
            visitAndProcess(vertex, visited, dependents, sortedStack);
        }
        List<Integer> sorted = new LinkedList<>();
        while (sortedStack.size() > 0) {
            sorted.add(sortedStack.pop());
        }
        return sorted;
    }

    public static void main(String[] args) {
        TopologicalSort t = new TopologicalSort();
        int[] edge1 = {1, 2};
        int[] edge2 = {1, 3};
        int[] edge3 = {2, 4};
        int[] edge4 = {3, 4};
        int[] edge5 = {5, 1};
        List<int[]> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        List<Integer> sorted = t.sort(edges);
        for (Integer v : sorted) {
            System.out.println(v);
        }
    }
}