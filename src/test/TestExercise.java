package test;

import exercise.GraphType;
import exercise.MatrixGraph;

public class TestExercise {
    public static void testGraph(){
        int n = 6;
        int[][] edges = {
                {1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 1}
        };
        MatrixGraph graph = new MatrixGraph(n, GraphType.UDG, edges);
        MatrixGraph.DFS(graph, 0);
    }
}
