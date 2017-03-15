# About 


This is an exercise I decided to implement in Scala, Python, Javascript, C++ and other languages for myself. 

It attempts to implement the same exercise across all languages. This helps bring out the strengths and differences of each language overall. One also gets a sense of what is idiomatic in each of these languages.

The exercise itself is as follows:

_Implement a ring of nodes that are capable of passing messages to each other. Make each node send a unique message throughout the chain, stopping only when it gets to itself. Keep track of how many times the message has been passed along the chain._

I conider this a good, moderately more challenging Fizzbuzz-style candidate question for an interview. Why?

- It is straightforward to reason about, and the basic logic is easy to perceive. Any code produced does not rely on algorithmic tricks to achieve success.
- Successfully solving it requires familiarity with several core constructs of the language, such as random number generators, object-oriented programming, and/or whatever functional constructs exist throughout, as well as any idiosyncrasies encountered.

Note that this is also [Chang-Robert's leader election algorithm](https://www.wikiwand.com/en/Leader_election#/Leader_election_in_rings) in miniature, so it is not without use.

# Compilation Information

The solutions have all been tested with the following versions:

- `ring.py`: CPython2.7 (although should be compatible with Python 3)
- `ring.js`: Node 4.2.4
- `ring.scala`: Scala 2.11.7
- `ring.cpp`: C++11 on g++

Each node is programmed to print out its message when it has been successfully sent through the chain.
