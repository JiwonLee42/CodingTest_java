import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        for(int i = 0;i<10;i++){
            arr[i] = Integer.parseInt(br.readLine());
            arr[i]%=42;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if(!list.contains(i)){
                list.add(i);
            }
        }
        System.out.println(list.size());
    }
}