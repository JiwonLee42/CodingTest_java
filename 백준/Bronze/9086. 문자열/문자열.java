import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            String input = br.readLine();
            System.out.println(String.valueOf(input.charAt(0)) + String.valueOf(input.charAt(input.length()-1)));
        }
    }
}