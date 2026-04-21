import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 가장 아래 칸부터 쌓여있음 멈춘 위치에서 위에 있는 인형을 집어 올리고 바구니에 쌓이게 됨
        // 크레인 좌우로 움직일 수 있음 
        // 같은 모양의 인형 두개가 쌓이면 바구니에서 사라짐
        // ㅈ차원 배열 보드와 크레인을 작동시킨 위치 , 터뜨려져 사라진 인형의 개수
        
        // 2차원 배열에서 
        // board[0].length
        // 4,0 4,1 그니까 n-1,0 계열부터 넣고, n-2,0 계열부터 다음에 넣기 
        // 그러면 n-1,0 n-2, 1 이렇게 순서대로 넣기
        int n = board[0].length;
        Stack<Integer> picked = new Stack<>();
        
        // 초기화 
        List<Stack<Integer>> stacks = new ArrayList<>();
        for(int i = 0; i < n;i++){
            Stack<Integer> stack = new Stack<>();
            for(int j = n-1; j >= 0; j--){
                int current = board[j][i];
                if(current == 0){
                    continue;
                }
                stack.push(current);
            }
            stacks.add(stack);
        }
        
        // 움직일 때마다 stack에 넣기
        for(int m : moves){
             // 가장 위에있는거랑 지금 넣을거랑 같으면 둘다 삭제
            if(!picked.isEmpty() && !stacks.get(m-1).isEmpty()){
                if(stacks.get(m-1).peek() == picked.peek()){
                    answer+=2;
                    stacks.get(m-1).pop();
                    picked.pop();
                } else{
                    // 같지 않으면 picked에 넣기 
                    picked.push(stacks.get(m-1).pop());
                }
            } else if (!stacks.get(m-1).isEmpty()){
                picked.push(stacks.get(m-1).pop());
            } else if (stacks.get(m-1).isEmpty()){
                continue;
            }
        }
        
        return answer;
    }
}