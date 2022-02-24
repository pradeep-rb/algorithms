package asep20.hacker;



import java.text.DecimalFormat;

public class NumericDataType<T extends  Number> implements DataType<T> {

    @Override
    public void addition(T a, T b) {
        System.out.printf("Adding 2 generic instances");

        double sum = a.doubleValue() + b.doubleValue();
        System.out.printf("The result is: {%s}",  new DecimalFormat("#.##").format(sum));
    }

    @Override
    public void subtraction(T a, T b) {
        System.out.printf("Subtracting 2 generic instances");
        double diff = a.doubleValue() - b.doubleValue();
        System.out.printf("The result is: {%s}",  new DecimalFormat("#.##").format(diff));

    }

    @Override
    public void multiplication(T a, T b) {
        System.out.printf("Multiplying 2 generic instances");
        double product = a.doubleValue() * b.doubleValue();
        System.out.printf("The result is: {%s}",  new DecimalFormat("#.##").format(product));
    }

    @Override
    public void division(T a, T b) {
        System.out.printf("Dividing 2 generic instances");
        double div = a.doubleValue() / b.doubleValue();
        System.out.printf("The result is: {%s}",  new DecimalFormat("#.##").format(div));
    }
}
