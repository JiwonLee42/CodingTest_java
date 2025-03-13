import java.io.*;
import java.util.LinkedList;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int currentk = k;
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        LinkedList<Integer> table = new LinkedList<>();
        
        for(int i = 1;i<=n;i++){
            table.add(i);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!table.isEmpty()){
            for(int i = 1; i < k; i++){
                table.addLast(table.pollFirst());
            }
             result.add(table.pollFirst());
        }

        for(int j = 0; j<n; j++){
            if(j==n-1) sb.append(result.get(j)).append(">");
            else sb.append(result.get(j)).append(", ");
        }
        System.out.println(sb.toString());
      
    }

}