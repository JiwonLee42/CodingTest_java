import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] scores = new double[n];
        double maxScore = 0.0, sum = 0.0;
        for(int i = 0;i<n;i++){
            scores[i] = Double.parseDouble(st.nextToken());
            if(scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }
        for (int i = 0; i<n; i++){
            sum+= (scores[i] / maxScore) * 100;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum / n));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}