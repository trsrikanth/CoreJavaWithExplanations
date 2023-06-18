package sri.examples.nestedClassAndTypes.domain;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empolyee> empolyees=new ArrayList<>(List.of(
                new Empolyee(10001,"Ralph",2015),
                new Empolyee(10005,"Carole",2021),
                new Empolyee(10022,"Jane",2013),
                new Empolyee(13151,"Laura",2020),
                new Empolyee(10050,"Jim",2018)
        ));


        empolyees.sort(new Empolyee.EmployeeComparator<>("yearstarted").reversed());

        for(Empolyee empolyee:empolyees){
            System.out.println(empolyee);
        }

        System.out.println("Store Members");


        List<StoreEmployee> storeEmpolyees=new ArrayList<>(List.of(
                new StoreEmployee(10015,"Meg",2019,"Target"),
                new StoreEmployee(10515,"Joe",2021,"Walmart"),
                new StoreEmployee(10105,"Tom",2020,"Macys"),
                new StoreEmployee(10215,"Marty",2018,"Walmart"),
                new StoreEmployee(10322,"Bud",2016,"Target")
        ));

        //var genericEmployee = new StoreEmployee();
        var comparator=new StoreEmployee().new StoreComparator<>();

        storeEmpolyees.sort(comparator);
        for(StoreEmployee employee:storeEmpolyees){
            System.out.println(employee);
        }

    }


}
