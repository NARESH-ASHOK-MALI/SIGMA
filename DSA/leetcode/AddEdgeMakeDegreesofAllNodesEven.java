// There is an undirected graph consisting of n nodes numbered from 1 to n. You are given the integer n and a 2D array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi. The graph can be disconnected.

// You can add at most two additional edges (possibly none) to this graph so that there are no repeated edges and no self-loops.

// Return true if it is possible to make the degree of each node in the graph even, otherwise return false.

// The degree of a node is the number of edges connected to it.
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddEdgeMakeDegreesofAllNodesEven {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Set<Integer>[] adj = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new HashSet<>();
        }
        
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }
        
        List<Integer> oddNodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (adj[i].size() % 2 != 0) {
                oddNodes.add(i);
            }
        }
        
        if (oddNodes.size() == 0) {
            return true;
        } else if (oddNodes.size() == 2) {
            int a = oddNodes.get(0), b = oddNodes.get(1);
            if (!adj[a].contains(b)) return true;
            
            // If a and b are already connected, we can connect them to a common even node
            for (int i = 1; i <= n; i++) {
                if (i != a && i != b && !adj[a].contains(i) && !adj[b].contains(i)) {
                    return true;
                }
            }
            return false;
        } else if (oddNodes.size() == 4) {
            int a = oddNodes.get(0), b = oddNodes.get(1), c = oddNodes.get(2), d = oddNodes.get(3);
            
            // Check 3 different ways to pair up the 4 odd nodes
            if (!adj[a].contains(b) && !adj[c].contains(d)) return true;
            if (!adj[a].contains(c) && !adj[b].contains(d)) return true;
            if (!adj[a].contains(d) && !adj[b].contains(c)) return true;
            
            return false;
        }
        
        return false; // More than 4 odd degree nodes cannot be fixed with at most 2 edges
    }
}
