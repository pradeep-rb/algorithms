package general;

public class PatternMatchCorrect {

        public boolean isMatch(String text, String pattern) {

            if(pattern.isEmpty()) return text.isEmpty();
            else {
                boolean firstMatch = !text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0)  == '.');
                if(pattern.length() > 1 && pattern.charAt(1) == '*')  {

                    return   isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern)) ;
                }
                else {
                    return firstMatch && isMatch(text.substring(1), pattern.substring(1));
                }

            }

        }

    public static void main(String[] args) {
        PatternMatchCorrect patternMatch = new PatternMatchCorrect();

//        System.out.println(patternMatch.isMatch("bdaaaaaa","b.d.a*"));
//        System.out.println(patternMatch.isMatch("bdaaaaaa","bda*"));
        //System.out.println(patternMatch.isMatch("aaab",".*b"));
        //System.out.println(patternMatch.isMatch("ab",".*"));
//        System.out.println(patternMatch.isMatch("aa","a"));
        System.out.println(patternMatch.isMatch("aa","a*"));
       // System.out.println(patternMatch.isMatch("aab","c*a*b"));
        //System.out.println(patternMatch.isMatch("mississippi","mis*is*ip*."));
        //System.out.println(patternMatch.isMatch("ab",".*c"));
        //System.out.println(patternMatch.isMatch("aaaaa","a*"));
        //System.out.println(patternMatch.isMatch("aaaaa","a*b"));
       // System.out.println(patternMatch.isMatch("aa","a"));
        //System.out.println(patternMatch.isMatch("aa","a"));
//        System.out.println(patternMatch.isMatch("aaa","a*a"));
       // System.out.println(patternMatch.isMatch("aab","a*b"));
        // aab  b  or  a a && ab a  *b

        //bdaaaaaa","b.d.a*
        //aa,a
        //aa, .*
    }
}
