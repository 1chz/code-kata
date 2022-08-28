package io.github.shirohoo.adapter.out.console;

import static java.util.stream.Collectors.joining;

import io.github.shirohoo.app.domain.Product;
import io.github.shirohoo.app.domain.Products;
import io.github.shirohoo.app.domain.Receipt;

import java.text.DecimalFormat;
import java.util.function.Consumer;

public final class ConsoleOutAdapter {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String READY_MESSAGE = "입력(o[order]: 주문, q[quit]: 종료) : ";
    private static final String TABLE_FORMAT = "| %-10s | %-50s | %10s | %10s |";
    private static final String PRODUCT_ID_MESSAGE = "상품번호 : ";
    private static final String QUANTITY_MESSAGE = "수량 : ";
    private static final String EXIT_MESSAGE = "고객님의 주문 감사합니다.";

    private static final String ORDER_HISTORY_MESSAGE =
            """
            주문 내역:
            ----------------------------------------------------------------
            %s
            ----------------------------------------------------------------
            주문 금액: %s원
            ----------------------------------------------------------------
            지불금액: %s원
            ----------------------------------------------------------------
            """;

    private static final String ORDER_HISTORY_WITH_DELIVERY_FEE_MESSAGE =
            """
            주문 내역:
            ----------------------------------------------------------------
            %s
            ----------------------------------------------------------------
            주문 금액: %s원
            배송비: %s원
            ----------------------------------------------------------------
            지불금액: %s원
            ----------------------------------------------------------------
            """;

    public void ready() {
        print(READY_MESSAGE);
    }

    public void table(Products products) {
        String contour = toFullWidth("-".repeat(93));
        println(contour);
        println(toFullWidth(TABLE_FORMAT.formatted("상품번호", "상품명", "판매가격", "재고수")));
        println(contour);
        products.stream().forEach(printTable());
        println(contour);
        newLine();
    }

    private Consumer<Product> printTable() {
        return product ->
                println(
                        toFullWidth(
                                TABLE_FORMAT.formatted(
                                        product.id(),
                                        product.name(),
                                        DECIMAL_FORMAT.format(product.price()),
                                        product.quantity())));
    }

    public void id() {
        print(PRODUCT_ID_MESSAGE);
    }

    public void quantity() {
        print(QUANTITY_MESSAGE);
    }

    public void orderHistory(Receipt receipt) {
        if (receipt.isSeparateDeliveryFee()) {
            println(
                    ORDER_HISTORY_WITH_DELIVERY_FEE_MESSAGE.formatted(
                            productList(receipt),
                            DECIMAL_FORMAT.format(receipt.orderAmount()),
                            DECIMAL_FORMAT.format(receipt.deliveryFee()),
                            DECIMAL_FORMAT.format(receipt.paymentAmount())));
            return;
        }

        println(
                ORDER_HISTORY_MESSAGE.formatted(
                        productList(receipt),
                        DECIMAL_FORMAT.format(receipt.orderAmount()),
                        DECIMAL_FORMAT.format(receipt.paymentAmount())));
    }

    private String productList(Receipt receipt) {
        return receipt.stream()
                .map(
                        product ->
                                String.format(
                                        "%s - %s개%s",
                                        product.name(), product.quantity(), LINE_SEPARATOR))
                .collect(joining())
                .stripTrailing();
    }

    public void exceptionCaught(Exception e) {
        println(e.getMessage());
    }

    public void exit() {
        println(EXIT_MESSAGE);
        System.exit(0);
    }

    // Changed to full-width characters for pretty print 👍
    private String toFullWidth(String src) {
        if (src.isBlank()) {
            return src;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c >= 0x21 && c <= 0x7e) {
                c += 0xfee0;
            } else if (c == 0x20) {
                c = 0x3000;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void newLine() {
        System.out.println();
    }
}
