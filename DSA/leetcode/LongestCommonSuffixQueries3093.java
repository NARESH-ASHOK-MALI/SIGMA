// You are given two arrays of strings wordsContainer and wordsQuery.

// For each wordsQuery[i], you need to find a string from wordsContainer that has the longest common suffix with wordsQuery[i]. If there are two or more strings in wordsContainer that share the longest common suffix, find the string that is the smallest in length. If there are two or more such strings that have the same smallest length, find the one that occurred earlier in wordsContainer.

// Return an array of integers ans, where ans[i] is the index of the string in wordsContainer that has the longest common suffix with wordsQuery[i].
public class LongestCommonSuffixQueries3093 {
    // Optimized: build a reversed Trie of wordsContainer. At each Trie node
    // store the best candidate index for that suffix depth using tie-breakers:
    // smallest word length, then earliest index. For a query, walk reversed
    // characters as far as possible and return the stored index at that node.
    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int best = -1;
    }

    public int[] longestCommonSuffixQueries(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        int m = wordsQuery.length;
        TrieNode root = new TrieNode();

        // Insert each container word in reversed order; update best at each node
        for (int i = 0; i < n; i++) {
            String w = wordsContainer[i];
            // update root (depth 0) candidate
            updateBest(root, wordsContainer, i);
            TrieNode node = root;
            for (int k = w.length() - 1; k >= 0; k--) {
                char c = w.charAt(k);
                int ci = c - 'a';
                if (ci < 0 || ci >= 26) {
                    // skip non-lowercase characters (keeps behavior simple)
                    break;
                }
                if (node.next[ci] == null) node.next[ci] = new TrieNode();
                node = node.next[ci];
                updateBest(node, wordsContainer, i);
            }
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            TrieNode node = root;
            String q = wordsQuery[i];
            for (int k = q.length() - 1; k >= 0; k--) {
                char c = q.charAt(k);
                int ci = c - 'a';
                if (ci < 0 || ci >= 26 || node.next[ci] == null) break;
                node = node.next[ci];
            }
            ans[i] = node.best;
        }
        return ans;
    }

    private void updateBest(TrieNode node, String[] wordsContainer, int candidate) {
        int cur = node.best;
        if (cur == -1) {
            node.best = candidate;
            return;
        }
        String a = wordsContainer[cur];
        String b = wordsContainer[candidate];
        if (b.length() < a.length() || (b.length() == a.length() && candidate < cur)) {
            node.best = candidate;
        }
    }
}
