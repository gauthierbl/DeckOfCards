package org.lab304.deckofcards;

import org.lab304.util.Shuffler;

import java.util.Stack;

/**
 * A Deck is a collection of {@link Card}s the provides two built in methods.
 */
public class Deck {

    Stack<Card> cards = new Stack<Card>();

    /**
     * Shuffles the Deck, insuring that the {@link Card}s are in a random order.
     */
    public void shuffle() {

        Shuffler shuffler = new Shuffler();

        shuffler.shuffle(cards);
    }

    /**
     * Deals one card from the top of the Deck. If there is no card to deal then return null;
     *
     * @return the top {@link Card} in the Deck, or null if there are no cards left to deal.
     */
    public Card dealOneCard() {
        Card result = null;

        if (!cards.empty()) {
            cards.pop();
        }

        return result;
    }
}
