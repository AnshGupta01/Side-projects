package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class streamObject {
    public static void main(String[] args) {

        //Stream API is for Group of objects as well as collections

        //Method1
        Stream<Object> empty = Stream.empty();

        //Method2
        String[] names = {"Ansh","Aman","Parth","Devansh"};
        Stream<String> stream1 = Stream.of(names);
        stream1.forEach(e -> System.out.println(e));

        //Method3
        Stream<Object> stream2 = Stream.builder().build();
        
        //Method4
        Stream<String> stream3 = Arrays.stream(names);
        stream3.forEach(e-> System.out.println(e));
        
        //Method 5 - List, set etc
        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(14);
        list2.add(55);
        list2.add(554);
        Stream<Integer> stream4 = list2.stream();
        stream4.forEach(e-> System.out.println(e));


    }
}
