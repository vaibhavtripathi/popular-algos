import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

public class Dijkstra {
    public Map<Integer, Integer> compute(Map<Integer, List<int[]>> graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        queue.offer(new int[]{1, 0});
        while (queue.size() > 0) {
            int[] nearest = queue.poll();
            if (graph.containsKey(nearest[0])) {
                List<int[]> adj = graph.get(nearest[0]);
                for (int[] v : adj) {
                    queue.offer(new int[]{v[0], v[1] + nearest[1]});
                }
            }
            distances.put(nearest[0], nearest[1]);
        }
        return distances;
    }

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(new int[]{3, 2}, new int[]{5, 9}, new int[]{2, 1}));
        graph.put(2, Arrays.asList(new int[]{4, 2}));
        graph.put(3, Arrays.asList(new int[]{5, 11}));
        graph.put(4, Arrays.asList(new int[]{5, 2}));
        Map<Integer, Integer> distances = d.compute(graph, 1);
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}