import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> isFinished = new HashMap<>();
        for(String p : participant) {
            isFinished.put(p,isFinished.getOrDefault(p,0) + 1);
        }
        
        for(String c : completion) {
            isFinished.put(c, isFinished.get(c)-1);
        }
        for(String k : isFinished.keySet()){
            if(isFinished.get(k) > 0) {
                answer = k;
            }
        }
        return answer;
    }
}