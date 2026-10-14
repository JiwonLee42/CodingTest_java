import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        int n = maps.length, m = maps[0].length();
        int[][] newMaps = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                newMaps[i][j] = (c == 'X') ? 0 : c - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMaps[i][j] == 0 || visited[i][j]) continue;
                list.add(bfs(newMaps, visited, i, j));
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int k = 0; k < answer.length; k++) answer[k] = list.get(k);
        return answer;
    }

    int bfs(int[][] arr, boolean[][] visited, int sx, int sy) {
        int n = arr.length, m = arr[0].length;
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            sum += arr[cur[0]][cur[1]];
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (arr[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return sum;
    }
}