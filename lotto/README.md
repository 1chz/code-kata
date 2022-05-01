# 2단계 - 로또(자동)

![Java_17](https://img.shields.io/badge/java-17-red?logo=java)
[![GitHub license](https://img.shields.io/github/license/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata)
[![GitHub stars](https://img.shields.io/github/stars/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/issues)
[![GitHub forks](https://img.shields.io/github/forks/shirohoo/clean-code-kata)](https://github.com/shirohoo/clean-code-kata/network)

---

- 다음 요구사항을 `TDD`로 구현한다.

## 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

```shell
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 프로그래밍 요구사항

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 Google Java Style Guide을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- else 예약어를 쓰지 않는다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
