import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        int[] balls = new int[n];
        for (int k = 0; k < n; k++) {
            balls[k] = k + 1;
        }

        for (int mCount = 0; mCount < m; mCount++) {
            String[] input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]) - 1;
            int j = Integer.parseInt(input[1]) - 1;

            while (i < j) {
                int temp = balls[i];
                balls[i] = balls[j];
                balls[j] = temp;
                i++;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int s : balls) {
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
