import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int MOD = 1000000007;

        for (int i = 0; i < puddles.length; i++) {
            visited[puddles[i][0]-1][puddles[i][1]-1] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = (i > 0) ? dp[i-1][j] : 0;
                int left = (j > 0) ? dp[i][j-1] : 0;

                if (!visited[i][j]) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = (up + left) % MOD;
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}