class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for (int h = citations.length;h>=0;h--){
            if (isValid(citations, h)){
                answer = h;
                break;
            } 
        }
        return answer;
    }
    
        private boolean isValid(int[] cList, int h) {
            int count = 0;
            for (int index : cList) {
                if(index >= h){
                    count++;
                }
            }
            return count >= h;
        }
}