import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 1]; // 각 스테이지에 도달한 사용자 수를 기록할 배열

        // stages 배열을 순회하여 각 스테이지에 도달한 사용자 수를 세기
        for (int stage : stages) {
            if (stage <= N) {
                stageCount[stage - 1]++;
            }
        }

        int totalPlayers = stages.length;  // 총 사용자 수
        float[] failPercent = new float[N];

        // 각 스테이지의 실패율 계산
        for (int i = 0; i < N; i++) {
            if (totalPlayers == 0) {
                failPercent[i] = 0;
            } else {
                failPercent[i] = (float) stageCount[i] / totalPlayers;
                totalPlayers -= stageCount[i];
            }
        }

        // 스테이지 번호와 실패율을 묶어서 리스트로 관리
        List<Integer> stageOrder = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stageOrder.add(i + 1);
        }

        // 실패율을 기준으로 내림차순 정렬, 실패율이 같으면 스테이지 번호 오름차순 정렬
        stageOrder.sort((a, b) -> {
            if (failPercent[b - 1] == failPercent[a - 1]) {
                return Integer.compare(a, b);
            } else {
                return Float.compare(failPercent[b - 1], failPercent[a - 1]);
            }
        });

        // 정렬된 스테이지 번호 배열 생성
        return stageOrder.stream().mapToInt(i -> i).toArray();
    }
}
