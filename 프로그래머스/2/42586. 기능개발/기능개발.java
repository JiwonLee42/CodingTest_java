import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int n = progresses.length;
        
        for(int i = 0; i < n;i++){
            int days;
            int leftDays = 100 - progresses[i];
            // 남은 날수를 하루에 작업가능한 날수로 나누기. 나누어떨어지지 않으면 + 1일
            if(leftDays % speeds[i] == 0){
                days = leftDays / speeds[i];
            } else {
                days = leftDays / speeds[i] + 1;
            }
            q.add(days);
        }
        while(!q.isEmpty()){
            int count = 1;
            int job = q.poll();
            // 작업완료된 기능보다 더 빨리 아니면 같은날에 배포가 가능하다면 같이 poll
            while(!q.isEmpty() && q.peek() <= job){
                q.poll();
                count++;
            }
            list.add(count);
        }
        
        answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}
