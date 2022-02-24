package jdk.generics;

public class Exchange {

    public  <T> T[] exchange(T[] input, int i, int j){

        T temp = input[j];
        input[j] = input[i];
        input[i] = temp;

        return  input;
    }

}
