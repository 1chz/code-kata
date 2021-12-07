package io.github.shirohoo.blackjack.domain;

public class Card {

    private final Pattern pattern;
    private final Classes classes;

    private Card(Pattern pattern, Classes classes) {
        this.pattern = pattern;
        this.classes = classes;
    }

    public static Card of(Pattern pattern, Classes classes) {
        return new Card(pattern, classes);
    }

    public static boolean isBlackJack(Card c1, Card c2) {
        if (isAce(c1) && isTen(c2)) {
            return true;
        }
        if (isAce(c2) && isTen(c1)) {
            return true;
        }
        Score sumScore = Score.add(c1.getScore(), c2.getScore());
        if (sumScore.equals(Score.BLACKJACK)) {
            return true;
        }
        return false;
    }

    public static boolean isAce(Card card) {
        return card.classes == Classes.ACE;
    }

    public static boolean isTen(Card card) {
        return card.classes == Classes.TEN || card.classes == Classes.JACK || card.classes == Classes.QUEEN || card.classes == Classes.KING;
    }

    public Score getScore() {
        return classes.getScore();
    }

    public enum Pattern {
        SPATHA,
        HEART,
        DIAMOND,
        CLUB,
    }

    public enum Classes {
        ACE("A", Score.from(1)),
        TWO("2", Score.from(2)),
        THREE("3", Score.from(3)),
        FOUR("4", Score.from(4)),
        FIVE("5", Score.from(5)),
        SIX("6", Score.from(6)),
        SEVEN("7", Score.from(7)),
        EIGHT("8", Score.from(8)),
        NINE("9", Score.from(9)),
        TEN("10", Score.from(10)),
        JACK("J", Score.from(10)),
        QUEEN("Q", Score.from(10)),
        KING("K", Score.from(10));

        private final String mark;
        private final Score score;

        Classes(String mark, Score score) {
            this.mark = mark;
            this.score = score;
        }

        private Score getScore() {
            return score;
        }
    }

}
