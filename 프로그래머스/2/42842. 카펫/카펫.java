class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i <= brown/2;i++){
            for(int j = 1; j <= brown/2;j++){
                if(i*j - yellow == brown && yellow % (i -2) == 0 && yellow % (j-2) == 0){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}