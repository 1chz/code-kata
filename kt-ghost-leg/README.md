# 사다리 게임

![Java_17](https://img.shields.io/badge/java-17-red?logo=java)
![Kotlin_1.7.0](https://img.shields.io/badge/kotlin-1.7.0-purple?logo=kotlin)
[![GitHub license](https://img.shields.io/github/license/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata)
[![GitHub stars](https://img.shields.io/github/stars/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/issues)
[![GitHub forks](https://img.shields.io/github/forks/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/network)

---

## 기능 요구사항

- 사다리게임 참가자를 입력받는다.
    - 단, 참가자의 이름은 5글자 이하로 제한한다. (한글 포함이며, 문자열의 길이를 뜻한다)
    - 참가자의 이름이 5글자를 초과하면 `IllegalArgumentException`을 던진다.
- 도착지 정보를 입력받는다.
    - 도착지의 수는 참가자의 수와 동일해야 하며, 다르다면 `IllegalArgumentException`을 던진다.
- 사다리를 생성한다.
    - 사다리는 한 라인에서 `|-----|-----|`와 같이 양옆으로 이어질 수는 없다.
- 어디로 도착하는지 결과를 알고 싶은 참가자를 입력받고, 참가자가 어디에 도착했는지도 알려줄 수 있어야 한다.

![image](https://user-images.githubusercontent.com/71188307/175182555-6598258a-6e45-48ba-9129-482e0347752b.png)

<br />

## 프로그래밍 요구사항

- TDD로 개발한다.
- 하나의 함수에 오직 한 단계의 들여쓰기만 한다.
- else 예약어를 쓰지 않는다.
- 모든 원시값과 문자열을 포장한다.
- 한 줄에 점을 하나만 찍는다.
- 줄여쓰지 않는다(축약하지 않는다).
- 3개 이상의 인스턴스 변수를 가진 클래스를 사용하지 않는다.
- 일급 컬렉션을 쓴다.
- 객체지향 5원칙을 지키면서 프로그래밍한다.

<br />