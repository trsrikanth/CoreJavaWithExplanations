package sri.examples.lists;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListExamples {
    public static void main(String[] args) {
        //LinkedList<String> placesToVisit1=new LinkedList<>(); // we can use this way also.
        var placesToVisit= new LinkedList<String>();

        placesToVisit.add("Rajendra Nagar");
        placesToVisit.add(0,"Hyderabad");
        placesToVisit.add("Golkonda");
        placesToVisit.add("Pune");
        placesToVisit.add("Andaman");
        placesToVisit.add("Dargling");

        System.out.println(placesToVisit);
        System.out.println("-".repeat(20));
        addMorePlaces(placesToVisit);
        System.out.println(placesToVisit);
        System.out.println("-".repeat(20));
        removePlaces(placesToVisit);
        System.out.println("-".repeat(20));
        gettingElements(placesToVisit);
        System.out.println("-".repeat(20));
        printItinerary(placesToVisit);
        System.out.println("-".repeat(20));
        printItineraryUsingEnhancedForLoop(placesToVisit);
        System.out.println("-".repeat(20));
        printItineraryUsingListIterator(placesToVisit);
        System.out.println("-".repeat(20));
        operationsUsingIterator(placesToVisit);
        System.out.println("-".repeat(20));
        operationsUsingListIterator(placesToVisit);

    }

    private static void addMorePlaces(LinkedList<String> placesToVisit){
        placesToVisit.addFirst("New Delhi");
        placesToVisit.addLast("Choor baazar");

        //Queue methods
        placesToVisit.offer("Bangalore");
        placesToVisit.offerFirst("Jaipur");
        placesToVisit.offerLast("Chenni");

        //Stack methods
        placesToVisit.push("Warangal");

    }

    private static void removePlaces(LinkedList<String> placesToVisit){
        placesToVisit.remove(3);
        placesToVisit.remove("Warangal");

        System.out.println(placesToVisit);
        String removedPlace1=placesToVisit.remove();//removes first element
        System.out.println(removedPlace1 + " was removed");
        System.out.println(placesToVisit);

        String removedPlace2=placesToVisit.removeFirst();//removes first element
        System.out.println(removedPlace2 + " was removed");
        System.out.println(placesToVisit);

        String removedPlace3=placesToVisit.removeLast();//removes last element
        System.out.println(removedPlace3 + " was removed");
        System.out.println(placesToVisit);

        //Queue or Dqueue methods
        String removedPlace4=placesToVisit.poll();//removes last element
        System.out.println(removedPlace4 + " was removed");
        System.out.println(placesToVisit);

        String removedPlace5=placesToVisit.pollFirst();//removes First element
        System.out.println(removedPlace5 + " was removed");
        System.out.println(placesToVisit);

        String removedPlace6=placesToVisit.pollLast();//removes last element
        System.out.println(removedPlace6 + " was removed");
        System.out.println(placesToVisit);

        // stack operations
        String removedPlace7=placesToVisit.pop();//removes
        System.out.println(removedPlace7 + " was removed");
        System.out.println(placesToVisit);

    }

    private static void gettingElements(LinkedList<String> list){
        System.out.println("Retrieving element = "+list.get(2));
        System.out.println("Get First = "+list.getFirst());
        System.out.println("Get Last = "+ list.getLast());
        System.out.println("Andaman is at position "+list.indexOf("Andaman"));
        System.out.println("Dargling is at position "+list.lastIndexOf("Dargling"));

        //Queue retrieval methods. first in first out
        System.out.println("Element from elements "+list.element());

        //Stack retrieval methods.
        System.out.println("Elements from peak "+list.peek());
        System.out.println("Elements from peak first "+list.peekFirst());
        System.out.println("Elements from peak last "+list.peekLast());

    }

    private static void printItinerary(LinkedList<String> placesToVisit){
        placesToVisit.addAll(List.of("Pune","Mysore","Srinagar","Kolkatta","Munnar"));

        System.out.println("Trip Starts at "+placesToVisit.getFirst());
        for(int i =1;i<placesToVisit.size();i++){
            System.out.println("-->From: "+placesToVisit.get(i-1) +" To "+ placesToVisit.get(i));
        }
        System.out.println("Trips ends at "+placesToVisit.getLast());


    }

    private static void printItineraryUsingEnhancedForLoop(LinkedList<String> placesToVisit){
        placesToVisit.addAll(List.of("Pune","Mysore","Srinagar","Kolkatta","Munnar"));
        System.out.println("Trip Starts at "+placesToVisit.getFirst());
        String previousTown=placesToVisit.getFirst();
        System.out.println("Trip Starts at "+placesToVisit.getFirst());
        for(String str:placesToVisit){
            System.out.println("-->From: "+previousTown +" To "+ str);
            previousTown=str;
        }
        System.out.println("Trips ends at "+placesToVisit.getLast());


    }

    private static void printItineraryUsingListIterator(LinkedList<String> placesToVisit){
        System.out.println("Trip Starts at "+placesToVisit.getFirst());
        String previousTown=placesToVisit.getFirst();
        ListIterator<String> iterator= placesToVisit.listIterator();
        while (iterator.hasNext()){
            System.out.println("-->From: "+previousTown +" To "+ iterator.next());
        }
    }

    private static void operationsUsingIterator(LinkedList<String> placesToVisit){
        var iterator=placesToVisit.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("Choor baazar")){
                iterator.remove();
            }
        }
        System.out.println(placesToVisit);
    }

    private static void operationsUsingListIterator(LinkedList<String> placesToVisit){
        var iterator=placesToVisit.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("Pune")){
                iterator.add("Dwarika");
            }
        }
        System.out.println(placesToVisit);

        // below while loop to print again will not work as iterator pointer shifted to end and it cannot be reset
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //iterating backwards
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }

        // iterator to start with some specified position
        var iterator2=placesToVisit.listIterator(3);
        System.out.println(iterator2.next());
    }
}
