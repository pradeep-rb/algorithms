package practice;

import java.util.*;
import java.util.stream.Collectors;

public class InvalidTransactions {


    public  List<String> addToList(List<String> list, String s ) {
        list.add(s);
        return  list;
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<String>> invalidTxn = new HashMap<>();
        Map<String, List<String>> allTxn = new HashMap<>();


        for(String transaction : transactions) {
           String[] txn =  transaction.split(",");
           if( Integer.parseInt(txn[2])  > 1000 ) {
               invalidTxn.put(txn[0],  addToList(invalidTxn.getOrDefault(txn[0], new ArrayList<>()), transaction) );
           }
           else if(allTxn.containsKey(txn[0]) ) {
               for(String txnByName : allTxn.get(txn[0])) {
                   String[] txnByNameParts  = txnByName.split(",");
                   int timeDiff =   Integer.parseInt(txn[1]) - Integer.parseInt(txnByNameParts[1]) ;
                   if(!txnByNameParts[3].equalsIgnoreCase(txn[3]) && timeDiff <= 60) {
                       invalidTxn.put(txn[0], addToList(invalidTxn.getOrDefault(txn[0], new ArrayList<>()), transaction));
                       invalidTxn.put(txn[0], addToList(invalidTxn.getOrDefault(txn[0], new ArrayList<>()), txnByName));
                   }
               }
           }
//            allTxn.put(txn[0], allTxn.getOrDefault(txn[0], Arrays.asList(transaction)));
            allTxn.put(txn[0], addToList(invalidTxn.getOrDefault(txn[0], new ArrayList<>()), transaction));

        }

        return  invalidTxn.values().stream()
                .flatMap(item -> item.stream())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        InvalidTransactions it = new InvalidTransactions();

//        System.out.println(it.invalidTransactions(new String[] {"alice,20,800,mtv","alice,50,100,beijing"}));
//        System.out.println(it.invalidTransactions(new String[] {"alice,20,800,mtv","alice,50,1200,mtv"}));
//        System.out.println(it.invalidTransactions(new String[] {"alice,20,800,mtv","bob,50,1200,mtv"}));
        System.out.println(it.invalidTransactions(new String[] {"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona",
                "bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"}));
//        System.out.println(it.invalidTransactions(new String[] {"bob,689,1910,barcelona",
//       "bob,832,1726,barcelona","bob,820,596,bangkok"}));
    }
}
