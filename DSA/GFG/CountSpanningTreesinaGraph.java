// Given a connected undirected graph with n vertices and m edges, where each edge is represented as edges[i]=[u,v]  indicating an edge between vertices u and v.

// Determine the total number of distinct spanning trees that can be formed from the graph.

// Note: A spanning tree is a subgraph of the given graph that includes all n vertices, has exactly n-1 edges, is connected, and contains no cycles; therefore, every connected undirected graph always has at least one spanning tree.
import java.util.*;

public class CountSpanningTreesinaGraph {
    public static int countSpanningTrees(int n, int[][] edges) {
        if (n <= 1) return 1;
        
        int[][] adj = new int[n][n];
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u][v]++;
            adj[v][u]++;
            degree[u]++;
            degree[v]++;
        }

        double[][] L = new double[n - 1][n - 1];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i == j) {
                    L[i][j] = degree[i];
                } else {
                    L[i][j] = -adj[i][j];
                }
            }
        }

        return (int) Math.round(determinant(L, n - 1));
    }

    private static double determinant(double[][] matrix, int n) {
        double det = 1;
        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[pivot][i])) {
                    pivot = j;
                }
            }
            if (pivot != i) {
                double[] temp = matrix[i];
                matrix[i] = matrix[pivot];
                matrix[pivot] = temp;
                det = -det;
            }
            if (Math.abs(matrix[i][i]) < 1e-9) {
                return 0;
            }
            det *= matrix[i][i];
            for (int j = i + 1; j < n; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i; k < n; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }
        return Math.abs(det);
    }
}
