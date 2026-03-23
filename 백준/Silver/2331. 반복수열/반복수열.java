import java.util.*;
import java.io.*;

class Main {
    static List<Integer> numbers = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        numbers.add(a);
        int next = toNextNum(a,p);
        dfs(next,p);
        System.out.println(result);
    }

    public static void dfs(int next, int p) {
        if(numbers.contains(next)){
            result = numbers.indexOf(next);
            return;
        }
        numbers.add(next);
        dfs(toNextNum(next,p),p);
    }

    public static int toNextNum(int a, int p){
        String[] nums = String.valueOf(a).split("");
        int sum = 0;
        for(String next : nums){
            int thisN = 1;
            for(int i = 0; i < p; i++){
                thisN*=Integer.parseInt(next);
            }
            sum+=thisN;
        }
        return sum;
    }
}