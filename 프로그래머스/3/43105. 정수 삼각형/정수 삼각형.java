import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[] dp = new int[n+1];
        dp[0] = triangle[0][0];
        for(int i = 1;i<n;i++){
            int[] line = new int[i+1];
            for(int j = 0; j<=i;j++){
                // 이전 경로 중 최대 + 현재칸값
                if(j==0){
                    line[j] = dp[j] + triangle[i][j];
                }
                else if(j==i) {
                    line[j] = dp[j-1] + triangle[i][j];
                }
                else{
                    line[j] = Math.max(dp[j],dp[j-1]) + triangle[i][j];
                }
            }
            dp = line;
        }
        for(int x : dp){
            answer = Math.max(answer, x);
        }
        return answer;
    }
}