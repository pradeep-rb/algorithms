**Binary Autocomplete**

n = 6, command = ['000','1110','01','001','110','11'], ans = {0, 1, 1, 1, 2, 5}
display the command with the longest prefix, most recent if there was a tie, 0 if there was none

Soln: use a trie. Trie node should store the index of the most recent command
