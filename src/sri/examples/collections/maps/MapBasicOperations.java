package sri.examples.collections.maps;

import sri.examples.collections.sets.basic_setup.Contact;
import sri.examples.collections.sets.basic_setup.ContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
The map interface is part of the collections framework, even though it doesn't derive from,
or implement, the Collection interface.

A map in the collections framework is another data structure.
Although it's still a grouping of elements, it's different, because elements are stored with keyed references.
This means a Map requires two type arguments,

The Map has K for it's key type, and V for the value type. As with any generic classes,
the only restriction on these types is, they must be reference types, and not primitives.

A Java Map can't contain duplicate keys, so I couldn't have four keys, all named put, in my map.
Each key can only map to a single value, so I couldn't reference 4 different string
descriptions for the key put, without aggregating the descriptions into a collection of some sort.

I'll be looking at 3 of the Java classes that implement the map interface, the HashMap, the LinkedHashMap,
and the TreeMap. The HashMap is unordered, the LinkedHashMap is ordered by insertion order,
and the TreeMap is a sorted map.

A Map is a much easier data structure to work with, if you're doing updates, to a keyed item.

 */
public class MapBasicOperations {

    public static void main(String[] args) {
        List<Contact> phones= ContactData.getData("phone");
        List<Contact> emails= ContactData.getData("email");
        List<Contact> fullList=new ArrayList<>();
        fullList.addAll(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        //Records in a list, are by default in insertion order, and include all duplicates.
        System.out.println("_______________________________");

        //create my first map, and I'm going to start with a hash map.

        Map<String,Contact> contacts=new HashMap<>();
        //Unlike the classes with Collection at their root, Map implementations don't have an add all method,
        //and I can't simply pass collection types to the constructor, only other map types.
        //To add my Contacts, I'm going to loop through the full list, and use the put method on my hash map.
        //The put method takes a key and a value, and inserts what's called an Entry into the map.
        //I'll pass the name, using get name on Contact, as the key, and my current contact as the value.
        for(Contact contact:fullList){
            contacts.put(contact.getName(), contact);
        }
        //Now I want to print out my elements in the map. There are multiple ways to do that, but I'll start
        //with the for each method on the map itself, on contacts, and pass it a lambda expression.
        //This lambda expression requires two arguments, one for the key, and one for the value,

        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));
        //keys are the contact names, and the values, are the contact records.
        //These elements aren't in any particular order. Also notice that there's no duplicates,
        //of either key or value. Keys must be unique,

        //The map's put method is different
        //than the set's add method, because the put method always puts the element in the map.
        //If the key is not in the map, the key and value are added.
        //If the key is in the map, the value is replaced, and the previous value
        //is returned from the put method. For a map, this means the last
        //element in your list, is the one that ends up in your map, which is what happened here.
        System.out.println("_______________________________");


        //something about a map that makes it so nice is, I can simply use the key value to look up my contact.
        System.out.println(contacts.get("Charlie Brown"));
        //If Charlie Brown is not a key in the map, the get method would return a null.
        System.out.println("_______________________________");

        //JDK8 introduced a method called getOrDefault, which will replace that null value with a default value
        System.out.println(contacts.get("Chunk Brown")); // returns null.
        Contact defaultContact=new Contact("Chunk Brown");
        System.out.println(contacts.getOrDefault("Chunk Brown",defaultContact));
        //It's important to remember, though that Chuck Brown never gets added to the map,
        //that contact is just there, the defaultContact, as a convenience.
        System.out.println("_______________________________");

        //The put method will also return a null if the element isn't found in the map, or the element if it is.
        contacts.clear();
        for(Contact contact:fullList){
            Contact duplicate=contacts.put(contact.getName(),contact);
            if(duplicate!=null){
                System.out.println("duplicate = "+duplicate);
                System.out.println("current = "+contact);

            }
        }
        //Running this code prints duplicate records by name, as well as the record that I'm
        //iterating over, the current contact. I can use this bit of information to
        //my advantage, especially since my objective is to merge my contacts.
        System.out.println("_______________________________");

        contacts.clear();
        for(Contact contact:fullList){
            Contact duplicate=contacts.put(contact.getName(),contact);
            if(duplicate!=null){
                //System.out.println("duplicate = "+duplicate);
                //System.out.println("current = "+contact);
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));

        //Merging my contacts was quick work, using a hash map.
        System.out.println("_______________________________");

        //Now, let's just say I didn't really want to merge these elements,
        //but I also don't want each additional matching record, to replace the initial entry either.
        //In other words, I don't want to replace the value, every time I do a put.
        contacts.clear();

        //instead of put, I'll use another method, called put if Absent, which is a default
        //method on the Map interface.
        for(Contact contact:fullList){
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));
        //The put if absent method won't put an updated value in the map, it just ignores the element, if
        //it already finds something in the map for the key. Again, this method returns an element, if one is
        //already in the map for the key, but the method doesn't replace it with the current element.
        //It returns null if this is the first time an entry is being added to the map for that key.

        System.out.println("_______________________________");

        //And now, If I wanted to merge contacts in this case, I could do something similar,
        contacts.clear();
        for(Contact contact:fullList){
            Contact duplicate=contacts.putIfAbsent(contact.getName(), contact);
            if(duplicate!=null){
                contacts.put(contact.getName(),contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));
        System.out.println("_______________________________");

        //There's still another method, introduced in JDK8, that I can use, rather than doing this kind of
        //check, with put or put if Absent. That's the merge method.
        //It also takes a key, and a value, but the third parameter is a BiFunction interface,
        //meaning it's a target for a lambda expression that takes two parameters, and returns a result.
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData));
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));
        System.out.println("_______________________________");
    }
}
