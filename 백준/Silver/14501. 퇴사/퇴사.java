import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int answer = 0;
    static int money = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> tList = new ArrayList<>();
        List<Integer> pList = new ArrayList<>();
        
        for(int i = 0;i< n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());  
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            tList.add(t);
            pList.add(p);
        }
            int currentMoney = 0;
            dfs(0,currentMoney,n,tList,pList);
            System.out.println(answer);
        
    }

    public static void dfs(int day, int currentMoney, int n, List<Integer> tList, List<Integer> pList){
        if(day >= n) {
            answer = Math.max(answer,currentMoney);
            return;
        }
        if(day + tList.get(day) <= n){
            dfs(day + tList.get(day),currentMoney+pList.get(day),n,tList, pList);
        }
        dfs(day + 1,currentMoney,n,tList, pList);
    }
}