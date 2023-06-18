package sri.examples.nestedClassAndTypes.domain;

import java.util.Comparator;

public class EmployeeComparator <T extends Empolyee> implements Comparator<Empolyee> {


    @Override
    public int compare(Empolyee o1, Empolyee o2) {

        return o1.getName().compareTo(o2.getName());
    }
}
