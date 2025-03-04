package com.example.calculator.lv2;

public class Calculator {
    private char operator;
    private int num1, num2;

    Calculator(int num1, int num2, char operator) {
        this.operator = operator;
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add(int num1, int num2){
        return num1 + num2;
    }
    public int subtract(int num1, int num2){
        return num1 - num2;
    }
    public int multiply(int num1, int num2){
        return num1 * num2;
    }
    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");    // 예외 발생
        }
        return num1 / (double) num2;
    }

}
