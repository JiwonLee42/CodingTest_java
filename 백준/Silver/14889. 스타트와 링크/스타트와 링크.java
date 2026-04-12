import java.util.*;
import java.io.*;

class Main {
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] strength = new int[n][n];
        
        StringTokenizer st; 
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                strength[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean[] visited = new boolean[n];

        matchTeam(strength, 0, visited, 0);
        System.out.println(answer);
    }

    // startTeam만 고르는 방식
    static void matchTeam(int[][] arr, int start, boolean[] visited, int count){

        if(count == arr.length / 2){
            int startSum = 0;
            int linkSum = 0;

            for(int i = 0; i < arr.length; i++){
                for(int j = i + 1; j < arr.length; j++){
                    if(visited[i] && visited[j]){
                        startSum += arr[i][j] + arr[j][i];
                    }
                    else if(!visited[i] && !visited[j]){
                        linkSum += arr[i][j] + arr[j][i];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(startSum - linkSum));
            return;
        }

        for(int i = start; i < arr.length; i++){
            visited[i] = true;
            matchTeam(arr, i + 1, visited, count + 1);
            // 백트래킹
            visited[i] = false;
        }
    }
}