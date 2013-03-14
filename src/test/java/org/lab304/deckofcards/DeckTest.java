package org.lab304.deckofcards;

import org.junit.Before;
import org.junit.Test;
import org.lab304.deckofcards.playingcard.PlayingCardFactory;

import java.util.List;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deck;
    List<Card> cardsInOriginalOrder;

    @Before
    public void setUp() throws Exception {

        PlayingCardFactory playingCardFactory = new PlayingCardFactory();
        cardsInOriginalOrder = playingCardFactory.generateCards();

        deck = new Deck(cardsInOriginalOrder);
    }

    /**
     * In order to prove that the cards are in a random order we can shuffle the deck and then find any cards that do
     * not match the original order. Cards that match the original order don't mean anything as the could have been
     * randomly shuffled back to the same spot.
     */
    @Test
    public void testShuffle() throws Exception {

        boolean foundCardOutOfOrder = false;

        // shuffle the deck
        deck.shuffle();

        for (Card card : cardsInOriginalOrder) {
            Card randomCard = deck.dealOneCard();
            if (!card.equals(randomCard)) {
                foundCardOutOfOrder = true;
            }
        }

        assertTrue(foundCardOutOfOrder);
    }


    @Test
    public void testDealOneCard() throws Exception {
        // we got a card back!
        assertNotNull(deck.dealOneCard());

        // Make a deck with no cards, we should not get a card back (or an NPE and the like)
        Deck emptyDeck = new Deck();
        assertNull(emptyDeck.dealOneCard());
    }

    @Test
    public void testCardsInRandomOrder() throws Exception {
        deck.shuffle();

        int startingDeckSize = deck.getSize();

        // these should all be cards
        for (int i = 0; i < startingDeckSize; i++) {
            Card temp = deck.dealOneCard();
            assertNotNull(temp);
        }

        // we are out of cards in the deck, this should be a null
        assertNull(deck.dealOneCard());
    }
}
