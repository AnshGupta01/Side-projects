package org.springcore.ref;

public class B {
    private int Y;

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public String toString() {
        return "B{" +
                "Y=" + Y +
                '}';
    }

    public B(int y) {
        Y = y;
    }

    public B() {
    }
}
