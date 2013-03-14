package org.lab304.deckofcards;

import java.util.List;
import java.util.Stack;

/**
 * A factory that can be used to generate a set of cards.
 */
public interface CardFactory {
    public List<Card> generateCards();
}
