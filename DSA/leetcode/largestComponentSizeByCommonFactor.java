// You are given an integer array of unique positive integers nums. Consider the following graph:

// There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
// There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
// Return the size of the largest connected component in the graph.
public class largestComponentSizeByCommonFactor {
    public class UnionFind {
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
    public static void main(String[] args) {
        largestComponentSizeByCommonFactor solution = new largestComponentSizeByCommonFactor();
        int[] nums = {4, 6, 15, 35};
        int result = solution.largestComponentSize(nums);
        System.out.println(result); // Output: 4
    }
    public int largestComponentSize(int[] nums) {
        int maxNum = Arrays.stream(nums).max().orElse(0);
        UnionFind uf = new UnionFind(maxNum + 1);
        
        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    uf.union(num, factor);
                    uf.union(num, num / factor);
                }
            }
        }

        Map<Integer, Integer> componentSize = new HashMap<>();
        int largestSize = 0;
        for (int num : nums) {
            int root = uf.find(num);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
            largestSize = Math.max(largestSize, componentSize.get(root));
        }
        
        return largestSize;
    }
}
