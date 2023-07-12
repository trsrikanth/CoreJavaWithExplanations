package sri.examples.collections.maps.sortedmaps;

import java.time.LocalDate;
import java.util.*;

public class SortedMapsMain {
    //What's kind of nice about a map, is that, most of the time you'll be using simpler types as keys, although that's not always going to be true. But the simpler types, like the strings I use for my key in my tree map here, have a natural order, and already implement Comparable
    private static Map<String,Purchase> purchases= new LinkedHashMap<>();
    private static NavigableMap<String,Student> students= new TreeMap<>();

    public static void main(String[] args) {
        Course jmc=new Course("jmc101","Java Master Class","Java");
        Course python= new Course("pyt101","Python Master Clas","Python");

        addPurchase("Mary Martin",jmc,129.99);
        addPurchase("Andy Martin",jmc,139.99);
        addPurchase("Mary Martin",python,149.99);
        addPurchase("Joe Jones",jmc,149.99);
        addPurchase("Bill Brown",python,119.99);

        addPurchase("Chuck Chees",python,119.99);
        addPurchase("Davey Jones",jmc,139.99);
        addPurchase("Eva East",python,139.99);
        addPurchase("Fred Forker",jmc,139.99);
        addPurchase("Greg Brady",python,129.99);

        purchases.forEach((key,value)-> System.out.println(key + ": "+value));
        System.out.println("________________________________________________");
        students.forEach((key,value)-> System.out.println(key + ": "+value));

        NavigableMap<LocalDate,List<Purchase>> datedPurchases=new TreeMap<>();
        for(Purchase purchase: purchases.values()){
            datedPurchases.compute(purchase.purchaseDate(),
                    (pdate,plist)->{
                    List<Purchase> list=
                            (plist==null)?new ArrayList<>():plist;
                    list.add(purchase);
                    return list;
                    });
        }

        System.out.println("________________________________________________");
        datedPurchases.forEach((key,value)-> System.out.println(key + ": "+value));
        System.out.println("________________________________________________");
        int currentYear=LocalDate.now().getYear();
        LocalDate firstDay=LocalDate.ofYearDay(currentYear,1);
        LocalDate week1= firstDay.plusDays(7);
        Map<LocalDate,List<Purchase>> week1Purchases=datedPurchases.headMap(week1);
        Map<LocalDate,List<Purchase>> week2Purchases=datedPurchases.tailMap(week1);
        /*System.out.println("________________________________________________");
        week1Purchases.forEach((key,value)-> System.out.println(key + ": "+value));
        System.out.println("________________________________________________");
        week2Purchases.forEach((key,value)-> System.out.println(key + ": "+value));*/
        displayStats(1,week1Purchases);
        displayStats(2,week2Purchases);

        //TreeMap has last key and first key methods, and lastEntry and firstEntry,poll last key and poll first key.
        System.out.println("________________________________________________");
        LocalDate lastDate= datedPurchases.lastKey();
        var previousEntry=datedPurchases.lastEntry();
        while (previousEntry!=null){
            List<Purchase> lastDaysData = previousEntry.getValue();
            System.out.println(lastDate+" purchases : "+lastDaysData.size());
            LocalDate prevDate=datedPurchases.lowerKey(lastDate);
            previousEntry=datedPurchases.lowerEntry(lastDate);
            /*LocalDate prevDate=datedPurchases.floorKey(lastDate);
            previousEntry=datedPurchases.floorEntry(lastDate);*/
            lastDate=prevDate;
        }
        System.out.println("________________________________________________");
        var reversed=datedPurchases.descendingMap();
        LocalDate firstDate=reversed.firstKey();
        //var nextEntry=reversed.firstEntry();
        var nextEntry=reversed.pollFirstEntry();
        while (nextEntry!=null){
            List<Purchase> lastDaysData = nextEntry.getValue();
            System.out.println(firstDate+" purchases : "+lastDaysData.size());

            LocalDate nextDate=reversed.higherKey(firstDate);
            //nextEntry=reversed.higherEntry(firstDate);
            nextEntry=reversed.pollFirstEntry();
            firstDate=nextDate;
        }
        //poll methods, pollFirstEntry and pollLastEntry, remove data from the map, on each subsequent call.
        System.out.println("________________________________________________");
        datedPurchases.forEach((key,value)->System.out.println(key+": "+value));

    }

    private static void addPurchase(String name,Course course,double price){
        Student existingStudent = students.get(name);
        if(existingStudent==null){
            existingStudent=new Student(name,course);
            students.put(name,existingStudent);
        }else {
            existingStudent.addCourse(course);
        }

        int day= new Random().nextInt(1,15);
        String key=course.courseId()+"_"+existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(),existingStudent.getId(),price,year,day);
        purchases.put(key,purchase);
    }

    private static void displayStats(int period,Map<LocalDate,List<Purchase>> periodData){
        System.out.println("________________________________________________");
        Map<String,Integer> weeklyCounts=new TreeMap<>();
        periodData.forEach((key,value)-> {
            System.out.println(key + ": " + value);
            for (Purchase p : value) {
                weeklyCounts.merge(p.courseId(), 1,(prev,curr)->{
                    return prev + curr;
                });
            }
        });
        System.out.printf("Week %d purchases = %s%n",period,weeklyCounts);
    }
}
