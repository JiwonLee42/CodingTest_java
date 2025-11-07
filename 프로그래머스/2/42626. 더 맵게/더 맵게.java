import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s : scoville){
            q.add(s);
        }
        while(!q.isEmpty()){
            if(q.peek() >= K) {
                break;
            }
            int a,b;
            a = q.poll();
            if(!q.isEmpty()){
              b = q.poll();
            } else {
                return -1;
            }
            q.add(a + b*2);
            answer++;
        }
        return answer;
    }
}