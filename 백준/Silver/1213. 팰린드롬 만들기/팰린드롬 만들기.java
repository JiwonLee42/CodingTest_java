import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] charCount = new int[26]; 

        // 문자 개수 카운트
        for (char c : input.toCharArray()) {
            charCount[c - 'A']++;
        }

        // 홀수 개수인 문자 개수 세기 
        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] % 2 == 1) { 
                oddCount++;
                oddChar = (char) (i + 'A'); 
            }
        }

        // 홀수 개의 문자가 2개 이상이면 불가능 
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 절반 개수 추가 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int repeatCount = charCount[i] / 2; 
            for (int j = 0; j < repeatCount; j++) {
                sb.append((char) ('A' + i));
            }
        }

        String half = sb.toString(); 
        StringBuilder finalResult = new StringBuilder(half);
        if (oddCount == 1) finalResult.append(oddChar);
        // 뒤집은 문자열 추가
        finalResult.append(new StringBuilder(half).reverse());
        System.out.println(finalResult);
    }
}
