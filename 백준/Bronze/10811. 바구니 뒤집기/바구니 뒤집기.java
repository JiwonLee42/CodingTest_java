import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int[] balls = new int[n];
        for(int k =0;k<n;k++){
            balls[k] = k+1;
        }
        for(int mCount = 0;mCount<m;mCount++){
            String[] input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0])-1;
            int j = Integer.parseInt(input[1])-1;
            int[] copyBalls = balls.clone();
            for(int t = j-i, r = 0;t>=0;t--,r++) {
                balls[i+r] = copyBalls[j-r];
            }
        }
        for(int s : balls){
            System.out.print(s + " ");
        }        
    }
}