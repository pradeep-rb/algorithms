package asep20.hacker;


import java.text.DecimalFormat;

public class StringDataType<T extends  String> implements DataType<T> {
    @Override
    public void addition(T a, T b) {
        System.out.printf("Adding 2 Strings");
        System.out.printf("The result is: {%s}",  a.toString() + b.toString() );
    }

    @Override
    public void subtraction(T a, T b) {
        System.out.printf("Can't peform this operation on Strings");
    }

    @Override
    public void multiplication(T a, T b) {
        System.out.printf("Can't peform this operation on Strings");
    }

    @Override
    public void division(T a, T b) {
        System.out.printf("Can't peform this operation on Strings");
    }
}
