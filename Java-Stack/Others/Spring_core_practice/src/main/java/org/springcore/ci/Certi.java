package org.springcore.ci;

public class Certi {
    private String name;

    public Certi(String name) {
        this.name = name;
    }

    public Certi() {
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
