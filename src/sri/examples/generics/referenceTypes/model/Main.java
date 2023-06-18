package sri.examples.generics.referenceTypes.model;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int studentCount=10;
        List<Student> students=new ArrayList<>();
        for(int i=0;i<studentCount;i++){
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printList(students);

        List<LPAStudent> lpsStudents=new ArrayList<>();
        for(int i=0;i<studentCount;i++){
            lpsStudents.add(new LPAStudent());
        }
        printList(lpsStudents);
    }

    public static <T>void printList(List<T> students){
        for (var student:students){
            System.out.println(student);
        }
        System.out.println();
    }
}
