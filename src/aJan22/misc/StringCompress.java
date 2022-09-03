package aJan22.misc;

//443
/*

    lessons learnt : one thing at a time, dont club
    check weather  if, if would better than if, else if

 */
public class StringCompress {



    public static int compress(char[] chars) {
        StringBuilder ans = new StringBuilder();

        char prev = chars[0];
        int currCnt = 0;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == prev) currCnt++;
            if(chars[i] != prev ) {
                ans.append( currCnt == 1 ? prev :  prev + "" + currCnt );
                currCnt = 1;
            }
            if(i == chars.length - 1) {
                ans.append( currCnt == 1 ? chars[i] :  chars[i] + "" + currCnt );
            }
            prev = chars[i];
        }
        System.out.print(ans.toString() + " ");
        return ans.length();
    }


    public static void main(String[] args) {
        System.out.println( StringCompress.compress(new char[] {'a','a','b','b','c','c','c'}) );
        System.out.println( StringCompress.compress(new char[] {'a'}) );
        System.out.println( StringCompress.compress(new char[] {'a','a','b'}) );
        System.out.println( StringCompress.compress(new char[] {'a','a','b','b','c','c','c','c','c','c','c','c','c','c','c','c'}) );
        System.out.println( StringCompress.compress(new char[] {'a','c','c','c','c','c','c','c','c','c','c','c','c'}) );
        System.out.println( StringCompress.compress(new char[] {'a','b'}) );
        //613742
    }
}
