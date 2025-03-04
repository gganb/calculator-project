package com.example.calculator.lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator myCalculator = new Calculator(0, 0, ' ');
        try {
            // 양의 정수 입력받기
            System.out.print("숫자 1 입력 : ");
            int num1 = Integer.parseInt(scan.nextLine());

            System.out.print("숫자 2 입력 : ");
            int num2 = Integer.parseInt(scan.nextLine());

            // 입력받은 값이 양의 정수가 아닐 때 예외 발생시키기
            if (num1 < 0 || num2 < 0) {
                throw new RuntimeException("양의 정수만 입력하세요");
            }

            // 사칙 연산 기호 입력 받기
            System.out.print("연산자를 입력하세요 ( +, -, /, x ) : ");
            String str = scan.nextLine();
            char operator = str.charAt(0);

            Number result = 0;
            switch (operator) { //입력한 연산자에 따라 switch 문 동작
                case '+':
                    result = myCalculator.add(num1, num2);
                    break;
                case '-':
                    result = myCalculator.subtract(num1, num2);
                    break;
                case 'x':
                    result = myCalculator.multiply(num1, num2);
                    break;
                case '/':
                    result = myCalculator.divide(num1, num2);
                    break;
                default:    // 사칙연산 외의 연산자가 들어왔을 때 처리
                    System.out.println("계산할 수 없습니다.");
            }
            System.out.println("결과 : " + result);

            System.out.println("\n더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String msg = scan.nextLine();

        } catch (NumberFormatException e) {
            System.out.println("Error !");
            System.out.println("숫자만 입력해주세요.");
        } catch (ArithmeticException a) {
            System.out.println("Error !");
            System.out.println(a.getMessage());
        } catch (RuntimeException r) {
            System.out.println("Error !");
            System.out.println(r.getMessage());
        }// end of catch

        //   }// end of while
    }
}
