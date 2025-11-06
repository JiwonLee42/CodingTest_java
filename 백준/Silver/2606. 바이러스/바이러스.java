import java.util.*;
import java.io.*;


class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                graph[i][j] = 0;
            }
        }
        
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a-1][b-1] = 1;
            graph[b-1][a-1] = 1;
        }

        boolean[] visited = new boolean[n];
        
        dfs(0,graph,visited);  
        
        
        System.out.println(answer-1);
    }
    public static void dfs(int current, int[][] graph, boolean[] visited) {
        visited[current] = true;
        answer++;
        for(int i = 0; i < graph.length;i++) {
            if(graph[current][i] == 1 && !visited[i]){
                dfs(i,graph,visited);
            }
        }
    }
}