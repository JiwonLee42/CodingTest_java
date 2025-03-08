import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int ans = 0;
        while(st.hasMoreTokens()){
            int token = Integer.parseInt(st.nextToken());
            if(token == v){
                ans++;
            }
        }
        System.out.println(ans);
    }
}