import java.util.*;
import java.io.*;

class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 큰 값으로 지정 및 초기화 
        int INF = 1_000_000_000;
        dp = new int[c+100];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int i = 0; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            for(int w = weight; w < dp.length;w++){
                dp[w] = Math.min(dp[w], dp[w - weight] + value);
            }
        }

        int answer = INF;
        for (int i = c; i < dp.length; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}