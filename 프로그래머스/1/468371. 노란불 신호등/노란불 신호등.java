import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        // 정전, 1초부터 노란불이 되면 정전
        // 모두 노란불 13초에
        // 모두 노란불되는 가장 빠른 시각, 노란불 경우 없으면 -1
        // 초,노,빨 있으면 가장 빨리되는?
        // 노란불 켜지는 구간이 3,5 3,4 2,3 이렇게 있으면 이게 7,7,5 마다 반복이니까
        // 이거의 최소공배수만큼?
        // 다 겹쳐야하는거니까 7 * 7 * 5 만큼 반복을 해가지고, 이중에 있는게 보기
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