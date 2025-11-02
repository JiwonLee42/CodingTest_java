import java.util.*;

class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        int sum = 0;
        int answer = 0;
        dfs(0,numbers,sum,target);
        answer = count;
        return answer;
        
    }
    public void dfs(int index,int[] numbers,int sum,int target){
        if(index == numbers.length){
           if(sum == target) count++;
           return;
        }
        dfs(index+1,numbers,sum-numbers[index],target);
        dfs(index+1,numbers,sum+numbers[index],target);
    }
}
