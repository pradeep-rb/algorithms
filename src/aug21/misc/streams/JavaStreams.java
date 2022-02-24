package aug21.misc.streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreams {

    public void firstRepeatingChar(String str) {


        System.out.println(  str.chars()
                .mapToObj( s -> Character.toLowerCase(Character.valueOf( (char)s ) ))
                .collect(Collectors.groupingBy(Function.identity(),  LinkedHashMap::new , Collectors.counting()))
                .entrySet()
                .stream()
                .filter ( x -> ( x.getValue() > 1L )  )
                .map( e -> e.getKey())
                .findFirst()
                .get());
    }


    public void findingDuplicates(List<Integer> numList) {

        numList.stream()
                .collect( Collectors.groupingBy( Function.identity(),  LinkedHashMap::new, Collectors.counting() ))
                .entrySet()
                .stream()
                .forEach(System.out::println);

    }

    public void intStreams() {

        IntStream.range(1 , 20)
                .parallel()
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        JavaStreams js = new JavaStreams();

        //js.firstRepeatingChar("Java Hungry Blog Alive is Awesome");

        //js.findingDuplicates(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        js.intStreams();


    }


}
