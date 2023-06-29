package io.shirohoo.kata.blackjack.application;

import io.shirohoo.kata.blackjack.domain.BlackJack;
import io.shirohoo.kata.blackjack.domain.Player;

public final class ConsoleApplication extends BlackJack {

    public ConsoleApplication(String... names) {
        super(names);
    }

    @Override
    public void start() {
        System.out.println("Game start!");
        dealer.draw();
        players.forEach(Player::draw);
        dealer.draw();
        players.forEach(Player::draw);

        System.out.println("\n> Initial deal:");
        System.out.println(dealer.name + ": " + dealer);
        players.stream().map(player -> player.name + ": " + player).forEach(System.out::println);

        players.forEach(Player::draw);
        if (dealer.shouldDraw()) dealer.draw();

        System.out.println("\n> After players take their turns:");
        System.out.println(dealer.name + ": " + dealer);
        players.stream().map(player -> player.name + ": " + player).forEach(System.out::println);

        System.out.println("\n> Result:");
        players.forEach(player -> {
            if (player.score() > 21) {
                System.out.println(player.name + ": BUST");

            } else if (dealer.score() > 21) {
                System.out.println(player.name + ": WIN");

            } else if (player.score() > dealer.score()) {
                System.out.println(player.name + ": WIN");

            } else if (player.score() < dealer.score()) {
                System.out.println(player.name + ": LOSE");

            } else {
                System.out.println(player.name + ": DRAW");
            }
        });
    }

    public static void main(String[] args) {
        BlackJack blackJack = new ConsoleApplication("James", "John", "Robert", "Michael", "William");
        blackJack.start();
    }
}
