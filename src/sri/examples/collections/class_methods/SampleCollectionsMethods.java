package sri.examples.collections.class_methods;

import sri.examples.collections.basic_setup.Card;

import java.util.*;

public class SampleCollectionsMethods {
    public static void main(String[] args) {
        /*List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);*/

        Card[] cardArray=new Card[13];
        Card aceOfHearts=Card.getFaceCard(Card.Suit.HEART,'A');
        Arrays.fill(cardArray,aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray),"Aces of Heart",1);

        /*
        Collections.fill method on collections looks a lot like Arrays.fill, so you'd expect to get an array
        of 52 cards back, all aces of hearts. Running this code though, shows that's not what really happens.
        Instead, the list is empty, and the size of the list is zero.
        When I initialize the ArrayList, passing it 52, it just sets the capacity to 52.
        It doesn't populate the list with elements.

        Unlike an array, the list isn't populated with 52 null references for example.
        Using fill here, on the Collections class, would fill the list (if it's size were greater than zero),
        meaning it would replace every element with the element passed to the method.
        The fill method doesn't actually add elements, so if my list is empty, it stays empty.
         */
        List<Card> cards=new ArrayList<>(52);
        Collections.fill(cards,aceOfHearts);
        System.out.println(cards);
        System.out.println("Cards.size() = "+cards.size());

        /*
        How can I fill this list with some default value? The Collections class offers us some alternatives.
        One of these methods is called nCopies, which creates a new list, with the number of elements
        you specify as the first argument, filling it with the element you pass as the second argument.
         */

        List<Card> acesOfHearts = Collections.nCopies(13,aceOfHearts);
        Card.printDeck(acesOfHearts,"Aces of Hearts",1);

        Card kingOFClubs=Card.getFaceCard(Card.Suit.CLUB,'K');
        List<Card> kingsOfClubs = Collections.nCopies(13,kingOFClubs);
        Card.printDeck(kingsOfClubs,"Kings of Clubs",1);

        Collections.addAll(cards,cardArray);
        Collections.addAll(cards,cardArray);
        Card.printDeck(cards,"Card Collection with Aces added",2);

        /*
        What I want you to understand here, is that this method, copies elements from one list to another,
        it doesn't return a copy of your list. Elements are being assigned to the
        existing destination list, vs.a copy of the list being made.
         */
        Collections.copy(cards,kingsOfClubs);
        Card.printDeck(cards,"Card Collection with kings copied",2);

        /*
        If you want a full list copy, you'd use the List dot copy of method, so let me revisit
         */
        cards=List.copyOf(kingsOfClubs);
        Card.printDeck(cards,"List copy of kings",1);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck,"Shuffled deck",4);

        Collections.reverse(deck);
        Card.printDeck(deck,"Reversed deck of cards",4);

        // sorting

        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Collections.sort(deck,sortingAlgorithm);
        Card.printDeck(deck,"Standard Deck sorted by rank, suit",13);

        Collections.reverse(deck);
        Card.printDeck(deck,"Sorted by rank, suit reversed",13);

        // sublisting
        List<Card> kings=new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings,"Kings in deck",1);

        List<Card> tens=new ArrayList<>(deck.subList(16,20));
        Card.printDeck(tens,"Tens in deck",1);

        int subListIndex=Collections.indexOfSubList(deck,tens);
        System.out.println("Sublist index for tens "+subListIndex);
        System.out.println("Contains = "+deck.containsAll(tens));

        boolean disjoint=Collections.disjoint(deck,tens);
        System.out.println("disjoint = "+disjoint);

        boolean disjoint2=Collections.disjoint(kings,tens);
        System.out.println("disjoint2 = "+disjoint2);

        //===========================================
        //Binary search, frequency, min, max, rotate.
        //===========================================

        //Binary search -- should be sorted before using it
        deck.sort(sortingAlgorithm);
        Card tenCardOfHearts = Card.getNumericCard(Card.Suit.HEART,10);
        int foundIndex=Collections.binarySearch(deck,tenCardOfHearts,sortingAlgorithm);
        System.out.println("foundIndex = "+foundIndex);
        System.out.println("foundIndex = "+deck.indexOf(tenCardOfHearts));
        System.out.println(deck.get(foundIndex));

        Card tenOfClubs=Card.getNumericCard(Card.Suit.CLUB,10);
        Collections.replaceAll(deck,tenOfClubs,tenCardOfHearts);
        Card.printDeck(deck.subList(32,36),"Tens row",1);

        Collections.replaceAll(deck,tenCardOfHearts,tenOfClubs);
        Card.printDeck(deck.subList(32,36),"Tens row",1);

        if(Collections.replaceAll(deck,tenCardOfHearts,tenOfClubs)){
            System.out.println("Tens of hearts replaced with tens of clubs");
        }else {
            System.out.println("No tens of hearts found in the list");
        }

        // frequency allows you to check for duplicates in your collection.
        System.out.println("Ten of Clubs cards = "+
                Collections.frequency(deck,tenOfClubs));

        System.out.println("Best card = "+Collections.max(deck,sortingAlgorithm));
        System.out.println("Worst card = "+Collections.min(deck,sortingAlgorithm));

        var sortBySuit=Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);

        deck.sort(sortBySuit);
        Card.printDeck(deck,"Sorted by Suit, Rank",4);

        List<Card> copied=new ArrayList<>(deck.subList(0,13));
        /*
        rotate method - A positive number, passed to this method, moves that number of elements in the list from
        the back of the list, to the front of the list. Order of the elements that were rotated is maintained
         */
        Collections.rotate(copied,2);
        System.out.println("UnRotated: "+deck.subList(0,13));
        System.out.println("Rotated "+2+": "+copied);


        copied=new ArrayList<>(deck.subList(0,13));
        /*
        rotate method - A negative number, passed to this method, moves that number of elements in the list from
        the front of the list, to the back of the list. Order of the elements that were rotated is maintained
         */
        Collections.rotate(copied,-2);
        System.out.println("UnRotated: "+deck.subList(0,13));
        System.out.println("Rotated "+-2+": "+copied);


        //swaping
        copied=new ArrayList<>(deck.subList(0,13));
        for(int i=0;i<copied.size()/2;i++){
            Collections.swap(copied,i,copied.size()-1-i);
        }
        System.out.println("Manual revers : "+copied);

        copied=new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Using revers : "+copied);

    }
}
