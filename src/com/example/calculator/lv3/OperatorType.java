package com.example.calculator.lv3;


public enum OperatorType { // 사칙연산 기호들을 상수로 처리한 뒤 람다식을 이용해 초기화함
    PLUS('+'),
    MINUS('-'),
    TIMES('x'),
    DIVISION('/');

    private final char operator;
    // private final Apply apply; // 함수 인터페이스

    OperatorType(char operator) { // 연산 기호
        this.operator = operator;
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
