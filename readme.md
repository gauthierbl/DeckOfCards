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
Testing something that is random is a bit of a trick. A good starting point is to control the randomness by using a seed.
The seed ensures that I get back the same "random" numbers every time. It also helps that `Shuffler`'s constructor
allows a client to pass in a source of randomness (represented by the java `Random` class). By externalizing `Shuffler`'s
randomness I can simplify its testing.

Given that the JDK folks and I think alike I figured it would be a good idea to use `Collections.shuffle()` as baseline
for a test. If I gave `Collections.shuffle()` the same input (same randomness, same list of objects to shuffle) as my
`Shuffler` then the results should be the same.