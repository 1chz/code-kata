package io.github.shirohoo.blackjack.domain;

public class Player {

    private final String name;

    private CardDeck cardDeck;
    private Wallet wallet;

    private Player(String name) {
        this.name = name;
        this.cardDeck = CardDeck.newInstance();
        this.wallet = Wallet.newInstance();
    }

    public static Player player() {
        return new Player("player");
    }

    public static Player dealer() {
        return new Player("dealer");
    }

    public void addCard(Card card) {
        cardDeck.add(card);
    }

    public int playerScore() {
        return cardDeck.totalScore();
    }

    public Money walletBalance() {
        return wallet.balance();
    }

    public void bet(Money betAmount) {
        wallet.betting(betAmount);
    }

    public void tie(Money betAmount) {
        wallet.tie(betAmount);
    }

    public void win(Money betAmount) {
        wallet.win(betAmount);
    }

    public String getName() {
        return name;
    }

    public boolean isDealer() {
        return this.name.equals("dealer");
    }

}
