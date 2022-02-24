package practice;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

    static  int cnt = 0;

    public String longestPalindrome(String s) {
        Map<String, String> lookup =  new HashMap<>();
        if(s == null || s.isEmpty()) {
            return  "";
        }
        return longestPalindrome(s, 0, s.length(), lookup);
    }


    public String longestPalindrome(String s, int i, int j, Map<String, String> lookup) {
        cnt++;

         if(i == j || i > j) return "";

         String key = i + ":" + j;
         if(!lookup.containsKey(key)) {

             if (isPalindrome(s.substring(i, j))) {
                 //lookup.put(key,  s.substring(i, j));
                 return  s.substring(i, j);
             }
             else {

                 String left = longestPalindrome(s, i + 1, j, lookup);
                 String right = longestPalindrome(s, i, j - 1, lookup);

                 return left.length() > right.length() ? left : right;
             }
         }

         return  lookup.get(key);


    }



        public boolean isPalindrome(String text) {
            //String clean = text.replaceAll("\\s+", "").toLowerCase();
            StringBuilder plain = new StringBuilder(text);
            StringBuilder reverse = plain.reverse();
            return (reverse.toString()).equals(text);
        }

    public static void main(String[] args) {

        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        //System.out.println(lps.longestPalindrome("4abba53333"));
        System.out.println(lps.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
        System.out.println(cnt);

        //System.out.println(lps.longestPalindrome("jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcowskjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmlsuacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzconeuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwfqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsyomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoegamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvlbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepbmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbxzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanilsyyklpbxpqosoqpuolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzirsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfytfabx"));
    }
}
