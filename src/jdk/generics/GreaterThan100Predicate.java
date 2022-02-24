package jdk.generics;

public class GreaterThan100Predicate implements UnaryPredicate {
    @Override
    public boolean test(Number num) {
        return num.intValue() > 100 ;
    }
}
