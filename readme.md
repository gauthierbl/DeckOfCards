# Deck Of Cards

# Problem Statement
Your assignment is to code in Java a set of classes that represent a deck of poker-style playing cards. (Fifty-two
playing cards in four suits: hearts, spades, clubs, diamonds, with face values of Ace, 2-10, Jack, Queen, and King.)
Within one of your classes, you must provide two operations:

## shuffle()
Shuffle returns no value, but results in the cards in the deck being randomly permuted.

## dealOneCard()
This function should return one card from the deck to the caller. Specifically, a call to shuffle followed by 52 calls
to dealOneCard() should result in the caller being provided all 52 cards of the deck in a random order. If the caller
then makes a 53rd call dealOneCard(), no card is dealt.

# Shuffle Algorithm
This implementation uses the [Fisher–Yates shuffle](http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle).
The Fisher–Yates shuffle is unbiased, [unlike many other implementations](http://bost.ocks.org/mike/shuffle/compare.html).
It is important for a shuffle algorithm to be unbiased otherwise patterns start to emerge.
[Jeff Atwood's Coding Horror blog](http://www.codinghorror.com/blog/2007/12/shuffling.html) explains what happens when a
shuffle algorithm is biased. The same post also has a few good examples of biased shuffle algorithms.

Fisher–Yates is also the algorithm that the Java JDK uses for `Collections.shuffle()`.

## How does Fisher–Yates work?
Fisher–Yates shuffles the elements in place by starting at the back and moving forward,
swapping the current element with a random element in the front. This removes the need for a second collection in
memory. A very good visual explanation can be found [here](http://bost.ocks.org/mike/shuffle/). See the last example.

## How was randomness tested?
Testing randomness can be difficult -- it's random. I implemented `Shuffler`'s constructors to make the implementation
more testable by allowing the client to pass in a source of randomness represented by the Java `Random` class. By
externalizing `Shuffler`'s randomness I can better control the testing environment.

My code uses an algorithm similar to the algorithm used by `Collections.shuffle()`. Because the JDK also uses
Fisher-Yates, I can use it as a baseline for testing. If I give `Collections.shuffle()` the same input (the same
randomness and the same list of objects to shuffle) as my `Shuffler` the results should be the same.

# Improvements
* PlayingCard FaceValue of an Ace should be able to be represented as high or low.
* Spring should be used for dependency injection.
