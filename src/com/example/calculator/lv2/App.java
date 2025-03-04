package com.example.calculator.lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {  // 반복 수행. exit 입력받기 전 까지 무한으로 수행 함
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

                int result = 0;
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        System.out.printf("%d + %d = %d\n", num1, num2, result);
                        break;
                    case '-':
                        result = num1 - num2;
                        System.out.printf("%d - %d = %d\n", num1, num2, result);
                        break;
                    case '/':   // 나누는 숫자가 0 일 경우 예외처리
                        if (num2 == 0) {
                            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        } else {
                            float resultf = num1 / (float) num2;
                            System.out.printf("%d / %d = %.2f\n", num1, num2, resultf);
                            break;
                        }
                    case 'x':
                        result = num1 * num2;
                        System.out.printf("%d x %d = %d\n", num1, num2, result);
                        break;
                    default:
                        System.out.println("올바른 연산자를 입력해주세요.");
                        break;
                }// end of switch
                System.out.println("\n더 계산하시겠습니까? (exit 입력 시 종료) : ");
                String msg = scan.nextLine();
                if (msg.equals("exit")) {
                    break;
                }

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
        }// end of while
    }
}
