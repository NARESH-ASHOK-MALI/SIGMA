// A game on an undirected graph is played by two players, Mouse and Cat, who alternate turns.

// The graph is given as follows: graph[a] is a list of all nodes b such that ab is an edge of the graph.

// The mouse starts at node 1 and goes first, the cat starts at node 2 and goes second, and there is a hole at node 0.

// During each player's turn, they must travel along one edge of the graph that meets where they are.  For example, if the Mouse is at node 1, it must travel to any node in graph[1].

// Additionally, it is not allowed for the Cat to travel to the Hole (node 0).

// Then, the game can end in three ways:

// If ever the Cat occupies the same node as the Mouse, the Cat wins.
// If ever the Mouse reaches the Hole, the Mouse wins.
// If ever a position is repeated (i.e., the players are in the same position as a previous turn, and it is the same player's turn to move), the game is a draw.
// Given a graph, and assuming both players play optimally, return

// 1 if the mouse wins the game,
// 2 if the cat wins the game, or
// 0 if the game is a draw.
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Queue;

public class CatAndMouseGame {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        // color[m][c][t]: 0 unknown, 1 mouse win, 2 cat win; t=0 mouse move, t=1 cat move
        int[][][] color = new int[n][n][2];
        int[][][] degree = new int[n][n][2];

        for (int m = 0; m < n; m++) {
            for (int c = 0; c < n; c++) {
                degree[m][c][0] = graph[m].length;
                // cat cannot move to 0
                int d = 0;
                for (int x : graph[c]) if (x != 0) d++;
                degree[m][c][1] = d;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        // initialize terminal states
        for (int i = 0; i < n; i++) {
            // mouse at hole -> mouse wins
            color[0][i][0] = color[0][i][1] = 1;
            q.add(new int[]{0, i, 0, 1});
            q.add(new int[]{0, i, 1, 1});
            // cat catches mouse -> cat wins
            color[i][i][0] = color[i][i][1] = 2;
            q.add(new int[]{i, i, 0, 2});
            q.add(new int[]{i, i, 1, 2});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int m = cur[0], c = cur[1], turn = cur[2], res = cur[3];
            // find all predecessor states that can move to (m,c,turn)
            if (turn == 0) {
                // current is mouse to move, so predecessor was cat move (prevTurn=1)
                for (int pc : graph[c]) {
                    if (pc == 0) continue; // cat can't be at hole
                    int pm = m;
                    int prevTurn = 1;
                    if (color[pm][pc][prevTurn] != 0) continue;
                    if (res == 2) {
                        // current is cat win; if prevTurn==cat, cat will choose this move -> prev is cat win
                        color[pm][pc][prevTurn] = 2;
                        q.add(new int[]{pm, pc, prevTurn, 2});
                    } else {
                        // current is mouse win; cat will avoid moves to mouse win
                        degree[pm][pc][prevTurn]--;
                        if (degree[pm][pc][prevTurn] == 0) {
                            color[pm][pc][prevTurn] = 1; // mouse wins
                            q.add(new int[]{pm, pc, prevTurn, 1});
                        }
                    }
                }
            } else {
                // turn == 1, current is cat to move, predecessor was mouse move (prevTurn=0)
                for (int pm : graph[m]) {
                    int pc = c;
                    int prevTurn = 0;
                    if (color[pm][pc][prevTurn] != 0) continue;
                    if (res == 1) {
                        // current is mouse win; mouse will choose to move here
                        color[pm][pc][prevTurn] = 1;
                        q.add(new int[]{pm, pc, prevTurn, 1});
                    } else {
                        // current is cat win; mouse will avoid moves to cat win
                        degree[pm][pc][prevTurn]--;
                        if (degree[pm][pc][prevTurn] == 0) {
                            color[pm][pc][prevTurn] = 2;
                            q.add(new int[]{pm, pc, prevTurn, 2});
                        }
                    }
                }
            }
        }

        int ans = color[1][2][0];
        return ans == 0 ? 0 : ans;
    }
}