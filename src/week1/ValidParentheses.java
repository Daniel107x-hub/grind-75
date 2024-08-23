package week1;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s){
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if( c == '(' || c == '[' || c == '{') stack.push(c);
            else{
                if(!stack.isEmpty() && (
                        c == ')' && stack.peek() == '(' ||
                        c == ']' && stack.peek() == '[' ||
                        c == '}' && stack.peek() == '{'
                )) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
