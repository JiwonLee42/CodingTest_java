import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int n = people.length;
        
        // 가장 가벼운 사람 선택하고, 가장 무거운 사람과 합쳐서 limit이 되면 선택하고 아니면 이동
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            answer++;
        }
        
        return answer;
    }
}