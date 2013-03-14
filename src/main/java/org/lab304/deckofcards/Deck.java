package org.lab304.deckofcards;

import org.lab304.util.Shuffler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * A Deck is a collection of {@link Card}s the provides two built in methods.
 */
public class Deck {

    /**
     * We could use a Stack or a Queue but random access for the shuffle is more important than the easy of use
     * provided by Queue and Stack. Also if the deck is not shuffled it is important to get the cards back in their
     * original order. I'm disappointed that the JDK does not have a Queue that implements RandomAccess.
     * <p/>
     * Queue's random access was to slow (travers from start or end to get to the element).
     * Stack's FILO order would not allow the original order to be preserved in dealOneCard() (We would be dealing from
     * the bottom of the deck, that can get you shot in some circles!)
     */
    List<Card> cards = new ArrayList<Card>();

    /**
     * Creates a Deck with the give card list.
     *
     * @param cardList the initial ordering of cards
     */
    public Deck(List<Card> cardList) {
        cards.addAll(cardList);
    }

    /**
     * Creates an empty Deck.
     */
    public Deck() {
        this(new Stack<Card>());
    }

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

        if (!cards.isEmpty()) {
            result = cards.remove(0);
        }

        return result;
    }

    /**
     * The current size of the deck or how many cards are currently in the deck.
     *
     * @return the number of cards in the deck.
     */
    public int getSize() {
        return cards.size();
    }
}
