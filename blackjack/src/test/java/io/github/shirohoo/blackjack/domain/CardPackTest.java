package io.github.shirohoo.blackjack.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardPackTest {

    @Test
    @DisplayName("비정상일 경우 IllegalStateException 가 발생한다")
    void newCardPack() throws Exception {
        assertThatCode(() -> CardPack.newCardPack()).doesNotThrowAnyException();
    }

}