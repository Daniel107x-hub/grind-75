package week3;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int max = 0;
        int current = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()){
            char letter = s.charAt(right);
            if(!set.contains(letter)){
                current++;
                set.add(letter);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                current--;
                left++;
            }
            if(current > max) max = current;
        }
        return max;
    }
}
