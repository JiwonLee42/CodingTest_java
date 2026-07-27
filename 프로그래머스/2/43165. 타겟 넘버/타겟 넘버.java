class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(target,0,0,numbers);
        return answer;
    }
    
    static void dfs(int target,int curIndex, int curSum, int[] numbers){
        if(curIndex == numbers.length) {
            if(curSum == target) answer++;
            return;
        }
        dfs(target,curIndex+1,curSum-numbers[curIndex],numbers);
        dfs(target,curIndex+1,curSum+numbers[curIndex],numbers);
        
    }
}