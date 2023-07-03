package sri.examples.collections.sets_maps;

import sri.examples.collections.sets_maps.basic_setup.Contact;
import sri.examples.collections.sets_maps.basic_setup.ContactData;

import java.util.*;

/*
If you need an ordered set, you'll want to consider either the LinkedHashSet or the TreeSet.

A LinkedHashSet maintains the insertion order of the elements.

The TreeSet is a sorted collection, sorted by the natural order of the elements, or by specifying
the sort during the creation of the set.

The LiknedHashSet extends HashSet class. It maintains relationship between elements with the use of a
doubly linked list between entries.

The iteration order is therefore the same as the insertion order of the elements, meaning the order is predictable.

All the methods for the LinkedHashSet are same as those for the HashSet.
Like HashSet, it provides constant-time performance, O(1), for the add, contains and remove operations.

====Tree set==

TreeSet's class, uses a data structure that's a derivative of what's called a binary search tree,
or Btree for short, which is based on the concept and efficiencies of the binary search.
(Binary search is very fast if the elements are sorted - this search iteratively test the midrange of a group of
elements to be searched, to quickly find its element, in a collection.)

As elements are added to a TreeSet, they're organized in the form of a tree, where the top of the tree
represents that midpoint of the elements. Further binary divisions become nodes under that.
The left node and its children are elements that are less than the parent node.
The right node and its children are elements that are grater than the parent node.

Instead of looking through all the elements in the collection to locate a match, this allows a tree to be
quickly traversed, each node a simple decision point.
Java's internal implementation uses a balanced tree data structure, called the red black tree.
The Tree remains balance as elements are added.

Remember that O(1) is constant time, meaning the time or cost of an operation doesn't change,
regardless of how many elements are processed.
O(n) is linear time, meaning it grows in line with the way the collection grows.
Another notation, is O(log(n)), which means the cost falls somewhere in between constant and linear time.
The TreeSet promises O(log(n)) for the add, remove, and contains operations,
compared to the HashSet which has constant time O(1) for those same operations.

A TreeSet can be declared or passed to arguments typed with any of the interfaces
Collection || Set || SortedSet || NavigableSet
This class is sorted, and implements the SortedSet interface, which has such methods as first,
last, headSet and tailSet, and comparator. This set also implements the NavigableSet
Interface, so it has methods such as ceiling, floor, higher, lower, descendingSet and others.

The TreeSet gives us a lot more functionality, but at a higher cost, than a LinkedHashSet, or a HashSet.

Elements which implement Comparable (said to have a natural order sort, like Strings and numbers)
can be elements of a TreeSet. If your elements don't implement Comparable, you must pass a Comparator to the constructor.

LinkedHashSet doesn't differ significantly, as far as functionality, from the HashSet.
Just know that the LinkedHashSet provides a predictable iterable order, and this incurs
slightly more cost than a HashSet, because of the doubly linked list structure that supports it.


 */
public class LinkedHashSet_TreeSet {
    public static void main(String[] args) {
        List<Contact> phones= ContactData.getData("phone");
        List<Contact> emails= ContactData.getData("email");

        //NavigableSet<Contact> sorted= new TreeSet<>(phones); // cannot do this as Contact class dosen't implement comparable
        Comparator<Contact> mySort=Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted= new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        NavigableSet<String> justNames=new TreeSet<>(); //Strings have a natural sort order
        phones.forEach(c->justNames.add(c.getName()));
        System.out.println(justNames);

        NavigableSet<Contact> fullSet=new TreeSet<>(sorted); // passing sorted set to the constructor
        //In this case, the sort was determined by the sort mechanism of the TreeSet passed to the constructor.
        // In fact, there's a method on the SortedSet interface, that returns the comparator used in the set.
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);


        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("------------------------------------------");
        //notice that this list, contains duplicates, but I was able to sort in the same way as the set,
        // alphabetically by the name.
        fullList.forEach(System.out::println);


        //Min and Max

        //Contact min=Collections.min(fullSet); // code doesn't compile, comparable not implemented
        //Contact max=Collections.max(fullSet); // code doesn't compile, comparable not implemented

        Contact min=Collections.min(fullSet,fullSet.comparator()); // using overloaded version we can pass comparator
        Contact max=Collections.max(fullSet,fullSet.comparator());

        //SortedSet interface includes first and last methods
        //These methods give me the same results as the methods on Collections,
        //and are the preferred way to get this data, but I did want you to see the alternative,
        //which you might again see in legacy code.
        Contact first=fullSet.first();
        Contact last=fullSet.last();
        System.out.println("-----------------------------------------");
        System.out.printf("min = %s, first = %s %n",min.getName(),first.getName());
        System.out.printf("max = %s, last = %s %n",max.getName(),last.getName());
        //you can see both elements are the same, meaning min and first get the same element,
        //and max and last also get the same element.
        System.out.println("-----------------------------------------");

        //pollFirst, and pollLast methods. These remove the first or last sorted element
        //from the set, and the methods return the removed element.

