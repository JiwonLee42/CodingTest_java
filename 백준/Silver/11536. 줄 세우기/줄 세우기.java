import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i<n;i++){
            arr[i] = br.readLine();
        }
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i <n; i++){
            if(arr[i].compareTo(arr[i-1]) > 0){
                decreasing = false;
            } else if (arr[i].compareTo(arr[i-1]) < 0){
                increasing = false;
            }
        }
        
        if(increasing)
            System.out.println("INCREASING");
        else if(decreasing)
            System.out.println("DECREASING");
        else
            System.out.println("NEITHER");
        
    }
}