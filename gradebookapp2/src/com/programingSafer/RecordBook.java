package com.programingSafer;

import java.util.Collections;
import java.util.List;

public class RecordBook {

    public RecordBook(List<Integer> grades) {
        studentGrades = grades;
    }

    private List<Integer> studentGrades;

    public List<Integer> getStudentGrades() {
        return studentGrades;
    }
    public Integer calcMaxValue(){
        Collections.sort(studentGrades);
        return studentGrades.get(studentGrades.size()-1);
    }
    public Integer calcMinValue(){
        Collections.sort(studentGrades);
        return studentGrades.get(0);
    }
    public Integer calcAverage(){
        int tot = 0;
        for (var item: studentGrades){
            tot = tot+item;
        }
        var average = tot/studentGrades.size();
        return average;
    }
}
