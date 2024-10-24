package week3;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] operation = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(operation));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                operands.push(operands.pop() + operands.pop());
            }else if(token.equals("-")){
                Integer secondOperand = operands.pop();
                Integer firstOperand = operands.pop();
                operands.push(firstOperand - secondOperand);
            }else if(token.equals("*")){
                operands.push(operands.pop() * operands.pop());
            }else if(token.equals("/")) {
                Integer secondOperand = operands.pop();
                Integer firstOperand = operands.pop();
                operands.push((int) firstOperand / secondOperand);
            }else{
                operands.push(Integer.parseInt(token));
            }
        }
        if(operands.size() != 1) System.out.println("Invalid operation");
        return operands.pop();
    }
}
