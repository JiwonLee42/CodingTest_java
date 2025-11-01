import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        visitDungeon(k,dungeons,visited,0);
        return answer;
    }
    
    public static void visitDungeon(int k,int[][] dungeons, boolean[] visited, int count){
        answer = Math.max(answer,count);
            for(int next = 0; next < dungeons.length;next++){
                int minHp = dungeons[next][0];
                int usedHp = dungeons[next][1];
                if(!visited[next] && k >= minHp){
                    visited[next] = true;
                    visitDungeon(k-usedHp,dungeons,visited,count+1);
                    visited[next] = false;
                }
            }
   }
}