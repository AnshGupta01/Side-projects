package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {
    public static void main(String[] args) {

        //create list and filter even numbers from the list
        List<Integer> list1 = List.of(2,4,50,21,22,68,67);

        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(14);
        list2.add(55);
        list2.add(554);

        List<Integer> list3 = Arrays.asList(12, 21, 67, 90, 96);

        //List1

        //without stream api getting even numbers
        List<Integer> listEven = new ArrayList<>();
        for(Integer i: list1){
            if(i%2==0){
                listEven.add(i);
            }
        }
        System.out.println(list1);
        System.out.println(listEven);

        //using stream api
        List<Integer> collect = list1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> collect1 = list1.stream().filter(i -> i > 10).collect(Collectors.toList());
        System.out.println(collect1);

    }
}
