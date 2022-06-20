package aJan22.Trie;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class BinaryAutoComplete {
    TrieNode root = new TrieNode( ' ', -1);

    class TrieNode {
        char character;
        Map<Character, TrieNode> children =  new HashMap<>();
        int cmdIdx;

        public TrieNode(char character, int cmdIdx) {
            this.character = character;
            this.cmdIdx = cmdIdx;
        }

        public int insert (String command, int cmdIdx) {
            int i = 0;
            TrieNode node = root;
            int prevCommand = cmdIdx - 1;
            while (i < command.length() && node.children.containsKey(command.charAt(i))) {
                node = node.children.get(command.charAt(i));
                prevCommand = node.cmdIdx;
                node.cmdIdx = cmdIdx; i++;
            }

            while (i < command.length()) {
                char currChar = command.charAt(i);
                TrieNode next = new TrieNode(currChar, cmdIdx);
                node.children.put(currChar, next);
                node = next; i++;
            }

            return prevCommand;
        }
    }


    List<Integer> autoComplete(String[] commands) {
        List<Integer>  autoComplete = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            autoComplete.add( root.insert(commands[i], i+1));
        }
        return autoComplete;
    }

    public static void main(String[] args) {
        BinaryAutoComplete bac = new BinaryAutoComplete();
        bac.autoComplete(new String[] { "000", "1110", "01", "001", "110", "11"  } ).stream().forEach( System.out::println);
    }
}
