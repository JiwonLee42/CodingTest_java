import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int x = Integer.parseInt(arr[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int token = Integer.parseInt(st.nextToken());
            if(token < x) {
                System.out.print(token + " ");
            }
        }
    }
}