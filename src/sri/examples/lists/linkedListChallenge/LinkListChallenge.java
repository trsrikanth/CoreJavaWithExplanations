package sri.examples.lists.linkedListChallenge;


import java.util.LinkedList;
import java.util.Scanner;

record Place(String name,int distance){

    @Override
    public String toString() {
        return String.format("%s (%d)",name,distance);
    }
}
public class LinkListChallenge {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit=new LinkedList<>();
        addPlaceToList(placesToVisit,new Place("Srinagar",1893));
        addPlaceToList(placesToVisit,new Place("Bangalore",499));
        addPlaceToList(placesToVisit,new Place("Jaipur",1095));
        addPlaceToList(placesToVisit,new Place("Gandhinagar",885));
        addPlaceToList(placesToVisit,new Place("chennai",516));
        addPlaceToList(placesToVisit,new Place("Port Blair",1664));
        addPlaceToList(placesToVisit,new Place("Shimla",1531));
        addPlaceToList(placesToVisit,new Place("Raipur",542));
        addPlaceToList(placesToVisit,new Place("Goa",517));
        placesToVisit.addFirst(new Place("Hyderabad",0));

        System.out.println(placesToVisit);


        var iterator=placesToVisit.listIterator();
        boolean quitLoop=Boolean.FALSE;
        boolean forward=Boolean.TRUE;
        printMenu();
        while (!quitLoop){
            if(!iterator.hasPrevious()){
                System.out.println("Originating : "+iterator.next());
                forward=Boolean.TRUE;
            }
            if(!iterator.hasNext()){
                System.out.println("Final : "+iterator.previous());
                forward=Boolean.FALSE;
            }
            System.out.println("Enter value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0,1);

            switch (menuItem){
                case "F" :
                    System.out.println("User wants to go forward");
                    if(!forward){   //Reversing direction
                        forward=Boolean.TRUE;
                        if(iterator.hasNext()){
                            iterator.next();  // Adjust position forward
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
                case "B" :
                    System.out.println("User wants to go Backward");
                    if(forward){   //Reversing direction
                        forward=Boolean.FALSE;
                        if(iterator.hasPrevious()){
                            iterator.previous();  // Adjust position backward
                        }
                    }

                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                case "L" :
                    System.out.println(placesToVisit);
                    break;
                case "M" :
                    printMenu();
                    break;
                case "Q" :

                    quitLoop=Boolean.TRUE;
                    break;
                default : quitLoop=Boolean.TRUE;
                            break;
            }
        }
    }

    private static void addPlaceToList(LinkedList<Place> list,Place place){

        for(Place place1:list){
            if(place1.name().equalsIgnoreCase(place.name()))
            {
                System.out.println("Found duplicate place "+place);
                return;
            }
        }
        int matchedIndex=0;
        for(Place listPlace:list){
            if(place.distance()<listPlace.distance()){
                list.add(matchedIndex,place);
                return;
            }
            matchedIndex++;
        }
        list.add(place);
    }

    private static void printMenu(){
        String textBlock = """
                Available actions (select word or letter) :
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""";
        System.out.println(textBlock);
    }
}
