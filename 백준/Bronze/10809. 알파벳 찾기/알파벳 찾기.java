import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c = 'a';c<='z';c++){
            sb.append(s.indexOf(c)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}