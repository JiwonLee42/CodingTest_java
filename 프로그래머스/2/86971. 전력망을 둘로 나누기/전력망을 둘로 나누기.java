import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 인접 리스트 생성
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] w : wires) {
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }

        for (int[] w : wires) {
            visited = new boolean[n + 1];

            int count = dfs(w[0], w[0], w[1]); 
            int diff = Math.abs(n - 2 * count);
            answer = Math.min(answer, diff);
        }
        return answer;
    }

    static int dfs(int node, int cutA, int cutB) {
        visited[node] = true;
        int cnt = 1;
        for (int next : graph[node]) {
            // 끊었던 간선은 통과
            if (!visited[next] && !((node == cutA && next == cutB) || (node == cutB && next == cutA))) {
                cnt += dfs(next, cutA, cutB);
            }
        }
        return cnt;
    }
}