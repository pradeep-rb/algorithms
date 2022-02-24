package jdk.generics;

public interface UnaryPredicate<T extends  Number> {
    boolean test(T num);
}
