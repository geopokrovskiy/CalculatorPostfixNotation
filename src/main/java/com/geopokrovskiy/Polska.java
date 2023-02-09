package com.geopokrovskiy;
import java.util.HashMap;
import java.util.Stack;


public class Polska {

    private String infixExpression;
    private String postfixExpression;

    private Stack<Character> operations;

    private Stack<Double> numberStack;

    public Polska(String infixExpression){
        this.infixExpression = infixExpression;
        this.operations = new Stack<>();
        this.numberStack = new Stack<>();
    }

    public String convertToPolska(HashMap<Character, Operation> hashMap) {
        StringBuilder numberBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.infixExpression.length(); i++) {
            if (Character.isDigit(this.infixExpression.charAt(i))) {
                numberBuilder.append(this.infixExpression.charAt(i));
            } else if (!numberBuilder.isEmpty()) {
                int number = Integer.parseInt(numberBuilder.toString());
                result.append(number + " ");
                numberBuilder = new StringBuilder();
                if (this.operations.isEmpty() && !Character.isDigit(this.infixExpression.charAt(i))) {
                    operations.push(this.infixExpression.charAt(i));
                } else {
                    Operation operation = hashMap.get(this.infixExpression.charAt(i));
                    int currentPriority = operation.getPriority();
                    int lastPriority = hashMap.get(operations.lastElement()).getPriority();
                    if (currentPriority <= lastPriority) {
                        result.append(operations.pop());
                        operations.push(this.infixExpression.charAt(i));
                    } else {
                        operations.push(this.infixExpression.charAt(i));
                    }
                }
            }
        }
        if (!numberBuilder.isEmpty()) {
            int number = Integer.parseInt(numberBuilder.toString());
            result.append(number);
            while (!operations.isEmpty()) {
                result.append(operations.pop());
            }
        }
        this.postfixExpression = result.toString();
        return result.toString();
    }

    public double calculate(HashMap<Character, Operation> hashMap) {
        String polska = this.convertToPolska(hashMap);
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < polska.length(); i++) {
            if (Character.isDigit(polska.charAt(i))) {
                numberBuilder.append(polska.charAt(i));
            } else if (!numberBuilder.isEmpty()) {
                double number = Double.parseDouble(numberBuilder.toString());
                numberStack.push(number);
                numberBuilder = new StringBuilder();
            } if (!Character.isSpaceChar(polska.charAt(i)) && !Character.isDigit(polska.charAt(i))) {
                    Operation operation = hashMap.get(polska.charAt(i));
                    double operand2 = numberStack.pop();
                    double operand1 = numberStack.pop();
                    double result = operation.operation(operand1, operand2);
                    numberStack.push(result);
                }
            }
        double result = numberStack.pop();
        return result;
    }
}


