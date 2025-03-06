# 📌 Java 기반 사칙연산 계산기
<br>

## 📌 프로젝트 개요

Java를 활용하여 **사칙연산 계산기**를 구현하는 프로젝트입니다.
 `enum`, `제네릭(Generics)`, `Stream API`, `Scanner` 등을 활용하여 개발하였습니다.
 
<br>

## 📌 프로젝트 구조

```
📂 calculator
│── 📂 src
│   │── 📂 com.example.calculator
|   |   |──📂 lv1
|   |   |── App.java                 # 실행, 계산 기능 담당 클래스
│   │   |──📂 lv2
│   |   |── App.java                 # 실행 클래스
|   |   │── CalculationHistory.java  # 연산 결과를 저장하는 클래스
│   │   │── Calculator.java          # 계산 기능을 담당하는 클래스
│   │   |──📂 lv3    
|   |   |── App.java                 # 실행 클래스
|   |   │── Calculator.java          # 계산 기능을 담당하는 클래스
|   |   |── OperatorType.java        # 연산자를 Enum으로 관리
│   │   │── CalculationHistory.java  # 연산 결과 저장 및 검색하는 클래스
│   │   │── Apply.java               # 함수형 인터페이스 정의
│── 📄 README.md                      # 프로젝트 설명
```

## ⚙️ 기능 소개


### 1️⃣ 사칙연산 수행

사용자가 입력한 두 개의 숫자와 연산자를 활용하여 계산을 수행합니다.

<details><summary>
 
</summary>

 ![스크린샷 2025-03-06 152839](https://github.com/user-attachments/assets/aadf47cc-aa0b-4530-a0fb-91b086f02a97)
</details>

### 2️⃣ 연산 결과 저장

이전 연산 결과를 `List<String>` 형태로 저장하여 히스토리를 관리합니다.

<details><summary>
</summary>
 
![image](https://github.com/user-attachments/assets/3136b4b7-b8d7-4679-8bbd-cdb5ad590062)

![image](https://github.com/user-attachments/assets/ddac5a0d-a958-470a-843c-8f14c492d9b2)

</details>

### 3️⃣ 특정 값보다 큰 결과 찾기

사용자가 특정 기준값을 입력하면, 기존 연산 결과 중 더 큰 값을 필터링하여 출력합니다.

<details><summary>
</summary>
 
![image](https://github.com/user-attachments/assets/d8b4e943-a7cc-4f54-b460-1faf467e32d0)

</details>

### 4️⃣ 예외 처리

잘못된 입력, 0으로 나누기 등의 예외 상황을 처리합니다.

<details><summary>

</summary>
 ![image](https://github.com/user-attachments/assets/460ca985-f682-4533-a059-f7f22f4912af)
</details>

<br>

## 🛠️ 주요 트러블슈팅 & 해결 과정

[트러블 슈팅](https://velog.io/@gksql0801/%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85-%EA%B3%84%EC%82%B0%EA%B8%B0)

<br>

## 📌 향후 보완할 점

1. **객체지향적인 설계 최적화**
   - `Calculator` 클래스의 역할을 더 명확하게 분리할 필요가 있음.
2. **예외 처리 고도화**
   - 사용자 입력 오류뿐만 아니라, 예상치 못한 오류도 고려한 `Custom Exception` 활용.
3. **Stream API 활용 확대**
   - 연산 결과를 처리할 때, 더 다양한 스트림 연산을 적용해 코드 가독성을 향상할 수 있음.

<br>

## 📌 마무리

이번 프로젝트를 통해 `enum`, `제네릭`, `Stream API`, `Scanner` 등의 개념을 직접 적용하며 학습할 수 있었습니다.
하지만 동시에 **객체지향적 설계, 예외 처리의 고도화, 코드 최적화** 등 여러 부족한 점도 발견할 수 있었습니다. 앞으로 이를 개선하여 더욱 유지보수성이 좋은 코드를 작성하는 것을 목표로 열심히 하겠습니다!


