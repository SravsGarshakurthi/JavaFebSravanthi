package com.learn.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    private double marks;

    public Student() {}

    public Student(int id, String name, String email, String course, double marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public int getId()          { return id; }
    public String getName()     { return name; }
    public String getEmail()    { return email; }
    public String getCourse()   { return course; }
    public double getMarks()    { return marks; }

    public void setId(int id)           { this.id = id; }
    public void setName(String name)    { this.name = name; }
    public void setEmail(String email)  { this.email = email; }
    public void setCourse(String course){ this.course = course; }
    public void setMarks(double marks)  { this.marks = marks; }
}