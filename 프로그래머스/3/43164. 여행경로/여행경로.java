import java.util.*;

class Solution {
    static List<String> answerStr = new ArrayList<>();
    static boolean finished = false;
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        // 도착지 기준 정렬
        Arrays.sort(tickets,(a,b) -> a[1].compareTo(b[1]));
        
        // 시작 노드는 무조건 인천
        String startNode = "ICN";
        // 시작 노드 추가
        answerStr.add(startNode);
        int count = 0;
        dfs(startNode, tickets.length, count, tickets, visited);
        return answerStr.toArray(new String[0]);
    }
    
    public static void dfs(String node, int ticketCount, int count, String[][] tickets, boolean[] visited){
        // 티켓을 다 사용하면 종료
        if(finished) return;
        if(ticketCount == count){
            finished = true;
            return;
        }
        for(int i = 0; i < ticketCount; i++){
            if (!visited[i]){
                // 사용 안한 티켓 중에 출발지가 똑같은 것이 있으면 사용
                if (tickets[i][0].equals(node)) {
                      // 티켓 사용 처리
                      visited[i] = true;
                      String next = tickets[i][1];
                      answerStr.add(next);
                      dfs(next, ticketCount, count+1, tickets, visited);
                      if (finished) return;
                      visited[i] = false;
                      answerStr.remove(answerStr.size() - 1);
                }
            }
        }
    }
}