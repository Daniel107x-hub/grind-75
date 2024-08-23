package week1.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(usingArray("rat", "car"));
    }

    public static boolean isValidAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()){
            Integer value = map.get(c);
            if(value == null) return false;
            if(value == 1) map.remove(c);
            else map.put(c, value - 1);
        }
        return map.isEmpty();
    }

    public static boolean usingArray(String s, String t){
        int[] n = new int['z' - 'a'];
        if(s.length() != t.length()) return false;
        for(int i = 0 ; i < n.length ; i++){
            n[s.charAt(i) - 'a']++;
            n[t.charAt(i) - 'a']--;
        }
        for(int e : n) if(e != 0) return false;
        return true;
    }
}
