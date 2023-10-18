package work;

import java.util.List;
import java.util.stream.Collectors;

public class Methods {
    public static void main(String[] args) {

        //filter (Predicate (boolean value func))
        List<String> names = List.of("Aman","Devansh","Ansh","Parth");
        List<String> a = names.stream().filter(e -> e.startsWith("A")).collect(Collectors.toList());
        System.out.println(a);

        //map: (Function)
        // each element operation
         List<Integer> numbers = List.of(23,4,9,6,7,8);
        List<Integer> collect = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(collect);

        //sort
        numbers.stream().sorted().forEach(System.out::println);

        numbers.stream().min((x,y)-> x.compareTo(y)).get();



    }
}
