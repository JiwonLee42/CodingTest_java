import java.util.*;
class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n,m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean [][] visited = new boolean[n][m];
        int answer = bfs(0,0,visited,maps);
        return answer;
    }
    
    public int bfs(int x, int y,boolean[][] visited,int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        // x, y, 거리 저장
        q.add(new int[]{x,y,1});
        // 시작 지점은 방문처리
        visited[x][y] = true; 
        while(!q.isEmpty()){
            // 현재 상태 처리
            int [] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];
            int dist = cur[2];
            
            // 범위 검사 조건: 도착했을 시
            if(curx == n - 1 && cury == m - 1) {
                return dist;
            }
            
            // 4방향으로 탐색
            for(int i = 0; i < 4;i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                
                if (nx >= 0 && ny>=0 && nx<n && ny<m && maps[nx][ny] == 1 && !visited[nx][ny]){
                    // 방문 처리
                    visited[nx][ny] = true;
                    // 상태 전이
                    q.add(new int[]{nx,ny,dist+1});
                } 
            }            
        }
        return -1;
    }
}