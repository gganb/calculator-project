package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class CalculationHistory {
    private final List<String> calculatorHistory = new ArrayList<>();

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

    public void removeHistory() {    //저장 기록 삭제하기
        if (calculatorHistory.isEmpty()) {  //기록이 비워져있을 때
            System.out.println("계산 기록이 없습니다.");
        } else {
            System.out.println(calculatorHistory.remove(calculatorHistory.size() - 1));//삭제할 기록 출력
            System.out.println("삭제되었습니다."); //마지막 인덱스 삭제
        }
    }

    public List<String> findToResult(double result) {   //입력값 보다 큰 결과 값 찾기
        return calculatorHistory.stream()
                .filter(str -> {
                    try {
                        String[] resultStr = str.split("="); // "="을 기준으로 문자열 자르기, "="을 기준으로 뒤의 값은 결과값
                        return resultStr.length == 2 && Double.parseDouble(resultStr[1]) > result; // 배열 길이가 2이고 결과값을 가진 인덱스의 실수로 변환한 값이 입력받은 값 보다 크다면 필터링해서 str에 저장함
                    } catch (NumberFormatException e) { //없다면 필터링하지 않고 false 리턴
                        System.out.println("없습니다");
                        return false;
                    }
                })   // 중간 연산. 반복 수행해 원하는 값 출력
                .collect(Collectors.toList()); // 최종 출력.
    }
}
