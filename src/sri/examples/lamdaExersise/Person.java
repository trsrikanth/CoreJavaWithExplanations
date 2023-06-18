package sri.examples.lamdaExersise;

public class Person {
    private String fname;
    private String lname;
    private int age;

    public Person(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public String getLname() {
        return lname;
    }

    public Person() {
    }

    @Override
    public String toString() {
        /*return "Person{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                '}';*/
       return  "%-15s %-15s age is %d ".formatted(fname,lname,age);
    }


}
