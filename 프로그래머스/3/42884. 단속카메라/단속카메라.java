import java.util.Arrays;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int camP = -30000;
        int camCount = 0;
        for(int i = 0;i<routes.length;i++){
            if(routes[i][0] > camP) {
                camP = routes[i][1];
                camCount++;
            }
        }
        answer = camCount;
        return answer;
    }
}

