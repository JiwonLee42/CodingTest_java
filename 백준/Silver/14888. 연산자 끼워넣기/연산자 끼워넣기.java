import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] numbers;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(st.nextToken());
            numbers[i] = k;
        }
        
        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int multiple = Integer.parseInt(st.nextToken());
        int division = Integer.parseInt(st.nextToken());

        dfs(1,numbers[0],plus,minus,multiple,division);
        
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int cur, int plus, int minus, int mul, int div){
        if(idx == n) {
            min = Math.min(cur,min);
            max = Math.max(cur,max);
        }
        
        if(plus > 0) dfs(idx+1, cur + numbers[idx], plus-1, minus, mul, div);
        if(minus > 0) dfs(idx+1, cur - numbers[idx], plus,minus-1,mul,div);
        if(mul > 0) dfs(idx+1,cur * numbers[idx], plus,minus,mul-1,div);
        if(div > 0) dfs(idx+1, cur / numbers[idx], plus,minus,mul,div-1);
    }

    
}