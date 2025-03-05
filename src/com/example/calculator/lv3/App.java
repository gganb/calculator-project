package com.example.calculator.lv3;

import java.util.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CalculationHistory calculationHistory = new CalculationHistory();   // 저장 클래스
        Calculator<Number> myCalculator = new Calculator<>(); // Calculator 생성자 초기화

        while (true) { // 사용자가 exit 입력 시 종료
            System.out.println("------- 계산하기 -------");
            System.out.print("숫자 1 입력 : ");
            double num1 = Double.parseDouble(scan.nextLine());
            myCalculator.setNum1(num1);   // num1 값 설정
            try {
                System.out.print("연산자 입력  : ");
                String str = scan.nextLine().trim();
                char operate = str.charAt(0);
                myCalculator.setOperator(operate);    // 연산자 설정

                System.out.print("숫자 2 입력 : ");
                double num2 = Double.parseDouble(scan.nextLine());
                myCalculator.setNum2(num2);   // num2 값 설정

                if (operate == '/' && num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다. 다시 입력해 주세요.");
                    continue;
                }

                System.out.println(myCalculator.getCalculation());   //정답 출력
                calculationHistory.saveHistory(myCalculator.getCalculation());  // 계산 결과 저장
            } catch (ArithmeticException zero) {    // 0으로 나눌 경우 예외 처리
                System.out.println(zero.getMessage());
                continue;
            } catch (IllegalArgumentException I) {
                System.out.println(I.getMessage());
                continue;
            }
            System.out.println("-----------------------");
            System.out.println("더 진행하시겠습니까? (exit or yes) : ");
            String msg = scan.nextLine();

            if (msg.equals("exit")) {   // 종료여부 묻기
                break;
            } else if (msg.equals("yes")) {
                continue;
            } else System.out.println("일치하지 않습니다"); //다시 계산하기로 돌아감

        } // while 종료
        showHistoryMenu(scan, calculationHistory);  // 저장 메뉴 호출
        scan.close();   // scanner 닫기
    } // main


    private static void showHistoryMenu(Scanner scan, CalculationHistory calculationHistory) {

        System.out.println("[ 저장 기록 메뉴 ]");
        //  boolean setting = true;
        while (true) {       //저장 기록 메뉴
            System.out.print(" (1) 불러오기 (2) 삭제하기 (3) 나가기 (4) 값 비교하기: ");
            int askMsg = Integer.parseInt(scan.nextLine()); //번호 입력 받기
            switch (askMsg) {
                case 1:
                    System.out.println("------- 계산 기록 -------");
                    calculationHistory.printHistory();
                    break;
                case 2:
                    calculationHistory.removeHistory(); // 가장 최근에 저장된 내용부터 한 개씩 삭제
                    break;
                case 3:
                    System.out.println("종료합니다.");
                    return;
                case 4:
                    System.out.println("----- 입력값 보다 큰 결과 출력하기 -----");
                    System.out.print("입력 : ");
                    double num3 = Double.parseDouble(scan.nextLine());
                    List<String> result = calculationHistory.findToResult(num3);
                    if (result.isEmpty()) { // 큰 값이 없다면 result에 아무 값도 존재하지않음.
                        System.out.println("큰 값이 없습니다");
                    } else result.forEach(System.out::println); // 존재하다면 출력
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }
        }
    }

} //class
