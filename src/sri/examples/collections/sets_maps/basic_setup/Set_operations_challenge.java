package sri.examples.collections.sets_maps.basic_setup;

import java.util.*;

public class Set_operations_challenge {
    public static void main(String[] args) {
        Set<Task> tasks= TaskData.getTasks("all");
        sortAndPrint("All Tasks",tasks);

        Comparator<Task> sortByPriority =Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks= TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks",annsTasks,sortByPriority);
    }
    private static void sortAndPrint(String header, Collection<Task> collection){
        // Remember, I made the Task Comparable, so if I call list.sort with a null, and the list
        // has elements that implement Comparable, it will get sorted using Comparable's compareTo method.
        sortAndPrint(header,collection,null);
    }
    private static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter){
        String lineSeperator="_".repeat(90);
        System.out.println(lineSeperator);
        System.out.println(header);
        System.out.println(lineSeperator);

        List<Task> list=new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }
}
