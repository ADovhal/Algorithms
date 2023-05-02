package graphsAlgorithms.BellmanFord;


//        Алгоритм Беллмана-Форда - это алгоритм нахождения кратчайших путей во взвешенном графе с отрицательными весами ребер.
//        Алгоритм основан на идее прохода по всем ребрам графа несколько раз и обновлении кратчайших расстояний от начальной вершины до всех остальных вершин.
//        В конце алгоритма проверяется, есть ли отрицательный цикл в графе.
//
//        Алгоритм Беллмана-Форда работает следующим образом:
//
//        Инициализировать расстояния до всех вершин, кроме начальной, бесконечно большими.
//        Установить расстояние до начальной вершины равным 0.
//        Повторить следующее для каждой вершины v графа n-1 раз:
//        Перебрать все ребра (u, v) графа, обновить расстояние до вершины v, если новое расстояние меньше текущего.
//        Проверить наличие отрицательного цикла в графе.

import java.util.Arrays;

public class BellmanFord {
    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static int INF = Integer.MAX_VALUE, V, E;
    static Edge[] edge;
    static int[] dist;

    static void BellmanFordAlgo() {
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = edge[j].source;
                int v = edge[j].destination;
                int weight = edge[j].weight;
                if (dist[u] != INF && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int j = 0; j < E; j++) {
            int u = edge[j].source;
            int v = edge[j].destination;
            int weight = edge[j].weight;
            if (dist[u] != INF && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println("Distance from vertex 0 to vertex " + i + " is " + dist[i]);
    }

    public static void main(String[] args) {
        V = 5;
        E = 8;
        edge = new Edge[E];
        edge[0] = new Edge(0, 1, -1);
        edge[1] = new Edge(0, 2, 4);
        edge[2] = new Edge(1, 2, 3);
        edge[3] = new Edge(1, 3, 2);
        edge[4] = new Edge(1, 4, 2);
        edge[5] = new Edge(3, 2, 5);
        edge[6] = new Edge(3, 1, 1);
        edge[7] = new Edge(4, 3, -3);

        dist = new int[V];

        BellmanFordAlgo();
    }
}

