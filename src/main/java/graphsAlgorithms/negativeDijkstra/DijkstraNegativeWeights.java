package graphsAlgorithms.negativeDijkstra;
import java.util.*;

import java.util.*;

public class DijkstraNegativeWeights {

    private static void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (graph[u][v] != 0) {
                        int alt = dist[u] + graph[u][v];
                        if (alt < dist[v]) {
                            dist[v] = alt;
                        }
                    }
                }
            }
        }

        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0) {
                    int alt = dist[u] + graph[u][v];
                    if (alt < dist[v]) {
                        System.out.println("Graph contains negative weight cycle");
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Distance from vertex " + start + " to vertex " + i + " is " + "infinite");
            } else {
                System.out.println("Distance from vertex " + start + " to vertex " + i + " is " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{0, -1, 4, 0, 0},
                {0, 0, 3, 2, 2},
                {0, 0, 0, 0, 0},
                {0, 1, 5, 0, 0},
                {0, 0, 0, -3, 0}};
        int start = 0;

        dijkstra(graph, start);
    }
}
