import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int e = costs.length;
        List<int[]>[] graph = new List[n+1];
        for(int i = 0;i<n;i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < e;i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int w = costs[i][2];
            graph[a].add(new int[]{b,w});
            graph[b].add(new int[]{a,w});
        }
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{1,0});
        int total = 0; // 비용
        int count = 0; // 개수
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            // 초기 위치, 비용
            int node = cur[0], cost = cur[1];
            if(visited[node]) continue;
            visited[node] = true;
            total+=cost;
            count++;
            if(count == n) break;
            for(int[] next : graph[node]){
                // 방문 안했으면 넣기
                // 가장 적은 비용 순으로 들어감
                if(!visited[next[0]]){
                    pq.offer(new int[]{next[0], next[1]});
                }
            }
        }
        
        return total;
    }
}