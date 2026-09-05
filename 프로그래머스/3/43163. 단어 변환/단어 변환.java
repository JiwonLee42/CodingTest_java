import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean [] visited = new boolean[words.length];
        List<String> current = new ArrayList<>();
        current.add(begin);
        int depth = 0;
        while(!current.isEmpty()){
            // 다음 단어 도달 단어 모으기
            List<String> nextWords = new ArrayList<>();
            for(String cur : current){ // 현재 단계 단어 돌기
                if(cur.equals(target)) return depth;
                for(int i = 0;i<words.length;i++){
                    if(!visited[i] && canConvert(cur,words[i])){
                        visited[i] = true;
                        nextWords.add(words[i]);
                    }
                }
            }
            current = nextWords;
            depth++;
        }
        
        return answer;
    }
    boolean canConvert(String a, String b) {
        int diffCount = 0;
        for(int i = 0; i < a.length();i++){
            if(a.charAt(i) != b.charAt(i)) diffCount++;
        }
        return diffCount == 1;
    }
    
}