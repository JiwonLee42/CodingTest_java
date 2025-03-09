import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] submitted = new boolean[30];
        for(int i = 0;i<28;i++){
            submitted[Integer.parseInt(br.readLine())-1] = true;
        }
        for(int j = 0;j<30;j++) {
            if(submitted[j] == false) {
                System.out.println(j+1);
            }
        }
    }
}