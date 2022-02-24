package asep20;

import java.util.Arrays;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderLog {

     class  Log  implements Comparable   {

         String identifier;
         String[] words;
         String string;

         public Log(String log) {
             String[] res = log.split(" ");
             identifier = res[0];
             words = Arrays.copyOfRange(res, 1, res.length);
             string = log;
         }

         @Override
         public int compareTo(Object o) {
             Log log =  (Log)o;
             if(Character.isDigit(words[0].charAt(0)) &&
                     Character.isLetter((log.words[0].charAt(0)))) return 1;
             else if( Character.isLetter(words[0].charAt(0)) &&
                     Character.isDigit((log.words[0].charAt(0)))) return -1;
             else if(Character.isDigit(words[0].charAt(0)) &&
                     Character.isDigit((log.words[0].charAt(0)))) return  0;

             for (int i = 0; i < this.words.length && i < log.words.length ; i++) {
                 int  iCompare = this.words[i].compareTo(log.words[i]);
                 if( iCompare == 0) continue;
                 else return iCompare;
             }
             return  identifier.compareTo(log.identifier);

         }
     }


    public String[] reorderLogFiles(String[] logs) {
        Log[] lLogs = new Log[logs.length];

        for (int i = 0; i < logs.length ; i++) {
            lLogs[i] =  new Log(logs[i]);
        }

        Arrays.sort(lLogs);
        String[] ans = new String[lLogs.length];
        for (int i = 0; i < lLogs.length ; i++) {
            ans[i] = lLogs[i].string;
        }

        return  ans;
    }

    public static void main(String[] args) {
        ReorderLog reorderLog = new ReorderLog();
        String[] input = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        System.out.println(reorderLog.reorderLogFiles(input));

    }
}
