// You are given an integer n indicating the number of people in a network. Each person is labeled from 0 to n - 1.

// You are also given a 0-indexed 2D integer array restrictions, where restrictions[i] = [xi, yi] means that person xi and person yi cannot become friends, either directly or indirectly through other people.

// Initially, no one is friends with each other. You are given a list of friend requests as a 0-indexed 2D integer array requests, where requests[j] = [uj, vj] is a friend request between person uj and person vj.

// A friend request is successful if uj and vj can be friends. Each friend request is processed in the given order (i.e., requests[j] occurs before requests[j + 1]), and upon a successful request, uj and vj become direct friends for all future friend requests.

// Return a boolean array result, where each result[j] is true if the jth friend request is successful or false if it is not.

// Note: If uj and vj are already direct friends, the request is still successful.
public class processRestrictedfriendRequests {
    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
    
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind uf = new UnionFind(n);
        boolean[] result = new boolean[requests.length];
        
        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];
            int rootU = uf.find(u);
            int rootV = uf.find(v);
            
            boolean canBeFriends = true;
            for (int[] restriction : restrictions) {
                int x = restriction[0];
                int y = restriction[1];
                if ((uf.find(x) == rootU && uf.find(y) == rootV) || (uf.find(x) == rootV && uf.find(y) == rootU)) {
                    canBeFriends = false;
                    break;
                }
            }
            
            if (canBeFriends) {
                uf.union(rootU, rootV);
                result[i] = true;
            } else {
                result[i] = false;
            }
        }
        
        return result;
    }
}
