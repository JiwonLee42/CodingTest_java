import java.util.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken()) - 1;
        int target2 = Integer.parseInt(st.nextToken()) - 1;
        int count = Integer.parseInt(br.readLine());

        // 사람 인접리스트로 만들기
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < count; i++){
            StringTokenizer stz = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(stz.nextToken());
            int p2 = Integer.parseInt(stz.nextToken());
            graph[p1-1].add(p2-1);
            graph[p2-1].add(p1-1);
        }

        visited = new boolean[n];

        int depth = 0;
        dfs(target1,target2,depth);

        System.out.println(answer);
        
    }

    public static void dfs(int node, int target, int depth){
        if (node == target){
            answer = depth;
            return;
        }
        visited[node] = true;
        for(int nextNode : graph[node]){
            if(!visited[nextNode]){
                dfs(nextNode,target,depth+1);
            }
        }
    }
}



