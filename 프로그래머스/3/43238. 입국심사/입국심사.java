/**
* 이분 탐색 문제
* check 안에서 현재 시간이면 처리할 수 있는 사람을 계산하고,
* n명을 처리 가능하다면 true를 반환하는 식 
*/
import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = -1;
        long lo = 0;
        Arrays.sort(times);
        long hi = (long) times[times.length - 1] * n;
        
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if(check(mid,n,times)){
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return answer;
    }
    
            boolean check(long time, int n, int[] times){
            long cnt = 0;
            for(int i = 0; i < times.length; i++){
                long cur = times[i];
                cnt+=time / cur;
            }
            // n명 이상 처리하면 OK
            return cnt >= n;
        }
    
}