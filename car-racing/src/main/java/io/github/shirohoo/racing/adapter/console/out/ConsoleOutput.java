package io.github.shirohoo.racing.adapter.console.out;

import static java.util.stream.Collectors.joining;
import io.github.shirohoo.racing.domain.Car;
import io.github.shirohoo.racing.port.out.Output;
import java.util.List;

public class ConsoleOutput implements Output {
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public String setCarNamesMessage() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return "";
    }

    @Override
    public String setTryCountMessage() {
        println("시도할 회수는 몇회인가요?");
        return "";
    }

    @Override
    public String showRoundMessage(List<List<Car>> eachRound) {
        StringBuilder sb = new StringBuilder(NEW_LINE)
            .append("실행 결과")
            .append(NEW_LINE);

        for (List<Car> cars : eachRound) {
            for (Car car : cars) {
                String carName = car.name();
                int currentPosition = car.currentPosition();
                sb.append(String.format("%s : %s%s", carName, convertSymbol(currentPosition), NEW_LINE));
            }
            sb.append(NEW_LINE);
        }
        print(sb.toString());
        return "";
    }

    private String convertSymbol(int currentPosition) {
        return "-".repeat(currentPosition);
    }

    @Override
    public String showResultMessage(List<Car> winners) {
        println(String.format("%s 이(가) 최종 우승했습니다.", convertWinnersString(winners)));
        return "";
    }

    private String convertWinnersString(List<Car> winners) {
        return winners.stream()
            .map(Car::name)
            .collect(joining(", "));
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
