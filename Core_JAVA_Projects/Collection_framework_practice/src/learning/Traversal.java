package learning;

import java.util.*;

public class Traversal {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Ansh");
        strings.add("Aman");
        strings.add("Parth");
        strings.add("Chaman");
        strings.add("Hello");
        strings.add("Bye");

        System.out.println(strings);

        //for each loop
        for(String str: strings){
            System.out.print(str + "\t" + str.length() + "\t");
            StringBuffer br = new StringBuffer(str);
            System.out.println(br.reverse());
        }

        System.out.println("_____________Iterator______________");

        //Traversing using iterator
        Iterator<String> itr = strings.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("____________List Iterator_______________");

        //Backward Traversal (have to pass size)
        ListIterator<String> itr2 = strings.listIterator(strings.size());
        while(itr2.hasPrevious()){
            System.out.println(itr2.previous());
        }

        System.out.println("___________Enumeration_____________");

        //Enumeration (only works with legacy classes)
        //hence collections keyword converts arraylist
        Enumeration<String> enumeration = Collections.enumeration(strings);
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());

        System.out.println("_______________For Each______________");

        //For each method
        strings.forEach(e-> System.out.println(e));

        System.out.println("__________Sorted Treeset__________");

        //TreeSet
        TreeSet<String> set = new TreeSet<>();
        set.addAll(strings);
        set.forEach(str-> System.out.println(str));

    }
}
