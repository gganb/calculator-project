package com.example.calculator.lv3;


public enum OperatorType { // 사칙연산 기호들을 상수로 처리한 뒤 람다식을 이용해 초기화함
    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    TIMES('x', (a, b) -> a * b),
    DIVISION('/', (a, b) -> {
        if (b == 0) {   // 분모가 0 일 경우 예외 처리
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final char operator;
    private final Apply apply; // 함수 인터페이스

    OperatorType(char operator, Apply apply) { // 연산 기호, 람다식으로 초기화
        this.operator = operator;
        this.apply = apply;
    }

    public double calculate(int a, int b) { //추상 메서드와 연결
        return this.apply.apply(a, b);
    }

    public char getOperator() { // (char) 연산자 얻기
        return operator;
    }

    public static OperatorType inspectOperator(char operator) { // 입력된 문자가 유효한 연산자인지 검사
        for (OperatorType type : OperatorType.values()) {
            if (type.getOperator() == operator)
                return type;
        }
        throw new IllegalArgumentException("잘못된 연산자 입니다.");
    }
}
