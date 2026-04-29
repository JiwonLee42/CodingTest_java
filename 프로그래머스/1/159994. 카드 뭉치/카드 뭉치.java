import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> cardsq1 = new ArrayDeque<>();
        Queue<String> cardsq2 = new ArrayDeque<>();
        Queue<String> goalq = new ArrayDeque<>();
        
        for(String s: cards1){
            cardsq1.add(s);
        }
        for(String s: cards2){
            cardsq2.add(s);
        }
        for(String s: goal){
            goalq.add(s);
        }
        
        for(int i = 0; i < goal.length; i++){
            if(!cardsq1.isEmpty() && cardsq1.peek().equals(goal[i])){
                cardsq1.poll();
                goalq.poll();
            } else if (!cardsq2.isEmpty() && cardsq2.peek().equals(goal[i])){
                cardsq2.poll();
                goalq.poll();
            }
        }
        
        if(goalq.isEmpty()) answer = "Yes";
        else answer = "No";
        
        return answer;
    }
}