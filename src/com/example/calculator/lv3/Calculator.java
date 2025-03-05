package com.example.calculator.lv3;


import static com.example.calculator.lv3.OperatorType.PLUS;

public class Calculator {    //값 계산하는 클래스
    private int num1;
    private int num2;
    private char operator;
    // private final Apply apply;


    // 생성자 초기화
    public Calculator() {

    }

    // 숫자,연산자 getter & setter
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setOperator(char operator) {    // 연산자 설정
        OperatorType validOperator = OperatorType.inspectOperator(operator);
        this.operator = validOperator.getOperator();
    }

    public char getOperator() {
        return this.operator;
    }
    //연산하기
//    public T calculate(T a, T b) { //추상 메서드와 연결
//        return apply.apply(a, b);
//    }

    public double calculate(int num1, int num2) {
        OperatorType operatorType = OperatorType.inspectOperator(operator);
        switch (operatorType) {
            case PLUS:
                return num1 + num2;
            case MINUS:
                return num1 - num2;
            case TIMES:
                return num1 * num2;
            case DIVISION:
                if (num2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다");
                }
                return (double) num1 / num2;
            default:
                throw new IllegalArgumentException("알맞은 연산자가 아닙니다.");
        }
    }

    public String getCalculation() {
        return String.format("%d %c %d = %s", num1, operator, num2, calculate(num1, num2));
    }


}
