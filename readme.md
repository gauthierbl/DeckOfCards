# Deck Of Cards

# Problem Statement
Your assignment is to code in Java a set of classes that represent a deck of poker-style playing cards. (Fifty-two playing cards in four suits: hearts, spades, clubs, diamonds, with face values of Ace, 2-10, Jack, Queen, and King.) Within one of your classes, you must provide two operations:

## shuffle()
Shuffle returns no value, but results in the cards in the deck being randomly permuted.

## dealOneCard()
This function should return one card from the deck to the caller. Specifically, a call to shuffle followed by 52 calls to dealOneCard() should result in the caller being provided all 52 cards of the deck in a random order. If the caller then makes a 53rd call dealOneCard(), no card is dealt.

# Shuffle Algorithm
This uses an implementation of the [Fisher–Yates shuffle](http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle).