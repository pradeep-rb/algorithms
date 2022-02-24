package general;

import java.util.*;
import java.util.stream.Collectors;

public class InvalidTransactions {

    public List<String> invalidTransactions(String[] transactions) {
        Set<String> invalidTxn = new HashSet<>();

        for (int i = 0; i < transactions.length; i++) {
            String[] txn =  transactions[i].split(",");
            if( Integer.parseInt(txn[2])  > 1000 ) {
                invalidTxn.add(transactions[i]);
            }
        }


        for (int i = 0; i < transactions.length; i++) {
            String[] txni =  transactions[i].split(",");
           // if( invalidTxn.contains(transactions[i])) continue;
            for (int j = 0; j <transactions.length ; j++) {
                if(i == j) continue;
                if( invalidTxn.contains(transactions[j])) continue;
                String[] txnj =  transactions[j].split(",");
                if(txni[0].equalsIgnoreCase(txnj[0]) &&
                        ! txni[3].equalsIgnoreCase(txnj[3])
                        && Math.abs(Integer.parseInt(txni[1]) - Integer.parseInt(txnj[1])) <= 60 ) {
                    invalidTxn.add(transactions[i]);
                    invalidTxn.add(transactions[j]);
                    break;
                }

            }

        }

        return  invalidTxn.stream()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        InvalidTransactions it = new InvalidTransactions();

        System.out.println(it.invalidTransactions(new String[] {"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona",
                "bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"}));

    }
}
