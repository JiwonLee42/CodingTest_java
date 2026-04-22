import java.util.*;


class Solution {
    public String solution(int n, int k, String[] cmd) {
        int current = k;
        // 삭제된 노드 보관하는 스택
        Stack<Integer> deleted = new Stack<>();
        // 해당 인덱스의 이전 노드, 첫 번재 인덱스는 이전 노드 없으므로 -1이 들어감
        int[] prev = new int[n];
        // 해당 인덱스의 이후 노드 
        int[] next = new int[n];
        // 삭제 여부를 관리하는 배열
        boolean[] removed = new boolean[n];
        
        // 초기화
        for(int i = 0; i < n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        // 마지막 인덱스는 이후 노드가 없으므로 -1을 넣어줌
        next[n - 1] = -1;
        
        int x;
        
        for(String s: cmd){
            String[] command = s.split(" ");
            switch(command[0]){
                case "U":
                    x = Integer.parseInt(command[1]);
                    for(int i = 0; i < x;i++) current = prev[current];
                    break;
                case "D":
                    x = Integer.parseInt(command[1]);
                    for(int i = 0; i < x;i++) current = next[current];
                    break;
                case "C":
                    deleted.push(current);
                    removed[current] = true;
                    if(prev[current]!= -1) next[prev[current]] = next[current];
                    if(next[current]!=-1) prev[next[current]] = prev[current];
                    current = (next[current]!=-1) ? next[current] : prev[current];
                    break;
                case "Z":
                    if(!deleted.isEmpty()){
                        int restored = deleted.pop();
                        removed[restored] = false;
                        // 복구 시에는 양옆이 restored를 가리키게 해야 함
                        // 이전 인덱스의 next를 복구하려는 인덱스로 설정
                        if(prev[restored]!=-1) next[prev[restored]] = restored;
                        // 이전 인덱스의 prev를 복구하려는 인덱스로 설정
                        if(next[restored]!=-1) prev[next[restored]] = restored;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
            
            for(boolean r: removed){
                sb.append(r ? "X" : "O");
            }
        
        return sb.toString();
    }
}
