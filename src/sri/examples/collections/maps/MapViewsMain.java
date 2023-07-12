package sri.examples.collections.maps;

/*
The view, or view collection as Java calls it, doesn't store elements but depends on a backing collection that stores the data elements. You saw this with the headSet, tailSet and subSet methods on Sets. You're also very familiar now, with a list backed by an array, a view we get back, when we use the Arrays.asList method, to get an array in the form of a list. You'll remember when we make changes to that list, the changes are reflected in the underlying array, and vice versa.

The functionality available to us on the list, is limited to features supported by the backing storage, so for a list backed by an array, we can't add or remove elements as an example. Some of you might be familiar with database views which hide the details of the underlying data structures, to make it easier for clients to use the data. These view collections serve a similar purpose. They let us manipulate the collections, without really having to know exact details, about the storage of the data. In other words, we don't have to keep learning new methods, to manipulate data. As long as we can get a collection view of the data, we can use many of the collection methods, to simplify our work.

// High level overview of the structure of the HashMap class.
First, it's important to know that there's a static nested interface on the Map interface, and it's name is Entry. Concrete classes, implement both the Map interface, and the Map.Entry interface. The HashMap implements Map, and has a static nested class, Node, that implements the Map.Entry interface. The HashMap maintains an array of these Nodes, in a field called table, whose size is managed by Java, and whose indices are determined by hashing functions. For this reason, a HashMap is not ordered.

I want to focus now on the three view collections we can get from the map, which are the key set, the entry set, and the values. We know a map has keys, and these can't contain duplicates. These keys can be retrieved as a Set view, by calling the keySet method on any map object. Each key value pair is stored as instance of an Entry, and the combination of the key and value will be unique, because the key is unique.

A Set view of these entries, or nodes in the case of the HashMap, can be retrieved from the method entrySet. Finally, values are stored, and referenced by the key, and values can have duplicates, meaning multiple keys could reference a single value. You can get a Collection view of these, from the values method, on a map instance.
 */


import sri.examples.collections.sets.basic_setup.Contact;
import sri.examples.collections.sets.basic_setup.ContactData;

import java.util.*;

public class MapViewsMain {
    public static void main(String[] args) {
        //I'm going to create a new map, with String as the key type, and Contact as the value type. I'll set that to a new HashMap. I'll follow that with a call to get Data on ContactData, passing it the phone type, and chain a for each to that. In the lambda expression, I'll make a call to the put method on contacts, pass the contact name as the key, and the contact object, as the value.

        HashMap<String, Contact> contacts=new HashMap<>();
        ContactData.getData("phone").forEach(c->contacts.put(c.getName(),c));

        // I'll copy that statement, pasting it, changing the type from phone to email.

        ContactData.getData("email").forEach(c->contacts.put(c.getName(),c));

        // Next, I want to get a view of my keys, and I can do that with the keySet method on a map.
        // I'll create a local variable with a type of Set, and type argument String. I'll call it keysView, and assign that to contacts dot keyset. After that, I'll just print that variable out. Since the method keySet returns a set and not a map, I need only one type argument in the declaration, and that's the type of the key, a string in this case.
        Set<String> keyView = contacts.keySet();
        System.out.println(keyView);
        //you can see the keys, my contact names printed, in no particular order there.
        System.out.println("-----------------------------------------------------");

        //If I had used a constructor, for example, perhaps a TreeSet, I would not actually get a view at that point, but a copy of the keys. Let me do that next. I'll create another variable, copy of Keys, and set that to a new Tree Set.
        Set<String> copyOfKeys=new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);
        //print this variable out. Here, I'm doing something similar, except I'm passing the result of calling key set to a TreeSet constructor. Running that, my keys are now in alphabetical order, as you can see.
        System.out.println("-----------------------------------------------------");

