package org.elsys.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        University university = new University("PUTKA", 1);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Math", true));
        subjects.add(new Subject("Bel", false));
        subjects.add(new Subject("OOP", true));

        List<Student> students;

        while(scanner.hasNext()){
            String line = scanner.nextLine();

            if(line.equals("END")){
                break;
            }

            List<String> arguments = Arrays.asList(line.split(", "));

            Student student = new Student(
                    arguments.get(0),
                    Integer.parseInt(arguments.get(1)),
                    Double.parseDouble(arguments.get(2))
            );

            System.out.println("name:" + student.getName() + " course:" + student.getCourse() + " avgGrade:" + student.getAverageGrade());

            if(student.getCourse() % 2 == 0){
                student.addUncompletedSubject(subjects.get(0));
            }
            else if(student.getCourse() % 3 == 0){
                student.addUncompletedSubject(subjects.get(1));
            }

            try{
                university.signUpForNextYear(student);
            }catch (EducationalInstitutionException e){
                e.printStackTrace();
            }

        }
    }
}
