package org.lab304.deckofcards.playingcard;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.lab304.deckofcards.Card;

/**
 * A typical playing card that is found in a 52 card deck.
 *
 * Note: This class intentionally lacks setter as cards should not be able to change their suit or faceValue.
 */
public class PlayingCard implements Card {
    private Suit suit;
    private FaceValue faceValue;

    public PlayingCard(FaceValue faceValue, Suit suit) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    public String getDisplayString() {
        return faceValue + " " + suit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("suit", suit).
                append("faceValue", faceValue).
                toString();
    }
}
