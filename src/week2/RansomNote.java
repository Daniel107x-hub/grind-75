package week2;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstructArray("aac", "afa"));
    }

    public static boolean canConstruct(String ransomNote, String magazine){
        if(magazine.length() < ransomNote.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for(char c : ransomNote.toCharArray()){
            Integer value = map.get(c);
            if(value == null) return false;
            if(value == 1) map.remove(c);
            else map.put(c, value - 1);
        }
        return true;
    }

    public static boolean canConstructArray(String ransomNote, String magazine){
        if(magazine.length() < ransomNote.length()) return false;
        int[] array = new int[26];
        for(char c : magazine.toCharArray()) array[c - 'a']++;
        for(char c : ransomNote.toCharArray()){
            int value = array[c - 'a'];
            if(value == 0) return false;
            array[c - 'a']--;
        }
        return true;
    }
}
