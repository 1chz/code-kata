package io.github.shirohoo.blackjack.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Blackjack {

    public static final int BLACKJACK_SCORE = 21;
    public static final int DEALER_MAX_SCORE = 17;

    private final CardPack cardPack;

    private Blackjack() {
        this.cardPack = CardPack.newCardPack();
    }

    public static Blackjack newInstance() {
        return new Blackjack();
    }

    public void draw(Player player, int limitScore) {
        if (player.isDealer() && player.playerScore() >= DEALER_MAX_SCORE) {
            log.info("dealer 는 더이상 카드를 뽑을 수 없습니다.");
            return;
        }
        player.addCard(cardPack.draw());
        if (player.playerScore() > BLACKJACK_SCORE) {
            log.info("{}의 점수가 {}점을 초과했습니다.", player.getName(), BLACKJACK_SCORE);
            throw new IllegalStateException();
        }
    }

}

