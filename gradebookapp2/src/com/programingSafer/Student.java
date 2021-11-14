package com.programingSafer;

public class Student {

    public Student (String name, RecordBook book){
        studentName = name;
        recordBook = book;
    }
    public Student (String name){
        studentName = name;
    }

    private String studentName;
    private RecordBook recordBook;

    public RecordBook getRecordBook() {
        return recordBook;
    }
    public String getName() {
        return studentName;
    }
}
