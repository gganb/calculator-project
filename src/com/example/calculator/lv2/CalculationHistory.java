package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {
    private List<String> calculatorHistory = new ArrayList<>();


    public List<String> getCalculatorHistory() {
        return calculatorHistory;
    }

    public void saveHistory(String history) {
        calculatorHistory.add(history);
    }   //기록 저장하기

    public void printHistory() {    // 저장 기록 출력 함수
        if (calculatorHistory.isEmpty()) {
            System.out.println("계산 기록이 없습니다.");
        } else {
            for (String history : calculatorHistory) {   // 저장 기록 불러오기
                System.out.println(history);
            }
        }
    }

    public void clearHistory() {    //저장 기록 삭제하기
        if (calculatorHistory.isEmpty()) {  //기록이 비워져있을 때
            System.out.println("계산 기록이 없습니다.");
        } else {
            System.out.println(calculatorHistory.get(calculatorHistory.size() - 1));  //삭제할 기록 출력
            System.out.println("삭제되었습니다.");
            calculatorHistory.remove(calculatorHistory.size() - 1);   //마지막 인덱스 삭제
        }
    }
}