        NavigableSet<Contact> copiedSet=new TreeSet<>(fullSet);
        System.out.println("First element = "+copiedSet.pollFirst());
        System.out.println("Last element = "+copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        //you can see I get the same result as I did with the first and last methods,
        //but with one very important difference. The elements are first removed from the set,
        //which you can see here, when I print out the elements in the copied set.
        System.out.println("-----------------------------------------");

        // Till now  
        // 1) introduced you to the Tree Set, which implements both the Sorted Set and the Navigable Set.
        // 2) This set has first and last methods which retrieve the first sorted elements and the last sorted element.
        // 3) The pollFirst and pollLast methods
        //
        //do the same thing, but in addition, they remove the element from the set.


        // Now additional functionality unique to this kind of set.

        //The next set of methods I'll look at, identify the closest match in a set, to the value you pass to the method.

        Contact daffy = new Contact("Daffy Duck"); // is a contact in my set.
        Contact daisy = new Contact("Daisy Duck"); // not a contact in my set.
        Contact snoopy= new Contact("Snoopy"); // not in set, would be last if inserted in treeset.
        Contact archie= new Contact("Archie"); // not in set, would be first if inserted in treeset.

        // now need to test the navigation methods, higher, lower, ceiling and floor.-- closest match methods.

        for(Contact c:List.of(daffy,daisy,snoopy,archie)){
            System.out.printf("ceiling(%s)=%s%n",c.getName(),fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n",c.getName(),fullSet.higher(c));
        }
        //ceiling as returning the element, that is either greater than or equal to the element passed.
        //But the higher method never returns the value that's equal to it in a set, it always returns the next greater element
        //Higher returns a null if there is no element higher than the passed element.
        System.out.println("-----------------------------------------");

        //floor and lower

        for(Contact c:List.of(daffy,daisy,first,archie)){
            System.out.printf("floor(%s)=%s%n",c.getName(),fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n",c.getName(),fullSet.lower(c));
        }

        //you can see that floor is similar to ceiling.It returns the element that's equal to the argument passed, if that element's in the set.
        //
        System.out.println("-----------------------------------------");



        // few other methods, that return different sets.
        NavigableSet<Contact> decendingSet=fullSet.descendingSet();
        decendingSet.forEach(System.out::println);
        //you can see the set printed out in descending sorted order.
        // The set that's returned is backed by the original set,
        //so any changes to the fullSet, will be reflected in this set, and vice versa.
        System.out.println("-----------------------------------------");
        Contact lastContact=decendingSet.pollLast();
        System.out.println("Removed "+lastContact);
        decendingSet.forEach(System.out::println);
        System.out.println("-----------------------------------------");
        // element which got removed from the decending set will also be removed from full set.
        //Whatever you do to the descending set, will be reflected in the set that backs it, in my case the full set.
        fullSet.forEach(System.out::println);
        System.out.println("-----------------------------------------");


        //We can also get sub sets from the head,or beginning, of the sorted set, or the tail or end of the sorted set.

        Contact marion=new Contact("Maid Marion");
        var headSet=fullSet.headSet(marion);
        headSet.forEach(System.out::println);
        //the headSet, when passed the Maid Marion contact, returned all the elements less than Maid Marion.
        System.out.println("-----------------------------------------");
        var tailSet=fullSet.tailSet(marion);
        tailSet.forEach(System.out::println);
        //The second the tailSet, when passed the same contact,
        //returned all the elements after Maid Marion, but also included the maid Marion record.

        //Head Set is exclusive by default, meaning it will exclude the element passed.
        //But tail set is inclusive by default, meaning it will include the element
        //I can change the default behavior, by using the overloaded versions,
        //and passing a boolean value to each, to determine if the element passed, should be included.
        System.out.println("-----------------------------------------");



        //You can chain these methods together, to get a subset in the middle,
        //but it's far easier to just use the subSet method on NavigableSet,
        Contact linus=new Contact("Linus Van Pelt");
        var subSet=fullSet.subSet(linus,marion);
        subSet.forEach(System.out::println);
        System.out.println("-----------------------------------------");
        // using overloaded versions to fetch inclusive elements
        subSet=fullSet.subSet(linus,false,marion,true);
        subSet.forEach(System.out::println);

        //All three methods, headSet, tailSet and subSet return a subset of elements,backed by the original set.
        //The headSet method will return all elements at the head (or the elements that are less than) the argument passed to it.
        //It won't include the element passed, unless you use the overloaded version,
        //with true as your second argument. The tailSet method will return all elements from
        //the passed element to the tail (or all elements greater than or equal) to the argument passed.
        //It is inclusive of the element passed, if it's in the set.
        //The subset takes two arguments, a from Element and a two Element, and returns
        //a subset that includes the from Element, and all records less than the two Element.
        System.out.println("-----------------------------------------");

        //Conclusion
        //The TreeSet does offer many advantages,
        //in terms of built-in functionality over the other two Set implementations,
        //but it does come at a higher cost. If your number of elements is not large, or you
        //want a collection that's sorted, and continuously re-sorted as you add and remove elements,
        //and that shouldn't contain duplicate elements, theTreeSet is a good alternative to the ArrayList.

    }

}
