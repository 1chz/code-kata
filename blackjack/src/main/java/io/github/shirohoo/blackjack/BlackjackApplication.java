package io.github.shirohoo.blackjack;

import static io.github.shirohoo.blackjack.domain.Blackjack.BLACKJACK_SCORE;
import static io.github.shirohoo.blackjack.domain.Blackjack.DEALER_MAX_SCORE;
import io.github.shirohoo.blackjack.domain.Blackjack;
import io.github.shirohoo.blackjack.domain.Money;
import io.github.shirohoo.blackjack.domain.Player;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BlackjackApplication implements CommandLineRunner {

    private Scanner scanner;
    private Player player;
    private Player dealer;
    private Blackjack blackjack;

    public static void main(String[] args) {
        SpringApplication.run(BlackjackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        init();
        int bet = betting(scanner, player);
        drawAll();
        ifLostWhenScoreExceedsBlackjackScore();

        try {
            while (true) {
                log.info("카드를 받는다=Y/y");
                log.info("멈춘다=N/n");
                String select = scanner.nextLine();

                if (isYes(select)) {
                    blackjack.draw(player, BLACKJACK_SCORE);
                    blackjack.draw(dealer, DEALER_MAX_SCORE);

                    log.info("플레이어 카드={}", player.playerScore());
                    log.info("딜러 카드={}", dealer.playerScore());
                }

                if (isNo(select)) {
                    blackjack.draw(dealer, DEALER_MAX_SCORE);
                    matchDecision(bet);
                    log.info("지갑 잔액 : " + player.walletBalance());
                    break;
                }
            }
        } catch (IllegalStateException e) {

        } finally {
            log.info("게임 끝");
            scanner.close();
        }
    }

    private void init() {
        scanner = new Scanner(System.in);
        player = Player.player();
        dealer = Player.dealer();
        blackjack = Blackjack.newInstance();
    }

    private int betting(Scanner sc, Player player) {
        log.info("게임을 시작합니다.");
        log.info("지갑 잔액 : {}", player.walletBalance());
        log.info("배팅할 금액을 입력하세요.");
        int bet = sc.nextInt();
        player.bet(Money.of(bet));
        sc.nextLine();
        return bet;
    }

    private void drawAll() {
        log.info("카드를 2장씩 받습니다.");
        blackjack.draw(player, BLACKJACK_SCORE);
        blackjack.draw(dealer, DEALER_MAX_SCORE);
        blackjack.draw(player, BLACKJACK_SCORE);
        blackjack.draw(dealer, DEALER_MAX_SCORE);
        log.info("플레이어 카드={}", player.playerScore());
        log.info("딜러 카드={}", dealer.playerScore());
    }

    private boolean isYes(String select) {
        return "Y".equals(select) || "y".equals(select);
    }

    private boolean isNo(String select) {
        return "N".equals(select) || "n".equals(select);
    }

    private void ifLostWhenScoreExceedsBlackjackScore() {
        if (player.playerScore() > BLACKJACK_SCORE) {
            log.info("패배");
            log.info("지갑 잔액 : " + player.walletBalance());
            log.info("게임 끝");
            scanner.close();
            System.exit(0);
        }
    }

    private void matchDecision(int bet) {
        if (player.playerScore() == dealer.playerScore()) {
            log.info("무승부");
            player.tie(Money.of(bet));
            log.info("지갑 잔액={}", player.walletBalance());
            return;
        }

        if (player.playerScore() > dealer.playerScore()) {
            log.info("승리");
            player.win(Money.of(bet));
            return;
        }
        log.info("패배");
    }

}
