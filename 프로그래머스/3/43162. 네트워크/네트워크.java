import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean [] isVisited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(isVisited[i]) continue; // 방문했으면 패스
            visit(i,computers,isVisited); 
            answer++; 
        }
        return answer;
    }
    
    private void visit(int computer, int[][] computers, boolean[] isVisited){
        Stack<Integer> stack = new Stack<>();
        stack.push(computer);
        while(!stack.isEmpty()) {
            int c = stack.pop();
            if(isVisited[c]) continue;   
            isVisited[c] = true; // 방문 처리
               for(int next = 0; next < computers[c].length;next++){
                   if (computers[c][next] == 0) continue; // 연결 안되어있으면 패스
                   stack.push(next); // 연결되어있으면 stack에 push
               }
            }
       }
    }