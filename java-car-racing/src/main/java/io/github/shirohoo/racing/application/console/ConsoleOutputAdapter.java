package io.github.shirohoo.racing.application.console;

import static java.util.stream.Collectors.joining;

import io.github.shirohoo.racing.domain.Car;
import io.github.shirohoo.racing.domain.RacingGame;
import java.util.List;

public class ConsoleOutputAdapter {
    private static final String NEW_LINE = System.lineSeparator();

    public void setCarNamesMessage() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void setTryCountMessage() {
        println("시도할 회수는 몇회인가요?");
    }

    public void showRoundMessage(RacingGame racingGame) {
        StringBuilder sb = new StringBuilder(NEW_LINE).append("실행 결과").append(NEW_LINE);

        racingGame.eachRound().forEach(cars -> buildRoundMessage(sb, cars));

        print(sb.toString());
    }

    private void buildRoundMessage(StringBuilder sb, List<Car> cars) {
        for (Car car : cars) {
            String carName = car.name();
            int currentPosition = car.currentPosition();
            sb.append(String.format("%s : %s%s", carName, convertSymbol(currentPosition), NEW_LINE));
        }
        sb.append(NEW_LINE);
    }

    private String convertSymbol(int currentPosition) {
        return "-".repeat(currentPosition);
    }

    public void showResultMessage(RacingGame racingGame) {
        String winners = convertWinnersString(racingGame);
        println(String.format("%s 이(가) 최종 우승했습니다.", winners));
    }

    private String convertWinnersString(RacingGame racingGame) {
        return racingGame.winners().stream().map(Car::name).collect(joining(", "));
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
