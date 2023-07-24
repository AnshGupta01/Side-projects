package project;

public class Main {
    public static void main(String[] args) {
        System.out.println("The Project starts...");
//        MyInterface i = new MyInterface() {
//            @Override
//            public void sayHello() {
//                System.out.println("Hello from anonymous class interface");
//            }
//        };
//        i.sayHello();
//        MyInterface i2 = new MyInterface() {
//            @Override
//            public void sayHello() {
//                System.out.println("This is the second anonymous class");
//            }
//        };
//        i2.sayHello();

        //using our interface with the help of lambda
        MyInterface i = () -> System.out.println("Lambda class");
        i.sayHello();

        MyInterface i2 = () -> System.out.println("second lambda class");
        i2.sayHello();

        SumInterface s = (a, b) -> a+b;
        System.out.println(s.sum(2,5));
        System.out.println(s.sum(10,7));

        LengthInterface l = (str) -> str.length();
        System.out.println("Length of the String is: "+l.getLen("Ansh Gupta"));
    }
}
