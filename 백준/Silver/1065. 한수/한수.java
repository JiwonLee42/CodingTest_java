import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        if(n<100){
            count = n;
        }
        else{
            count = 99;
            for(int i = 100;i<=n;i++){
                if((i%10 - i%100/10) == (i%100 -i/10)/10){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}