package com.algos;

import java.util.Stack;

/**
 * Created by kiran on 3/21/2017.
 */
public class DijkstraExpressionEvaluationShittyVersion {
    public static void main(String[] args) {
        System.out.println(evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )".split(" ")));
        System.out.println(( 12 + ( ( 2 * 3 ) - ( 4 + 5 ) ) ) );
    }

    private static int evaluate(String [] tokens) {
        Stack<Integer> operandStack = new Stack<Integer>();
        Stack<String> operatorStack = new Stack<String>();
        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                operatorStack.push(token);
            } else if(token.equals("(")) {
                continue;
            } else if(token.equals(")")) {
                String operator = operatorStack.pop();
                if(operator.equals("+")) {
                    int value = operandStack.pop() + operandStack.pop();
                    operandStack.push(value);
                } else if(operator.equals("-")) {
                    int value = operandStack.pop() - operandStack.pop();
                    operandStack.push(value);
                } else if(operator.equals("*")) {
                    int value = operandStack.pop() * operandStack.pop();
                    operandStack.push(value);
                } else if(operator.equals("/")) {
                    int value = operandStack.pop() / operandStack.pop();
                    operandStack.push(value);
                }
            } else if(!token.equals("(")){
                operandStack.add(Integer.parseInt(token));
            }
        }
        return operandStack.pop();
    }
}
