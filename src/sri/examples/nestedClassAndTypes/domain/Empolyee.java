package sri.examples.nestedClassAndTypes.domain;

import java.util.Comparator;

public class Empolyee {

    public static class EmployeeComparator <T extends Empolyee>
            implements Comparator<Empolyee> {

        private String sortType;

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        public EmployeeComparator() {
            this("name");
        }
        @Override
        public int compare(Empolyee o1, Empolyee o2) {
            if(sortType.equalsIgnoreCase("yearStarted")){
                return o1.yearStarted-o2.yearStarted;
            }
            return o1.name.compareTo(o2.name);
        }
    }
    private int employeeId;
    private String name;
    private int yearStarted;

    public Empolyee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public Empolyee(){

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId,name,yearStarted);
    }



}
