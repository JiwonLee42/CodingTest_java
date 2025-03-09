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
        for(int k : balls){
            k = 0;
        }
        String line;
        while((line = br.readLine())!=null){
            String[] input = line.split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            for(int f = i-1;f<j;f++){
               balls[f] = k;
            }
        }
        for(int s : balls){
            System.out.print(s + " ");
        }        
    }
}