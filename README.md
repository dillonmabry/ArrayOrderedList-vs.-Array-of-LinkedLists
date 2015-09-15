# ArrayOrderedList-vs.-Array-of-LinkedLists
##Testing environment to compare run-times of a series of Linked Lists vs. an ArrayOrderedList efficiency

This project is mainly involving two distinct data structures, an ArrayOrderedList and an array of Linked Lists. Each structure has advantages but for purposes of testing a test file has been included containing hundreds of words to show the efficiency of each structure. 

##Results

Results show that the array of Linked Lists are significantly more efficient at sorting massive inputs of words due to the dedicated array storage of each letter of the alphabet. 

A good way to show this is by illustration:

|A | B | C | D | E |

^Each letter has a specific array index associated with the ASCII values when the file is in input stages. Within the array index contains a LinkedList which is efficient in this case considering we only care about where the word has order in the English alphabet.

####Known Glitches

-Some inputs might cause exceptions as project has not received 100% error checking
-Java native file I/O might not correctly and program need a restart

**My Links**

- [My LinkedIn](http://linkedin.com/in/dillonmabry)
- [My GitHub](https://github.com/dillonmabry/)
