import java.util.*;
import java.io.*;

class Main {
    static int answer;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());
            arr[i] = k;
        }

        if(n == 3){
            answer = Math.max(arr[1] + arr[2], Math.max(arr[0] + arr[1], arr[0] + arr[2]));
        }
        else if(1 < n && n < 3) {
            answer = arr[0] + arr[1];
        }
        else if(n == 1){
            answer = arr[0];
        }
        else {
            dp = new int[n];
            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];
            // 1,2번째 마셨을 때, 1,3번째 마셨을 때, 2,3번째 마셨을 때
            dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
    
            // i번째만 마신 경우 vs i번째를 안마신 경우 vs i번째, i-1번째 마신 경우
            for(int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i-2] + arr[i], 
                             Math.max(dp[i-1], dp[i-3] + arr[i] + arr[i-1]));
            }
            answer = dp[n-1];
         }

        System.out.println(answer);
    }
}