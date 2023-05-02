package graphsAlgorithms.DijkstrAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;



//  Алгоритм Дейкстры — это алгоритм нахождения кратчайшего пути во взвешенном графе с неотрицательными весами ребер. Он использует жадный подход,
//  постепенно наращивая дистанцию от начальной вершины до остальных. Алгоритм Дейкстры можно реализовать с помощью приоритетной очереди,
//  в которую помещаются вершины с их текущими расстояниями от начальной вершины,
//  и в каждой итерации алгоритма выбирается вершина с наименьшим расстоянием и рассматриваются ее соседи для обновления расстояний.
import java.util.*;

//public class DijkstraAlgorithm {
//
//    // Вспомогательный класс для хранения расстояний от начальной вершины
//    // и списка смежных вершин
//    private static class Node implements Comparable<Node> {
//        int vertex;
//        int distance;
//
//        public Node(int vertex, int distance) {
//            this.vertex = vertex;
//            this.distance = distance;
//        }
//
//        // Сравнение вершин по расстоянию
//        @Override
//        public int compareTo(Node other) {
//            return Integer.compare(distance, other.distance);
//        }
//    }
//
//    // Реализация алгоритма Дейкстры
//    public static int[] dijkstra(int[][] graph, int start) {
//        int n = graph.length;
//        int[] distances = new int[n];
//        Arrays.fill(distances, Integer.MAX_VALUE);
//        distances[start] = 0;
//
//        PriorityQueue<Node> queue = new PriorityQueue<>();
//        queue.offer(new Node(start, 0));
//
//        while (!queue.isEmpty()) {
//            Node curr = queue.poll();
//
//            // Если вершина уже обработана, пропускаем ее
//            if (distances[curr.vertex] < curr.distance) {
//                continue;
//            }
//
//            // Обновляем расстояния до соседних вершин
//            for (int i = 0; i < n; i++) {
//                int edgeWeight = graph[curr.vertex][i];
//                if (edgeWeight > 0) {
//                    int distance = curr.distance + edgeWeight;
//                    if (distance < distances[i]) {
//                        distances[i] = distance;
//                        queue.offer(new Node(i, distance));
//                    }
//                }
//            }
//        }
//
//        return distances;
//    }
//
//    // Пример использования
//    public static void main(String[] args) {
//        int[][] graph = {
//                {0, 2, 4, 0, 0},
//                {2, 0, 1, 4, 2},
//                {4, 1, 0, 1, 4},
//                {0, 4, 1, 0, 1},
//                {0, 2, 4, 1, 0}
//        };
//
//        int startVertex = 0;
//        int[] distances = dijkstra(graph, startVertex);
//
//        for (int i = 0; i < distances.length; i++) {
//            System.out.println("Distance from vertex " + startVertex + " to vertex " + i + " is " + distances[i]);
//        }
//    }
//}
class DijkstraAlgorithm {
    static final int V = 5;
    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
    void printSolution(int dist[]) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        printSolution(dist);
    }
    public static void main(String[] args) {
        int graph[][] = { { 0, 4, 0, 0, 0 },
                { 4, 0, 8, 0, 0 },
                { 0, 8, 0, 7, 0 },
                { 0, 0, 7, 0, 9 },
                { 0, 0, 0, 9, 0 } };
        DijkstraAlgorithm t = new DijkstraAlgorithm();
        t.dijkstra(graph, 0);
    }
}