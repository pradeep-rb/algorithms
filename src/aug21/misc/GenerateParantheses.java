package aug21.misc;

public class GenerateParantheses {

    public void generateP( int l, int r, String str) {

        if(l == 0  && r == 0 ) {
            System.out.println(str);
            return;
        }

        if(l > 0) {
            generateP(l-1, r, str + "(");
        }
        if(r > l) {
            generateP(l, r-1, str + ")");
        }
    }


    public void generateP(int n) {
        generateP( n, n, "");
    }


    public static void main(String[] args) {
        GenerateParantheses gp = new GenerateParantheses();
        gp.generateP(3);
    }
}
