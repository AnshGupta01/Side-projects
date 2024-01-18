package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("_______________________________________________");
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, "Ansh"));
        students.add(new Student(23, "Aman"));
        students.add(new Student(45, "Aman"));
        students.add(new Student(12, "Parth"));
        students.add(new Student(78, "Devansh"));
        students.add(new Student(01, "AnshDev"));

        //also can use anonymous class here
//        Collections.sort(students, new SortByNameThenMarks());

//        using lambda to sort by name then marks
//        Collections.sort(students, (o1, o2) ->{
//            //statement automatically returns a negative, 0 or positive value
//            if(o1.name.equals(o2.name)) return o1.marks - o2.marks;
//            else return o1.name.compareTo(o2.name);
//        });

        //Also works like this (can use reversed keyword to reverse the result also)
        Collections.sort(students, Comparator.comparing(Student::getName).thenComparing(Student::getMarks).reversed());
        students.forEach(System.out::println);

        //using lambda to sort by name only
        Collections.sort(students, Comparator.comparing(o -> o.name));
        students.forEach(System.out::println);

    }
}

//class SortByNameThenMarks implements Comparator<Student>{
//    @Override
//    public int compare(Student o1, Student o2) {
//        if(o1.name.equals(o2.name)){
//            //statement automatically returns a negative, 0 or positive value
//            return o1.marks - o2.marks;
//        }
//        else{
//            return o1.name.compareTo(o2.name);
//        }
//    }
//}
