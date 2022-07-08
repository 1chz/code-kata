# 주소록

![Java_17](https://img.shields.io/badge/java-17-red?logo=java)
[![GitHub license](https://img.shields.io/github/license/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata)
[![GitHub stars](https://img.shields.io/github/stars/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/issues)
[![GitHub forks](https://img.shields.io/github/forks/shirohoo/code-kata)](https://github.com/shirohoo/clean-code-kata/network)

---

## 요구사항

- JDK만 사용 할 것 (서드파티 라이브러리 사용 X)
- 영속성 계층은 파일 시스템을 사용 할 것
- 주소록 데이터는 TB 단위일 수 있으며, 따라서 모든 데이터를 한꺼번에 메모리에 모두 올릴 수 없음
- 검색 속도는 빠르면 빠를수록 좋으며, 최대 O(n)이어야 함
- 데이터는 주민번호, 이름, 성별, 나이, 전화번호, 주소가 존재

<br />

## 구현

- 주민번호가 고유하기 때문에, 주민번호를 해싱하여 나온 해시코드는 고유하다
- 주민번호를 해싱하여 나온 해시코드를 파일명으로 하여 데이터를 해당 파일안에 저장한다
- 주민번호를 key로하여 파일을 O(1)만에 찾아 낼 수 있다
- 주민번호 하나에 파일이 하나씩 생성돼있기 때문에, 실제 데이터가 수 TB여도 모든 파일을 메모리에 한꺼번에 올리지 않아도 된다

<br />