import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int[] dist = new int[words.length];
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < words.length; i++) {
            if (diffOne(begin, words[i])) {
                dist[i] = 1;
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            if(words[now].equals(target)) return dist[now];
            for(int i = 0; i < words.length;i++){
                if(dist[i] != 0) continue;
                if(diffOne(words[now],words[i])) {
                    dist[i] = dist[now] + 1;
                    q.offer(i);
                }
            }
        }
        
        
        return 0;
    }
    
    boolean diffOne(String a, String b) {
        int diff = 0;
        for (int j = 0; j < a.length(); j++) {
            if (a.charAt(j) != b.charAt(j)) diff++;
        }
        return diff == 1;
    }
}