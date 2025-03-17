import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>(); // [과제 점수, 남은 시간]
        int score = 0;
        int currentScore = 0;
        int currentLeft = 0;

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");

            if (arr[0].equals("1")) { // 새로운 과제 추가
                int newScore = Integer.parseInt(arr[1]);
                int newTime = Integer.parseInt(arr[2]);

                if (currentLeft > 0) { // 현재 진행 중인 과제가 있다면 스택에 저장
                    stack.push(new int[]{currentScore, currentLeft});
                }

                currentScore = newScore;
                currentLeft = newTime;
            }

            // 현재 과제 진행
            if (currentLeft > 0) {
                currentLeft--;

                if (currentLeft == 0) { // 과제 완료
                    score += currentScore;
                    if (!stack.isEmpty()) { // 이전 과제 복구
                        int[] prev = stack.pop();
                        currentScore = prev[0];
                        currentLeft = prev[1];
                    }
                }
            }
        }

        System.out.println(score);
    }
}
