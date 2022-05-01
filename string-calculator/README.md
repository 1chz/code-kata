# 문자열 계산기

![Java_17](https://img.shields.io/badge/java-17-red?logo=java)
[![GitHub license](https://img.shields.io/github/license/shirohoo/clean-code-kata)](https://github.com/shirohoo/code-kata)
[![GitHub stars](https://img.shields.io/github/stars/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/issues)
[![GitHub forks](https://img.shields.io/github/forks/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/network)

---

- 다음 요구사항을 `TDD`로 구현한다.

## 요구사항

- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 `2 + 3 * 4 / 2`와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

## 프로그래밍 요구사항

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Google Java Style Guide을 원칙으로 한다.
    - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- else 예약어를 쓰지 않는다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
