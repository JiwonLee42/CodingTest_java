import java.util.*;

class Solution {
    Set<Integer> primeSet = new HashSet<>();

    public int solution(String numbers) {
        String[] numberList = numbers.split("");
        boolean[] visited = new boolean[numberList.length];

        dfs(numberList, visited, "", 0);
        return primeSet.size();
    }

    // 순열 탐색 
    public void dfs(String[] numberList, boolean[] visited, String current, int depth) {
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) primeSet.add(num);
        }

        if (depth == numberList.length) return;

        for (int i = 0; i < numberList.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numberList, visited, current + numberList[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
