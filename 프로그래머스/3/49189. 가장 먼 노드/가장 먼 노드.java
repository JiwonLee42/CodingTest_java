import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int m = edge.length;
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[n+1];
        queue.offer(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    // 현재 거리 + 1에 다음 도착지의 거리 저장
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }
        }
        
        int maxD = distance[1];
        for(int i = 1; i <= n;i++){
            if(distance[i] > maxD){
                maxD = distance[i];
            }
        }
        
        for(int dis : distance){
            if(dis == maxD)
                answer++;
        }
        
        return answer;
    }
}