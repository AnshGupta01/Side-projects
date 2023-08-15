package org.springcore.ci;

public class Addition {
    private int A;
    private int B;

    public Addition(double a, double b) {
        this.A = (int)a;
        this.B = (int)b;
        System.out.println("Constructor : double, double");
    }
    public Addition(int a, int b) {
        A = a;
        B = b;
        System.out.println("Constructor  : int, int");
    }
    public Addition(String a, String b) {
        this.A = Integer.parseInt(a);
        this.B = Integer.parseInt(b);
        System.out.println("Constructor : String, String");
    }

    public void doSum(){
        System.out.println("sum is= " + (this.A + this.B));
        System.out.println("Value of A: "  + this.A);
        System.out.println("Value of B: "  + this.B);

    }

}
