import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i<k;i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
               stack.pop();
            } else{
               stack.push(input);
            }
        }
        while(!(stack.isEmpty())){
            sum+=stack.pop();
        }
        System.out.println(sum);
    }
}
