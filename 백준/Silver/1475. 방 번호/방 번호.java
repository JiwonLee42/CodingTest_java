import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String[] numList = n.split("");
        HashMap<Integer,Integer> numbers = new HashMap<>();
        for(int i = 0; i < n.length();i++) {
            int c = Integer.parseInt(numList[i]);
            if(c==6 || c==9){
                numbers.putIfAbsent(9,0);
                numbers.put(9,numbers.get(9)+1);
            } else {
                numbers.putIfAbsent(c,0);
                numbers.put(c,numbers.get(c)+1);  
            }
        }
        if(numbers.containsKey(9)){
            if(numbers.get(9) % 2 == 0) numbers.put(9,numbers.get(9)/2);
            else if(numbers.get(9) == 1) numbers.put(9,1);
            else numbers.put(9,numbers.get(9)/2 + 1);           
        }
        List<Integer> valueList = new ArrayList(numbers.values());
        Collections.sort(valueList,Collections.reverseOrder());
        System.out.println(valueList.get(0));
    }
}
