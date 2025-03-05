package com.example.calculator.lv3;

public class Calculator<T extends Number> {    //값 계산하는 클래스
    private T num1;
    private T num2;
    private OperatorType operator;

    // 기본 생성자
    public Calculator() {
    }

    // 숫자,연산자 getter & setter
    public T getNum1() {
        return num1;
    }

    public void setNum1(T num1) {
        this.num1 = num1;
    }

    public T getNum2() {
        return num2;
    }

    public void setNum2(T num2) {
        this.num2 = num2;
    }

    public void setOperator(char operator) {    // 연산자 설정
        this.operator = OperatorType.inspectOperator(operator);
    }

    public OperatorType getOperator() {
        return operator;
    }
//enum 내의 각 연산자로 값 전달하는 메서드
    public Number calculate() {
        double result = operator.apply(num1.doubleValue(), num2.doubleValue()); //double 형태로 전달
        result = Double.parseDouble(String.format("%.2f", result)); // 소수점 둘째자리까지 출력
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return Integer.valueOf((int) result);    // Integer 반환
        } else {
            return result;  // Double 반환
        }
    }

    public String getCalculation() {
        return String.format("%s %c %s = %s", num1, operator.getOperatorType(), num2, calculate());
    }


}
