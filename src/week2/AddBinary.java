package week2;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b){
        if(a.isEmpty()) return b;
        if(b.isEmpty()) return a;
        boolean carry = false;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            int curr = carry ? 1 : 0;
            if(i >= 0) curr += a.charAt(i--) - '0';
            if(j >= 0) curr += b.charAt(j--) - '0';
            carry = curr / 2 == 1;
            int digit = curr % 2;
            sb.append(digit);
        }
        if(carry) sb.append(1);
        return sb.reverse().toString();
    }
}
