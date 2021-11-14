package com.programingSafer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        RecordCatalogue catalogue = new RecordCatalogue();
        File file = new File("/Users/torun/OneDrive/Skrivbord/RecordBookInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String splitter;
        while ((splitter = br.readLine()) != null) {
            var array = splitter.split(":");
            List<Integer> numbers = new ArrayList<>();
            var betyg = array[1].split(",");
            for (var b : betyg) {
                numbers.add(Integer.parseInt(b.trim()));
            }
            catalogue.addStudent(new Student(array[0], new RecordBook(numbers)));
        }
        Scanner sc = new Scanner(System.in);
        boolean b;
        boolean a = true;
        while(a){
            b = true;
            System.out.println("Enter 1 to open the catalogue");
            System.out.println("Enter 0 to exit the program");
            System.out.print("Your number: ");
            int userOption1 = sc.nextInt();
            switch (userOption1){
                case 1:
                    System.out.println("*****************");
                    System.out.println("Students: ");
                    catalogue.printStudent();
                    System.out.println("*****************");
                    System.out.println("Enter a student name: ");
                    String userNameInput = sc.next().toLowerCase(Locale.ROOT).trim();
                    Student student = catalogue.findStudent(userNameInput);
                    if (student == null)
                    {
                        System.out.println("Student doesnt exist");
                    }
                    else {
                        System.out.println("Student name => " + student.getName());
                        System.out.println("Student grades => " + student.getRecordBook().getStudentGrades());
                        while(b){
                            System.out.println("Select between the following: ");
                            System.out.println("1: for highest grade");
                            System.out.println("2: for min grade");
                            System.out.println("3: for average grade");
                            System.out.println("0: to exit");
                            int userGradeOption = sc.nextInt();
                            switch (userGradeOption){
                                case 1:
                                    System.out.println("Max value => " + student.getRecordBook().calcMaxValue());
                                    break;
                                case 2:
                                    System.out.println("Min value => " + student.getRecordBook().calcMinValue());
                                    break;
                                case 3:
                                    System.out.println("Average value => " + student.getRecordBook().calcAverage());
                                    break;
                                case 0: b = false;
                                    break;
                                default:
                                    System.out.println("felaktig inmatning");
                                    break;
                            }
                        }
                    }
                    continue;
                case 0: a=false;
                    break;
                default:
                    System.out.println("Felaktig inmatning");
                    break;
            }
        }
    }
}

