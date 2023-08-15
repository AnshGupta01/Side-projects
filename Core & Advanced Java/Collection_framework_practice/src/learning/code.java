package learning;
import javax.xml.namespace.QName;
import java.util.*;

public class code {
    public static void main(String[] args) {
        System.out.println("Java collection running...");

        // 1) Type Safe: Same type of elements can be added
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Ansh");
        strings.add("Aman");
        strings.add("Parth");
        System.out.println(strings);
        strings.remove("Aman");
        System.out.println(strings);
        System.out.println(strings.size());
        System.out.println(strings.contains("Ansh"));
        System.out.println(strings.isEmpty());
        strings.set(1,"Ansh Gupta");
        System.out.println(strings);
        strings.add(0,"ABBB");
        System.out.println(strings);

        //Adding collection to another collection
        Vector<String> abs = new Vector<>();
        abs.addAll(strings);
        System.out.println(abs);

        System.out.println("____________________________________________");

        //Hashset
        HashSet<Double> nms = new HashSet<>();
        nms.add(14.14);
        nms.add(12.22);
        nms.add(454.23);
        nms.add(009.34);
        System.out.println(nms);

        System.out.println("____________________________________________");

        //TreeSet
        TreeSet<Double> tset = new TreeSet<>();
        tset.addAll(nms);
        //Treeset is auto sorted
        System.out.println(tset);

        // 2) Un Type-Safe: Different elements can be added
        LinkedList linkedList = new LinkedList();
        linkedList.add("Hello");
        linkedList.add(1213);
        linkedList.add(true);
        System.out.println(linkedList);
    }
}
