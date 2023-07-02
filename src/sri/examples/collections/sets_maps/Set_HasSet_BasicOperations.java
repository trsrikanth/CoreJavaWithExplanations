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

        int index=emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood=emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com",
        "RHood@sherwoodforest.org");
        System.out.println(robinHood);

        //Bulk operations
        // When you are trying to understand data in multiple sets, you might want to get the data that's
        // in all sets, that's in every set, or the data where there is no overlap.
        // The collection interface's bulk operations (addAll,retainAll,removeAll and containAll) can be
        // used to perform these set operations.

        // set union
        Set<Contact> unionAB=new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A \u222A B) Union of emails (A) with phones (B)",unionAB);

        //intersect AB
        Set<Contact> intersectAB=new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A \u2229 B) Intersect emails (A) with phones (B)",intersectAB);


        //intersect BA
        Set<Contact> intersectBA=new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData("(B \u2229 A) Intersect phones (A) with email (B)",intersectBA);
        //The ability to evaluate sets, A intersect B and get the same result as B intersect A,
        //means that the intersect operation is a symmetric set operation.
        //Union is also a symmetric operation. It doesn't matter if you do A Union B,
        //or B union A, the final set of elements will all be the same set of names.



        // A - B

        //Another useful evaluation might be to identify which elements are in one set, but not the other.
        //This is called a set difference.
        //A difference subtracts elements in common from one set and another,
        //leaving only the distinct elements from the first set as the result.
        //This is an asymmetric operation because if we take Set A and subtract Set B from it,
        //we'll end up with a different set of elements than if we take Set B and subtract Set A.

        Set<Contact> AMinusB=new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)",AMinusB);

        Set<Contact> BMinusA=new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);
        printData("(B - A) phones (A) - emails (B)",BMinusA);


        //set symmetric difference.
        //This is really the union of the two asymmetric set differences.
        //You can think of the set symmetric difference, as the elements from all sets that don't intersect.

        Set<Contact> symmetricDiff=new HashSet<>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        printData("Symmetric difference: phones and emails",symmetricDiff);

        //The other way to get these same set of elements,
        //is to take the unioned set, and subtract the intersected set.

        Set<Contact> symmetricDiff2=new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printData("Symmetric difference: phones and emails",symmetricDiff2);

    }
    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("__________________________________________________");
        System.out.println(header);
        System.out.println("__________________________________________________");
        contacts.forEach(System.out::println);
    }
}
