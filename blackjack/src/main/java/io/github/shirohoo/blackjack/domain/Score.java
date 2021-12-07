package io.github.shirohoo.blackjack.domain;

import java.util.Objects;

public class Score {

    public static final Score BLACKJACK = Score.from(21);

    private final int score;

    private Score(int score) {
        this.score = score;
    }

    public static Score from(int score) {
        return new Score(score);
    }

    public int intValue() {
        return score;
    }

    public static Score add(Score s1, Score s2) {
        return s1.add(s2);
    }

    public Score add(Score score) {
        int sumValue = this.score + score.intValue();
        return Score.from(sumValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score1 = (Score) o;
        return score == score1.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

}
