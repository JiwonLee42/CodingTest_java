import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int k : works){
            pq.add(k);
        }
        
        while(n > 0){
            int current = pq.poll();
            if (current == 0) break;
            pq.add(current - 1);
            n--;
        }
        
        while(!pq.isEmpty()){
            long k = pq.poll();
            answer += k * k;
        }
        
        return answer;
    }
}