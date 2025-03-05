package com.example.calculator.lv3;

//연산자 enum
public enum OperatorType {
    PLUS('+') {
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },
    MINUS('-') {
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    },
    TIMES('x') {
        @Override
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVISION('/') {
        @Override
        public double apply(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
    };

    private final char operator;

    OperatorType(char operator) { // 생성자
        this.operator = operator;
    }

    public char getOperatorType() { // (char) 연산자 얻기
        return operator;
    }

    public abstract double apply(double a, double b);   // 추상메서드

    public static OperatorType inspectOperator(char operator) { // 입력된 문자가 유효한 연산자인지 검사, 연산자 반환
        for (OperatorType type : OperatorType.values()) {
            if (type.getOperatorType() == operator)
                return type;
        }
        throw new IllegalArgumentException("잘못된 연산자 입니다.");
    }


}
