package com.company;

/**
 * Created by falyanguzov on 09.11.2016.
 */
public class Dealer extends Computer {

    private Deck deck = new Deck();

    public Dealer() {
        super(new DealerIntellect());
        this.name =  "Dealer";
    }

    public void deal(Player player) {
        if(deck.isEmpty())
            deck = new Deck();
        Card current = this.deck.pop();
        player.take(current);
    }
}
