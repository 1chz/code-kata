# 상품 주문 시스템

## Requirements

---

![image](https://user-images.githubusercontent.com/71188307/159013753-715eda93-417b-429a-8355-15ea3e6014a5.png)

<br />

- 상품은 고유의 상품번호와 상품명, 판매가격, 재고수량 정보를 가지고 있다
- 한 번에 여러개의 상품을 같이 주문할 수 있어야 한다
- 상품번호, 주문수량은 반복적으로 입력 받을 수 있다
  - 단, 한번 결제가 완료되고 다음 주문에선 이전 결제와 무관하게 주문 가능 해야한다
- 주문은 상품번호, 수량을 입력받는다
  - `공백(space + ENTER)`이 입력 되었을 경우 해당 건에 대한 주문이 완료되고, 결제하는 것으로 판단한다
  - 결제 시 재고 확인을 하여야 하며 재고가 부족할 경우 결제 시도를 하면 `SoldOutException`이 발생되어야 한다
- 주문 금액이 `50,000`원 미만인 경우 배송료 `2,500`원이 추가 되어야 한다
- 주문이 완료되었을 경우 주문 내역과 주문 금액, 결제 금액(배송비 포함) 을 콘솔에 표시한다
- `q` 또는 `quit` 을 입력하면 프로그램이 종료되어야 한다
- 동시 요청시 `SoldOutException`이 발생하는지 확인하는 테스트가 작성되어야 한다

<br />

## Architecture

---

![image](https://user-images.githubusercontent.com/71188307/159008061-4f047fb1-3a7d-492d-beb3-a22c76fc661a.png)

<br />

![image](https://user-images.githubusercontent.com/71188307/159012570-8ed09ace-a8ec-4be6-b6bc-9c238c7625cf.png)

<br />

## Test Cases

---

![image](https://user-images.githubusercontent.com/71188307/159008111-751eecc2-4649-480a-9ae1-f0c058e88891.JPG)

<br />
