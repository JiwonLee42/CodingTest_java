import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<t;i++){
            String input = br.readLine();
            int spaceIndex = input.indexOf(' ');
            int repeat = Integer.parseInt(input.substring(0,spaceIndex));
            String word = input.substring(spaceIndex + 1);
            StringBuilder sb = new StringBuilder();

            for(char c : word.toCharArray()){
                 sb.append(String.valueOf(c).repeat(repeat));
            }

            result.append(sb).append("\n");
        }
        System.out.print(result.toString());
    
    }
}