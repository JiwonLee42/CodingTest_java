import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        // 큐에 넣고, 빈도수 기준으로 정렬
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
        );

        // 빈도수 k개만 남겨두고 삭제 
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int [] answers = new int[k];
        for(int i = 0; i < k; i++) {
            answers[i] = pq.poll().getKey();
        }

        return answers;
    }
}