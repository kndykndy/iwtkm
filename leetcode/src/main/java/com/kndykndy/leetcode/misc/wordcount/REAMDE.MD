# Word Count

This task consists of two parts:

## Simple word count

You are given the [CharacterReader](CharacterReader.java) interface. Implement a function that 
takes a CharacterReader and produces a list of words, in order of descending frequency. When two 
words have the same frequency, they should follow the alphabetical order.

For example the input `The cat sat on the mat.` would produce:
* the – 2 
* cat – 1 
* mat - 1 
* on – 1 
* sat – 1

## Slow, parallel word count

You are given 10 instances of the above interface, which sleep for a random amount of time before 
returning a character. Write code that will read these in parallel. It should output the current 
(combined) counts of the words every 10 seconds and final totals at the end.
