//https://leetcode.com/problems/word-search
public class WordSearch79 {
    public static void main(String[] args) {
        WordSearch79 solution = new WordSearch79();
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(board1, "ABCCED")); // true
        System.out.println(solution.exist(board1, "SEE")); // true
        System.out.println(solution.exist(board1, "ABCB")); // false
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        visited[x][y] = true;
        boolean found = dfs(board, word, visited, x + 1, y, index + 1) ||
                        dfs(board, word, visited, x - 1, y, index + 1) ||
                        dfs(board, word, visited, x, y + 1, index + 1) ||
                        dfs(board, word, visited, x, y - 1, index + 1);
        visited[x][y] = false;
        return found;
    }
}