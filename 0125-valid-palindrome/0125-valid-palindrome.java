import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        // 문자열 정리
        // 공백제거, 문자제거
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        boolean isValid = true;
        String[] sArray = s.split("");
        if(s.length() == 1) isValid = true;
        else {
         while(left < right){
            if(sArray[left].equals(sArray[right])){
                left++;
                right--;
            } else {
                isValid = false;
                break;
            }
          }
        }
        return isValid;
    }
}