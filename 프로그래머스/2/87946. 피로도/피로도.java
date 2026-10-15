import java.util.*;

class Solution {
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        max = 0;
        boolean[] visited = new boolean[dungeons.length];
        dfs(visited,dungeons,k,max);
        return max;
    }
    
    void dfs(boolean [] visited, int[][] arr, int hp, int count){
        for(int i = 0; i < arr.length;i++){
            if(!visited[i] && arr[i][0] <= hp){
                visited[i] = true;
                hp-=arr[i][1];
                count++;
                if (count > max) max = count;
                dfs(visited,arr,hp,count);
                visited[i] = false; 
                count--;
                hp+=arr[i][1];
            }
        }
    }
}
