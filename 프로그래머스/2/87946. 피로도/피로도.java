class Solution {
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, new boolean[dungeons.length], 0);
        return answer;
    }

    void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        if (count > answer) answer = count;
        if (answer == dungeons.length) return;   // 이미 전탐 성공, 가지치기

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}