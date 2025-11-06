import java.util.*;
import java.io.*;
public class Main
{
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int t = Integer.parseInt(br.readLine());
int[] countList = new int[t];
for(int i = 0; i<t;i++){
   StringTokenizer st = new StringTokenizer(br.readLine());
   int j = Integer.parseInt(st.nextToken());
   int n = Integer.parseInt(st.nextToken());
   int sum = 0;
   List<Integer> boxList = new ArrayList<>();
   for(int k = 0; k<n;k++){
       StringTokenizer st2 = new StringTokenizer(br.readLine());
       int r = Integer.parseInt(st2.nextToken());
       int c = Integer.parseInt(st2.nextToken());
       boxList.add(r*c);
   }
   Collections.sort(boxList);
   for(int a = boxList.size()-1; a>0;a--){
       if(j < boxList.get(a) || j-boxList.get(a) == 0) {
           sum++;
           break;
       }
       if(j-boxList.get(a) < 0) {
           continue;
       }
       else {
            j-=boxList.get(a);
            sum++;
       }
   }
   countList[i] = sum;
}

for(int x = 0; x < t; x++){
  System.out.println(countList[x]);
}
}
}