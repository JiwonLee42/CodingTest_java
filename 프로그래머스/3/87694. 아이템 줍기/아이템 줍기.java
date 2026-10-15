import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[102][102];
        // 2배 하기
        for(int i = 0; i < rectangle.length;i++){
            for(int j = 0; j < rectangle[i].length;j++){
                rectangle[i][j]*=2;
            }
        }
        characterX*=2;
        characterY*=2;
        itemX*=2;
        itemY*=2;
        
        for(int i = 0; i < rectangle.length;i++){
            int[] cur = rectangle[i];
            // y1 고정 
            for(int k = cur[0]; k <= cur[2];k++){
                if(isInside(rectangle,k,cur[1])) continue;
                map[k][cur[1]] = 1;
            }
            // y2 고정
            for(int k = cur[0]; k <= cur[2];k++){
                if(isInside(rectangle,k,cur[3])) continue;
                map[k][cur[3]] = 1;
            }
            // x1 고정
            for(int k = cur[1]; k <= cur[3];k++){
                if(isInside(rectangle,cur[0],k)) continue;
                map[cur[0]][k] = 1;
            }
            // x2 고정
            for(int k = cur[1]; k <= cur[3];k++){
                if(isInside(rectangle,cur[2],k)) continue;
                map[cur[2]][k] = 1;
            }
        }
        
        // BFS 
        int [] dx = {1,0,-1,0};
        int [] dy = {0,1,0,-1};
        Queue<int []> q = new ArrayDeque<>();
        q.offer(new int[]{characterX,characterY});
        int[][] dist = new int[102][102];
        dist[characterX][characterY] = 1;
        int n = 102;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int x = cur[0],y = cur[1];
            if(x == itemX && y == itemY) {
                answer = (dist[x][y]-1)/2;
            }
            for(int d = 0; d < 4;d++){
                int nx = x + dx[d], ny = y + dy[d];
                if(nx < 0 || ny < 0 || ny > n || nx > n) continue;
                if(map[nx][ny] == 0) continue;
                if(dist[nx][ny]!=0) continue;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx,ny});
            }
        }
        return answer;
    }
    
    public boolean isInside(int[][] rectangle,int x, int y){
         for(int [] rec : rectangle){
             if(x > rec[0] && x < rec[2] && y > rec[1] && y < rec[3]) return true;
         }
        return false;
    }
    
}