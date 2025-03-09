import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

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
        String line;
        while((line = br.readLine())!=null){
            String[] input = line.split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int l = balls[i-1];
            balls[i-1] = balls[j-1];
            balls[j-1] = l;
        }
        for(int s : balls){
            System.out.print(s + " ");
        }        
    }
}