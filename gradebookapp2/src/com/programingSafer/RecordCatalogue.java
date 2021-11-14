package com.programingSafer;

import java.util.ArrayList;
import java.util.List;


public class RecordCatalogue {

    public RecordCatalogue (){
        students = new ArrayList<>();
    }

    private List <Student> students;

    public List<Student> getStudents(){
        return students;
    }
    public void addStudent(Student student){
        students.add(student);
    }

    public void printStudent(){
        for (var a : getStudents()) {
            System.out.println(a.getName());
        }
    }
    public Student findStudent(String name){
        Student student;
        for (int i = 0 ;i<students.size() ; i++){
            student = students.get(i);
            if (name.equals(student.getName())){
                return student;
            }
        }
        return null;
    }
}

