package io.github.shirohoo.baseball.app.domain;

public class Referee {
    public DecisionResult decision(Numbers computerNumbers, Numbers userNumbers) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < computerNumbers.numbers().length(); i++) {
            ballCount += ifBallIncreaseByOne(i, computerNumbers, userNumbers);
            strikeCount += ifStrikeIncreaseByOne(i, computerNumbers, userNumbers);
        }
        return DecisionResult.of(ballCount, strikeCount);
    }

    private int ifBallIncreaseByOne(int i, Numbers computerNumbers, Numbers userNumbers) {
        if (computerNumbers.numbers().charAt(i) != userNumbers.numbers().charAt(i) &&
            userNumbers.numbers().contains(Character.toString(computerNumbers.numbers().charAt(i)))
        ) {
            return 1;
        }
        return 0;
    }

    private int ifStrikeIncreaseByOne(int i, Numbers computerNumbers, Numbers userNumbers) {
        if (computerNumbers.numbers().charAt(i) == userNumbers.numbers().charAt(i)) {
            return 1;
        }
        return 0;
    }
}
