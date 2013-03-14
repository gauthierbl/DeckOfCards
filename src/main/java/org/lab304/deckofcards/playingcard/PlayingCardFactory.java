package org.lab304.deckofcards.playingcard;

import org.lab304.deckofcards.Card;
import org.lab304.deckofcards.CardFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility for generating a full set of playing cards
 */
public class PlayingCardFactory implements CardFactory {

    @Override
    public List<Card> generateCards() {

        List<Card> cards = new ArrayList<Card>();

        for (Suit suit : Suit.values()) {
            for (FaceValue value : FaceValue.values()) {
                cards.add(new PlayingCard(value, suit));
            }
        }

        return cards;
    }
}
