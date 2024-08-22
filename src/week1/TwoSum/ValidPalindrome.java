package week1.TwoSum;

public class ValidPalindrome {
    public static void main(String[] args) {
        withSameString("&^%&^%&*%");
    }

    public static boolean withNewString(String s) {
        String pattern = "[\\W_]";
        String ns = s.replaceAll(pattern, "").toLowerCase();
        int left = 0;
        int right = ns.length() - 1;
        while(left < right){
            if(ns.charAt(left) != ns.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean withSameString(String s){
        if(s.length() <= 1) return true;
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(!Character.isLetterOrDigit(s.charAt(left)) && left < right) left++;
            while(!Character.isLetterOrDigit(s.charAt(right)) && left < right) right--;
            if(left >= right) break;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}
