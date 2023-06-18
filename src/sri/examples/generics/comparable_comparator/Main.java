package sri.examples.generics.comparable_comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer five=5;
        Integer[] others={0,5,10,-50,50};
        for(Integer i:others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d : compare to %d%n",five,
                    (val==0?"==":val<0?"<":">"),i,val);
        }

        String banana="banana";
        String[] fruits={"apple","BANANA","mangoes","banana","pear"};

        for(String fruit:fruits){
            int val = banana.compareTo(fruit);
            System.out.printf("%s %s %s : compare to %d%n",banana,
                    (val==0?"==":val<0?"<":">"),fruit,val);
        }

        Arrays.sort(fruits);
        System.out.println(Arrays.toString(fruits));

        System.out.println("A:"+(int)'A'+" "+"a:"+(int)'a');
        System.out.println("B:"+(int)'B'+" "+"b:"+(int)'b');
        System.out.println("P:"+(int)'P'+" "+"p:"+(int)'p');

        Student tir=new Student("Tiru");
        Student[] students = {new Student("Zaheer"),new Student("Tiru"),new Student("Amar")};

        Arrays.sort(students); // results java.lang.ClassCastException as students is not yet implementing comparable  yet.
        System.out.println(Arrays.toString(students));

        System.out.println(tir.compareTo(new Student("TIRU")));

        Comparator<Student> gpaSorter=new StudentGPAComparator();
        Arrays.sort(students,gpaSorter.reversed());
        System.out.println(Arrays.toString(students));

     }

}

class StudentGPAComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa+o1.name).compareTo(o2.gpa + o2.name);
    }
}
class Student implements Comparable<Student>{
    private static int LAST_ID=1000;
    private static Random random=new Random();

     String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id =LAST_ID++;
        gpa = random.nextDouble(1.0,4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id,name,gpa);
    }


    @Override
    public int compareTo(Student o) {
        //return name.compareTo(o.name);
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}
