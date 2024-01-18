package org.springcore.ci;

import java.util.List;

public class Person {
    private String name;
    private int personId;
    private Certi certi;
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Person(String name, int personId, Certi certi, List<String> list) {
        this.name = name;
        this.personId = personId;
        this.certi = certi;
        this.list = list;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return this.name + " : " + this.personId+ "{ "+this.certi.getName()+" }";
    }
}
