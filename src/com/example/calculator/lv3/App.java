package com.example.calculator.lv3;

import com.example.calculator.CalculationHistory;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CalculationHistory calculationHistory = new CalculationHistory();   // 저장 클래스
        Calculator myCalculator = new Calculator(); // Calculator 생성자 초기화

        while (true) { // 사용자가 exit 입력 시 종료

            System.out.println("------- 계산하기 -------");
            System.out.print("숫자 1 입력 : ");
            int num1 = Integer.parseInt(scan.nextLine());
            myCalculator.setNum1(num1);   // num1 값 설정

            System.out.print("연산자 입력  : ");
            String str = scan.nextLine().trim();
            char operate = str.charAt(0);
            myCalculator.setOperator(operate);    // 연산자 설정

            System.out.print("숫자 2 입력 : ");
            int num2 = Integer.parseInt(scan.nextLine());
            myCalculator.setNum2(num2);   // num2 값 설정

            if (myCalculator.getOperator() == '/' && num2 == 0) {
                System.out.println("0으로 계산할 수 없습니다. 다시 입력해 주세요.");
                continue;
            }

            try {
                System.out.println(myCalculator.getCalculation());   //정답 출력
                calculationHistory.saveHistory(myCalculator.getCalculation());  // 계산 결과 저장
            } catch (ArithmeticException zero) {    // 0으로 나눌 경우 예외 처리
                System.out.println(zero.getMessage());
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

        } //while종료

        System.out.println("[ 저장 기록 메뉴 ]");
        boolean setting = true;
        while (setting) {       //저장 기록 메뉴
            System.out.print(" (1) 불러오기 (2) 삭제하기 (3) 나가기 : ");
            int askMsg = Integer.parseInt(scan.nextLine()); //번호 입력 받기
            switch (askMsg) {
                case 1:
                    System.out.println("------- 계산 기록 -------");
                    calculationHistory.printHistory();
                    break;
                case 2:
                    calculationHistory.clearHistory();
                    break;
                case 3:
                    System.out.println("종료합니다.");
                    setting = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }

        }// while2 종료
    }//main
} //class
