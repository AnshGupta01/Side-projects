package learning;

import java.util.HashMap;

public class Map {
    public static void main(String[] args) {

        HashMap<String, Integer> friends = new HashMap<>();

        //adding elements
        friends.put("Ansh", 400);
        friends.put("Aman", 200);
        friends.put("Dev", 250);
        friends.put("Parth",500);
        friends.put("Parth",3432434);
        friends.put("Ansh", 430);

        //New way to traverse Map
        friends.forEach((e1,e2)-> System.out.println(e1 + "=>"+e2));
    }
}
