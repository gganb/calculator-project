package com.example.calculator.lv3;


public class Calculator {    //값 계산하는 클래스
    private int num1, num2;
    private char operator;

    // 생성자 초기화
    public Calculator() {
    }

    // 숫자,연산자 getter & setter
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) { // 양수 외의 값으로 변경할 수 없음
        if (num1 < 0) {
            throw new RuntimeException("양의 정수를 입력해주세요"); //예외 발생
        }
        this.num1 = num1;   // 0을 포함하는 양수일 경우 값 변경
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) { // 양수 외의 값으로 변경할 수 없음
        if (num2 < 0) {
            throw new RuntimeException("양의 정수를 입력해주세요"); //예외 발생
        } else {
            this.num2 = num2;  // 0을 포함하는 양수일 경우 값 변경
        }
    }

    public void setOperator(char operator) {    // 연산자 설정
        OperatorType validOperator = OperatorType.inspectOperator(operator);
        this.operator = validOperator.getOperator();
    }

    //연산하기
    public Number calculate() {
        switch (operator) {
            case '+':
                return OperatorType.PLUS.calculate(num1, num2);
            case '-':
                return OperatorType.MINUS.calculate(num1, num2);
            case 'x':
                return OperatorType.TIMES.calculate(num1, num2);
            case '/':
                return OperatorType.DIVISION.calculate(num1, num2);
            default:
                throw new IllegalArgumentException("알맞은 연산자가 아닙니다.");
        }
    }

    public String getCalculation() {
        return String.format("%d %c %d = %s", num1, operator, num2, calculate());
    }


}
