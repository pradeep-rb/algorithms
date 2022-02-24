package general;

public class PatternMatch {

    public boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()) return  true;
        else  if(!s.isEmpty() && p.isEmpty()) return false;
        else  if(s.isEmpty() && !p.isEmpty()) return false;
        else {
            boolean firstMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
            if(firstMatch) {

                if ( p.length() == 1) return isMatch(s.substring(1), p.substring(1));
                else if ( p.charAt(0) == '.' && p.charAt(1) == '*') {
                    if(p.length() > 2) {
                        int i = 0;
                        while (i < s.length() && s.charAt(i) != p.charAt(2)) {
                            i++;
                        }
                        return isMatch(s.substring(i ), p.substring(2));
                    }
                    else return true;
                }
                else if ( p.charAt(1) == '*') {
                    int i = 0;
                    while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                        i++;
                    }
                    return isMatch(s.substring(i + 1), p.substring(2));
                } else if (p.charAt(1) == '.') {
                    return isMatch(s.substring(1), p.substring(1));
                }
                else {
                    return isMatch(s.substring(1), p.substring(1));
                }
            }
            else if(p.charAt(1) == '*') {
                return isMatch(s, p.substring(2));
            }
        }

        return  false;
    }


    public static void main(String[] args) {
        PatternMatch patternMatch = new PatternMatch();

//        System.out.println(patternMatch.isMatch("bdaaaaaa","b.d.a*"));
//        System.out.println(patternMatch.isMatch("aaaaaa",".*"));
//        System.out.println(patternMatch.isMatch("aa","a"));
       // System.out.println(patternMatch.isMatch("aab","c*a*b"));
       // System.out.println(patternMatch.isMatch("mississippi","mis*is*ip*."));
        //System.out.println(patternMatch.isMatch("ab",".*c"));
        //System.out.println(patternMatch.isMatch("aa","a"));
//        System.out.println(patternMatch.isMatch("aaa","a*a"));

        //bdaaaaaa","b.d.a*
        //aa,a
        //aa, .*
    }
}
