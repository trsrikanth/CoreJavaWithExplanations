package sri.examples.collections.sets_maps;


import sri.examples.collections.sets_maps.basic_setup.Contact;
import sri.examples.collections.sets_maps.basic_setup.ContactData;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
The Set interface, and the classes that implement it.
A Set is not implicitly ordered, although some implementations of Set are.
A Set contains no duplicates. A Set may contain a single null element.
Sets can be useful because operations on them are very fast.
In actual fact, the lack of duplicates is the most important differentiator, as there are ordered sets,
such as the LinkedHashSet, andTreeSet,

The set interface defines the basic methods add, remove and clear,
to maintain the items in the set. We can also check if a specific item
is in the set using the contains method. Interestingly enough, there's no way
to retrieve an item from a set. You can check if something exists,
using contains, and you can iterate over all the elements in the set, but attempting to
get the 10th element, for example, from a set isn't possible, with a single method.

The best-performing implementation of the Set interface is the HashSet class.
This class uses hashing mechanisms to store the items.
This means the hash code method is used to support even distributions of objects in the set.
Oracle describes this class as offering constant time performance for the basic
operations (add, remove, contains and size). This assumes the hash function disperses
the elements properly among the buckets. Constant time has the Big O Notation O(1).

The HashSet actually uses a HashMap in it's own implementation, as of JDK 8.

Unlike lists, the hash set implementation doesn't include a replace, or replaceAll method.

There's no get method on a set. If you want to get an element from the set,
you'll have to iterate through every element, and look for a match manually.
And remember your HashSet's not going to be ordered or sorted.
Sets are valuable for groups of elements, when you'll be adding elements, removing duplicates,
 */
public class Set_HasSet_BasicOperations {
    public static void main(String[] args) {
        List<Contact> emails= ContactData.getData("email");
        List<Contact> phones= ContactData.getData("phone");
        printData("Phone list",phones);
        printData("Emails list",emails);

        Set<Contact> emailContacts=new HashSet<>(emails);
        Set<Contact> phoneContacts=new HashSet<>(phones);
        printData("Phone contacts",phoneContacts);
        printData("Email contacts",emailContacts);

        int index=emails.indexOf(new Contact("LOKESH BAILAPUDI"));
        Contact lokesh=emails.get(index);
        lokesh.addEmail("NetCracker Technologies");
        lokesh.addEmail("NetCracker Technologies");
        lokesh.replaceEmailIfExists("LBAILAPUDI@netcrackertechnologies.com",
        "LBAILAPUDI@netcrackertechnologies.org");
        System.out.println(lokesh);

        // set union
        Set<Contact> unionAB=new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A \u222A B) Union of emails (A) with phones (B)",unionAB);

        //intersect
        Set<Contact> intersectAB=new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A \u2229 B) Intersect emails (A) with phones (B)",intersectAB);


        // A - B
        Set<Contact> AMinusB=new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)",AMinusB);

    }
    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("_".repeat(75));
        System.out.println(header);
        System.out.println("_".repeat(75));
        contacts.forEach(System.out::println);
    }
}
