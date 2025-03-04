package com.example.calculator.lv3;


public enum OperatorType2 {
    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    TIMES('x', (a, b) -> a * b),
    DIVISION('/', (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final char operator;

    OperatorType2(char operator, Apply apply) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public static OperatorType2 inspectOperator(char operator){
        for(OperatorType2 type : OperatorType2.values()){
            if(type.getOperator() == operator)
                return type;
        }
        throw new IllegalArgumentException("잘못된 연산자 입니다.");
    }
}
