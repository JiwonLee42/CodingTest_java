import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());  
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            arr[i] = s;
        }
        Set<int[]> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j<n;j++) {
                if (arr[i] + arr[j] == m) {
                    int[] newArr = {i,j};
                    set.add(newArr);
                }
            }
        }
        answer = set.size()/2;
        System.out.println(answer);
    }
}