import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        for(int i = 0;i<commands.length;i++){
            int s = commands[i][0] - 1;
            int e = commands[i][1];
            int[] list = Arrays.copyOfRange(array,s,e);
            int k = commands[i][2];
            Arrays.sort(list);
            answer[i] = list[k-1];
        }
        return answer;
    }
}