        //I can use the containsKey method on the map, to see if the element exists by key.I'll call that in an if statement, and look for the key name, Linus Van Pelt. You can see that's a lot easier than previous attempts I made, where I created a contact instance with a matching name, to try to find a match.
        if(contacts.containsKey("Linus Van Pelt")){
            System.out.println("linus and I go way back, meaning I've known him a long time");
        }
        System.out.println("-----------------------------------------------------");
        // What's neat though is, I can use this key set view, to remove elements from the map. I'll call the remove method on the keys view, passing it Daffy Duck.
        keyView.remove("Daffy Duck");
        System.out.println(keyView);
        contacts.forEach((k,v)-> System.out.println(v));
        //Running this code, notice that Daffy Duck's not in the key set, which should be no surprise. What might be a surprise though, is that this removed the key and value pair in the map as well, and the Daffy Duck contact isn't printed out.
        System.out.println("-----------------------------------------------------");
        //Let me do the same thing with my copy of the key set.
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k,v)-> System.out.println(v));

        //Running this code, it's true Linus is removed from copy of Keys. Since this is a copy though, it had no effect on the original map, so Linus is still in that map.
        // If your goal is to use the keyset to manage and manipulate the underlying map data, make sure you don't make the simple mistake of passing your key set to a new Set's constructor.
        System.out.println("-----------------------------------------------------");

        //Let's say, that next, I want to purge some old contacts, like Lucy, Minnie and Maid Marion.I can use removeAll on my key set with these three contacts, or alternatively I can use the remain all method, and name the contacts I want to keep. I'll go with the second approach.

        keyView.retainAll(List.of("Linus Van Pelt","Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keyView);
        contacts.forEach((k,v)-> System.out.println(v));
        //This code runs and compiles successfully, and I've got four names in my key set, and 4 contacts in my map. Ok, so that's pretty convenient, to be able to just perform functions on your set of keys, and have those operations be propagated to the map.
        System.out.println("-----------------------------------------------------");

        //Functionalities available to set returned from keySet():
        //The set returned from the keySet method, is backed by the map.
        // This means changes to the map are reflected in the set, and vice-versa.
        // The set supports element removal, which removes the corresponding mapping from the map.
        // You can use the methods remove, removeAll, retainAll, and clear operations.
        // It does not support the add or addAll operations.


        //continue with this a bit longer.
        //First, I'll execute clear on the keys view. I'll print my contacts set again.
        keyView.clear();
        System.out.println(contacts);
        // And running this, I hope you can see that I've cleared the contacts map of elements, and a pair of empty brackets are printed out for my contacts map.
        System.out.println("-----------------------------------------------------");

        //Now, I want to try to start adding contacts back in, using the keysView. I'll add Daffy Duck to the keys View set, and I'll again print out the contacts.

        /*keyView.add("Daffy Duck");
        System.out.println(contacts);*/

        //This code compiles, but now if I run it, I get an exception, an UnsupportedOperation Exception,add operations can't be used on the keys view.
        // If you think about that, it's kind of logical, because adding just a key is only part of the data needed. You don't have a way, if you do this, to say what the keyed value would be.

        System.out.println("-----------------------------------------------------");

        //Next, I'll add my contacts back, as I did before.
        // I'll make a call to contact data dot get data, passing it the email type. I'll chain the for each method to that, adding each of these contacts to my set.
        // I'll repeat that, but pass the phone type. And then I'll immediately print out the keysView set, not my map.
        ContactData.getData("email").forEach(c->contacts.put(c.getName(),c));
        ContactData.getData("phone").forEach(c->contacts.put(c.getName(),c));
        System.out.println(contacts.keySet());
        //Running this code,
        //you can see all my newly added contacts, are in the keys view set. I didn't have to execute the keySet method again, to get the refreshed data. My view was refreshed automatically. This is a pretty powerful and easy way,to manipulate elements in the map.
        System.out.println("-----------------------------------------------------");

        //Now, let's consider the next view. I'll call values on my contacts map
        var values=contacts.values();
        values.forEach(System.out::println);
        //running that code,
        //I get all my contacts printed out.
        System.out.println("-----------------------------------------------------");

        //Once again, I'll use the retain all method, but this time using it on the values collection, passing it the emails retrieved from Contact Data
        values.retainAll(ContactData.getData("email"));
        //I'll print the keys, using my keys view, and after that, I'll print my map's keys and values.
        System.out.println(keyView);
        contacts.forEach((k,v)-> System.out.println(v));
        //Running that code,
        //notice that the keys view and the map, have the same contacts as the email contacts, even though the contact's attributes (phone in some cases), may not match those in the email list. I was able to change my mapped data, by using a values view, which was then also reflected in the keys view.
        System.out.println("-----------------------------------------------------");

        //I'm going to add a method to the contact class, that will return the contact's name listed as the last name, comma, then first name. What's nice about getting the values back as a collection, is you can pass this to any other type of class that implements a Collection.

        //I'll create a new ArrayList, and pass it values.
        //I'll sort the list, using my new method, with the helper methods on Comparator to do that.

        List<Contact> list=new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c-> System.out.println(c.getNameLastFirst()+": "+c));
        //Running this code,
        //you can see I have a nice printed list, alphabetical by last name.
        System.out.println("-----------------------------------------------------");

        //One thing I haven't demonstrated yet, is adding a duplicate contact, but under a different key name, so let me do that with the first element in my list here.

        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(),first);
        values.forEach(System.out::println);
        keyView.forEach(System.out::println);
        //Running that,
        //I hope you can see there's two Daffy Duck contacts but the keys are unique, because Duck comma Daffy is different from Daffy Duck.
        System.out.println("-----------------------------------------------------");

        //Now, I can also pass my values collection to a HashSet, which also takes a Collection as an argument to the constructor. I'll set up another local variable, set, a HashSet, again with a type argument of Contact.
        HashSet<Contact> set=new HashSet<>(values);
        set.forEach(System.out::println);
        if(set.size()<contacts.keySet().size()){
            System.out.println("Duplicate values are in my maps");
        }

        //The final view collection is the entry set. key value pairs are stored in instances that implement Map.Entry. In the HashMap, this is the Node. I can get a set of these Nodes, and examine them.
        //I'll do this here, to look for keys that aren't in sync with their contact name.
        //I'll set a local variable, using type inference,

        var nodeSet=contacts.entrySet();
        for(var node:nodeSet){
            System.out.println(nodeSet.getClass().getName());
            if(!node.getKey().equals(node.getValue().getName())){
                System.out.println(node.getClass().getName());
                System.out.println("key doesn't match name: "+node.getKey()+": "+
                        node.getValue());
            }
        }

        //you can learn a lot, if you take a little time to explore the code in Java's class libraries.

    }

}
