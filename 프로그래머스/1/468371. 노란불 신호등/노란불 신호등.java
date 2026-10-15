import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int[] total = new int[signals.length];
        for(int i = 0; i < total.length;i++){
            total[i] += signals[i][0] + signals[i][1] + signals[i][2];
        }
        // 최소공배수 구하기
        int l = 1;
        while (true) {
            boolean ok = true;
            for (int p : total) {
                if (l % p != 0) { ok = false; break; }
            }   
            if (ok) break;
            l++;
        }
        
        for(int i = 1; i <= l;i++){
            // 시간마다 노란불이 되었는지 체크
            boolean isYellow = true;
            for(int j = 0; j < signals.length;j++){
                int green = signals[j][0], yellow = signals[j][1], red = signals[j][2];
                int start = green + 1;
                int end = green + yellow;
                int round = i % total[j];
                if(round < start || round > end) isYellow = false;
            }
            if(isYellow) return i;
        }
        
        return -1;
    }
}