package com.ansh;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "student_details") //marking as entity
@Table(name = "myStudents") //defining table name
public class Student {

    @Id //mark any column as the id
    private int id;
    private String name;
    private String city;
    private Certificate certi;

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Student() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.id+" : "+this.name+" : "+this.city;
    }

    public Certificate getCerti() {
        return certi;
    }

    public void setCerti(Certificate certi) {
        this.certi = certi;
    }
}
