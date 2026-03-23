class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,0,target);
        return count;
    }
    
    public static void dfs(int[] numbers, int index, int sum, int target){
        // 종료 조건 설정
        if (index == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }
        
        dfs(numbers, index+1, sum + numbers[index], target);
        dfs(numbers, index+1, sum - numbers[index], target);
    }
}