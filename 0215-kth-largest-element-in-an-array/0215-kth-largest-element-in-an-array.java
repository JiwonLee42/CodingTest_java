import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<nums.length; i++) {
            pq.offer(nums[i]);
        }
        for(int j = 0; j<k;j++){
            if(!pq.isEmpty()){
                answer = pq.poll();
            }
        }
        return answer;
    }
}