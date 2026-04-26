class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curGas = 0;
        int n = gas.length;
        int start = 0;
        int totalGas = 0;
        for(int i = 0 ; i < n;i++){
            curGas = gas[i] + curGas - cost[i];
            totalGas+= gas[i] - cost[i];
            if(curGas < 0 && i!=n-1) {
                // 실패했으므로 초기화
                curGas = 0;
                start = i+1;
            }
        }
        int answer = 0;
        if(totalGas < 0) answer = -1;
        else answer = start;
        
        return answer;
    }
}
