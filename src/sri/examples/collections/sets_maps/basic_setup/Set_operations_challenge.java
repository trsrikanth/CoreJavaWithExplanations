package sri.examples.collections.sets_maps.basic_setup;

import java.util.*;

public class Set_operations_challenge {
    public static void main(String[] args) {
        Set<Task> tasks= TaskData.getTasks("all");
        sortAndPrint("All Tasks",tasks);

        Comparator<Task> sortByPriority =Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks= TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks",annsTasks,sortByPriority);


        Set<Task> bobsTasks=TaskData.getTasks("Bob");
        Set<Task> carolsTasks=TaskData.getTasks("Carol");

        List<Set<Task>> sets=List.of(annsTasks,bobsTasks,carolsTasks);
        Set<Task> assignedTasks= getUnion(sets);
        sortAndPrint("Assigned tasks",assignedTasks);
        Set<Task> everyTask= getUnion(List.of(tasks,assignedTasks));
        sortAndPrint("True all tasks",everyTask);

        Set<Task> missingTask=getDifference(everyTask,tasks);
        sortAndPrint("Missing Tasks",missingTask);

        Set<Task> unAssignedTasks=getDifference(tasks,assignedTasks);
        sortAndPrint("Un Assigned tasks",unAssignedTasks,sortByPriority);

        Set<Task> overlap=getUnion(List.of(
                getIntersect(annsTasks,bobsTasks),
                getIntersect(annsTasks,carolsTasks),
                getIntersect(bobsTasks,carolsTasks)));
        sortAndPrint("Assigned to multiples",overlap);

        List<Task> overLapping = new ArrayList<>();
        for(Set<Task> set:sets){
            Set<Task> dupes=getIntersect(set,overlap);
            overLapping.addAll(dupes);
        }

        Comparator<Task> priorityNatural=sortByPriority.thenComparing(Comparator.naturalOrder());

        sortAndPrint("Overlapping",overLapping,priorityNatural);

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



    private static Set<Task> getUnion(List<Set<Task>> sets){
        Set<Task> union=new HashSet<>();
        sets.forEach(set -> union.addAll(set));
        return union;
    }

    private static Set<Task> getIntersect(Set<Task> firstSet,Set<Task> secondSet){
        Set<Task> intersect=new HashSet<>();
        intersect.addAll(firstSet);
        intersect.retainAll(secondSet);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> firstSet,Set<Task> secondSet){
        Set<Task> difference=new HashSet<>();
        difference.addAll(firstSet);
        difference.removeAll(secondSet);
        return difference;
    }
}
