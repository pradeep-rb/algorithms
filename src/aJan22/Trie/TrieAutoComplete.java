package aJan22.Trie;

import java.util.*;

public class TrieAutoComplete {

    class TrieNode {
        char character;
        Map<Character, TrieNode> children =  new HashMap<>();
        boolean isEnd;

        public TrieNode(char character) {
            this.character = character;
        }

    }

    TrieNode root = new TrieNode( ' ');

    public void insert ( String word) {
       char[] chars =   word.toCharArray();
       TrieNode node = root;
       for(char character: chars) {
           if(!node.children.containsKey(character)) {
               node.children.put(character, new TrieNode(character));
           }
           node = node.children.get(character);
       }
       node.isEnd = true;
    }

    List<String> autocomplete(String prefix) {

        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for(char character: chars) {
            if(!node.children.containsKey(character))  return Collections.EMPTY_LIST;
            node = node.children.get(character);
        }
        List<String> res = new LinkedList<>();
        getSuffixes(node, res, prefix);
        return res;
    }

    void getSuffixes(TrieNode node, List<String> suffixList, String suffix) {
        if(node.isEnd) suffixList.add(suffix);

        for (Character character:  node.children.keySet()) {
            getSuffixes(node.children.get(character), suffixList, suffix +  character);
        }
    }

    public static void main(String[] args) {
        TrieAutoComplete t = new TrieAutoComplete();
        t.insert("amazon");
        t.insert("amazon prime");
        t.insert("amazing");
        t.insert("amazing spider man");
        t.insert("amazed");
        t.insert("apple");

        t.autocomplete("amaz");
    }
}

