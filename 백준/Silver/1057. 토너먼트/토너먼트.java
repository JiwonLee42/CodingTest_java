import java.util.*;
import java.io.*;

class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> playerList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            playerList.add(i);
        }

        dfs(playerList, a, b, 1);
        System.out.println(answer);
    }

    public static void dfs(List<Integer> playerList, int a, int b, int round) {
        int num = playerList.size();

        // 참가자 1명 이하이면 종료
        if (num < 2) {
            answer = -1;
            return;
        }

        Collections.sort(playerList);
        List<Integer> nextRound = new ArrayList<>();
        for (int i = 0; i < num; i += 2) {
            // 마지막 혼자 남은 사람(부전승)
            if (i + 1 == num) {
                nextRound.add(playerList.get(i));
                continue;
            }

            int p1 = playerList.get(i);
            int p2 = playerList.get(i + 1);

            // 이번 라운드에서 a,b가 만나면 종료
            if ((p1 == a && p2 == b) || (p1 == b && p2 == a)) {
                answer = round;
                return;
            }

            // 승자 결정 (a나 b가 포함된 경기라면 그대로 진출)
            if (p1 == a || p2 == a) nextRound.add(a);
            else if (p1 == b || p2 == b) nextRound.add(b);
            else nextRound.add(p1); // 임의의 승자
        }

        dfs(nextRound, a, b, round + 1);
    }
}