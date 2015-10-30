# aho-corasick

#This is an implementation of Aho-Corasick Algorithm.

#This Package includes the three search method as below.
#1. Original Aho-Corasick.
#2. Advanced substring search Aho-Corasick.
#3. longest Match using Aho-Corasick

#ex) if you want to search the strings like "aaa",""aaaabb", ""aabbcc", "abb", "bcc", "bbcc", ""aabbccdd", "aaabb" in "aaaabbaabbccdd"
#1. The Origianl Aho-Corasick will search it and show you only substrings which match to first letter of longer string as below.
#pos = 0, pattern = aaa
#pos = 0, pattern = aaaabb
#pos = 6, pattern = aabbcc
#pos = 6, pattern = aabbccdd

#2. The Advanced substring search(ImprovedAho-Corasick) is going to show you all the possible substrings as below.
#pos = 0, pattern = aaa
#pos = 1, pattern = aaa
#pos = 1, pattern = aaabb
#pos = 3, pattern = abb
#pos = 0, pattern = aaaabb
#pos = 7, pattern = abb
#pos = 8, pattern = bbcc
#pos = 9, pattern = bcc
#pos = 6, pattern = aabbcc
#pos = 6, pattern = aabbccdd

#3. Longest Match is just longest match using aho-corasick with suffix arrays of possible strings.
