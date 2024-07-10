package com.gegabox.calculatorreceiver;

public class Calculator {

    enum Operator {
        ADD('+'), SUBTRACT('-'), MULTIPLY('*');

        private final char symbol;

        Operator(char symbol) {
            this.symbol = symbol;
        }

    }
    private String operator;
    private int digit;

    public Calculator() {
    }
    public Calculator(String operator, int digit) {
        this.operator = operator;
        this.digit = digit;

    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "operator='" + operator + '\'' +
                ", digit=" + digit +
                '}';
    }
}
