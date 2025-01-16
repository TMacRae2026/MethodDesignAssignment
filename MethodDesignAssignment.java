/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.methoddesignassignment;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author TMacRae2026
 */
public class MethodDesignAssignment {

    public static void main(String[] args) {
        //make 4 students
        Student tyler = new Student("Tyler");
        tyler.addCourse(new Course("AP CSA", 95));
        tyler.addCourse(new Course("Pre Calc", 90));
        tyler.addCourse(new Course("ASL 3", 86));
        
        
        Student noli = new Student("Noli");
        noli.addCourse(new Course("AP CSA", 50));
        noli.addCourse(new Course("Pre Calc", 70));
        noli.addCourse(new Course("French", 100));
        
        Student sam = new Student("Sam");
        sam.addCourse(new Course("AP CSA", 0));
        sam.addCourse(new Course("AP Calc BC", 80));
        sam.addCourse(new Course("AP Lang", 100));
        
        ArrayList annClasses = new ArrayList<Course>();
        annClasses.add(new Course("AP Calc BC", 90));
        annClasses.add(new Course("Engineering Design", 100));
        annClasses.add(new Course("AP CSA", 95));
        Student ann = new Student("Annie", annClasses);
        
        //print all the students
        System.out.println(tyler);
        System.out.println(noli);
        System.out.println(sam);
        System.out.println(ann);
    }
}


class Student {
    
    private String name;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Student(String name, ArrayList<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public Student(String name) {
        this.name = name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
    //Change courses based on index
    /*public void setCourse(int idx, Course course) {
        if (idx >= 0 && idx < courses.size()) {
            courses.set(idx, course);
        } else {
            System.out.println("Tried to insert course: " + course + " but Index " + idx + " out of bounds");
        }
    }*/
    
    //append a new course to the list
    public void addCourse(Course c) {
        courses.add(c);
    }
    
    public double getAverageTestScore() {
        double total = 0;
        for(Course c:courses) {
            total += c.getTestScore();
        }
        return total/courses.size();
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0");
        String result =  this.name + " takes:";
        // add commas inbetween courses
        for(Course c:courses) {
            result += "\n - " + c;
        }
        result += "\nTheir average score is " + df.format(this.getAverageTestScore()) + "%" + "\n";
        return result;
    }
    
}

class Course {
    
    private final String name;
    private int testScore = 0;

    public Course(String name, int testScore) {
        this.name = name;
        this.testScore = testScore;
    }

    public Course(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name + " Score: " + this.testScore;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }
    
}
