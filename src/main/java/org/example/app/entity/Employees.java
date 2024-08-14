package org.example.app.entity;

public class Employees {

    private Long id;
    private String name;
    private int age;
    private String position;
    private double salary;

    public Employees() {
    }

    public Employees(Long id, String name,int age,
                     String position, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "id " + id +
                ", " + name + " " + age +
                ", " + position + " " + salary + "\n";
    }
}
