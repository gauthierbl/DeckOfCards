package org.lab304.deckofcards;

/**
 * A card. Could be any type of card: Playing Card, Magic Card, Tarot Card, Baseball Card
 */
public interface Card {
    /**
     * A string used to display the card.
     *
     * @return a string for the cards display
     */
    public String getDisplayString();
}
