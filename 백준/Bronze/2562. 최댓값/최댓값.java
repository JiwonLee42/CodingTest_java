import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        String str;
        while((str = br.readLine())!=null){
            arr.add(Integer.parseInt(str));
        }
        ArrayList<Integer> sortedList = (ArrayList<Integer>) arr.clone();
        Collections.sort(sortedList,Collections.reverseOrder());
        int num = sortedList.get(0);
        System.out.println(num);
        for(int i = 0;i<sortedList.size();i++){
            if(arr.get(i) == num) {
                System.out.println(i+1);
            }
        }
 
    }
}