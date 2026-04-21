//https://leetcode.com/problems/word-search-ii
import java.util.*;

public class WordSearchII212 {
    public static void main(String[] args) {
        WordSearchII212 solution = new WordSearchII212();
        char[][] board1 = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words1 = {"oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(board1, words1)); // ["eat","oath"]

        char[][] board2 = {{'a', 'b'}, {'c', 'd'}};
        String[] words2 = {"abcb"};
        System.out.println(solution.findWords(board2, words2)); // []
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }

        List<String> result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }

    private void dfs(char[][] board, int x, int y, TrieNode node, List<String> result) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '#') {
            return;
        }

        char ch = board[x][y];
        TrieNode next = node.children[ch - 'a'];
        if (next == null) {
            return;
        }

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[x][y] = '#';
        dfs(board, x + 1, y, next, result);
        dfs(board, x - 1, y, next, result);
        dfs(board, x, y + 1, next, result);
        dfs(board, x, y - 1, next, result);
        board[x][y] = ch;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
