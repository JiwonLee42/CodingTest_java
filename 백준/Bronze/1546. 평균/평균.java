import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Double> scores = new ArrayList<>();
        for(int i = 0;i<n;i++){
            scores.add(Double.parseDouble(st.nextToken()));
        }
        Collections.sort(scores);
        Double m = scores.get(n-1);
        Double sum = 0.0;
        for(int i = 0;i<n;i++){
            sum+=scores.get(i) / m * 100;
        }
        System.out.println(sum / n);
    }
}
