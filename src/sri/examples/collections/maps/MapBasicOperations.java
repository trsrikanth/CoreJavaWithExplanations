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

        // compute, computeIfPresent, and computeIfAbsent.
        // Like the merge method, these are default methods that were added to the Map interface with JDK 8.
        //The compute and computeIfAbsent methods take two values, for their BiFunction as well, but these
        //represent the key and the value, not two contacts. Let's look at this in action.

        //This time, I don't want to clear my map. I'll loop through an array of names.
        //One name, Daffy Duck, is already a contact in my list, but the other two aren't.

        // compute method, takes a BiFunction, so I've got a lambda expression, that has parameters,
        // k for key, and v for value. I'll just return a new Contact, using the constructor that only takes a name,
        // passing that my k argument, the key in other words.

        // -- commented it intentionally uncomment it to check compute method and comment it back to proceed further.

        /*for(String contactName:new String[]{"Daisy Duck","Daffy Duck","Scrooge McDuck"}){
            contacts.compute(contactName,(k,v)->new Contact(k));
        }
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));*/

        //Running this code, you can see, I've got two new contacts, Daisy Duck and Scrooge McDuck,
        //with no emails or phone numbers. But now look at Daffy Duck,
        //I've also erased his previous information, and replaced it with a brand new contact record.

        System.out.println("_______________________________");

        //Compute is like the put method in this way, replacing what's in the map with the result
        //of the Bi Function, or lambda expression. Maybe that's not what I really want to do.

        //I can replace my compute method, with a computeIfAbsent call there.
        //But that doesn't compile. The computeIfAbsent method,
        //only takes a key value as an argument, so I need to change this code once more.

        //I'll just use k as the parameter, with my lambda expression.
        //I could keep the parentheses around that, but I kind of prefer it with no parentheses,
        //when it's a single parameter like this. And notice, I can replace that with a method
        //reference, but I don't want to do that right now.


        for(String contactName:new String[]{"Daisy Duck","Daffy Duck","Scrooge McDuck"}){
            contacts.computeIfAbsent(contactName,k->new Contact(k));
        }
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));
        // similar to putifabscent method
        System.out.println("_______________________________");

        //I want to use computeIfPresent, for my same list of duck contacts.
        //I'm going to say all my duck contacts, work at a family owned business called fun place.

        //Like the first compute method, the first parameter is the key, and the next is a function,
        //and like compute, it's a bi function that takes both the key and the value,
        //so I'll put parens there, and add v. Here, I've got a multi-line lambda,
        //and I'll execute add Email on the element, passing it Fun Place as the company name,
        //and I'll return the updated contact.

        for(String contactName:new String[]{"Daisy Duck","Daffy Duck","Scrooge McDuck"}){
            contacts.computeIfPresent(contactName,(k,v)->{
                v.addEmail("funplace");
                return v;
            });
        }
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));
        // Running this code,
        //you can see that now all my duck contacts had a new email added, but my email logic's not very good,
        //since Daisy and Daffy have the same email. The compute methods give you a lot of
        //functionality, for adding elements that aren't in the map, replacing values already keyed,
        //resetting all elements in the map to some default value, or executing some
        //code on the map elements that do exist.
        System.out.println("_______________________________");

        // replaceall

        //Next, I want to fix the two Ducks with the
        //same email, using yet another default method on the Map interface, this one called replaceAll.
        //This method is similar to the replaceAll method on the List interface, except for a map, this takes a
        //bi function that has two arguments. It takes the key and value,
        //and the function should return an object the same type as the value.

        System.out.println("_______________________________");
        contacts.replaceAll((k,v)->{
            String newEmail=k.replaceAll(" ","")+"@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com",newEmail);
            return v;
        });
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));
        //Ok, so this code isn't really very efficient, since I'm calling replaceAll on every single
        //entry in the map, when I really only want to replace the email of two contacts.
        //I did want to show you, however, that you can execute this method on the entire map,
        //just like the list's replaceAll method.
        // Running this code,
        //you can see that Daisy and Daffy's emails have been updated,
        //but all other contact emails are untouched.
        System.out.println("_______________________________");


        //In addition to replace all, I can replace
        //just a single element in the map, by either matching on key alone, or both key and value.

        //Let's say I have a contact where the name is Daisy Jane Duck, with an email of daisyj@duck.com.
        //I'll set up that record here. I'll create a new contact, daisy,
        //and pass that Daisy Jane Duck as the name, and daisyj@duck.com as the email.
        //Now, I want to add this contact to my map, for Daisy Duck, ignoring any middle name or initial.
        //I'll call replace on my contacts map, passing the key, Daisy Duck, and my new contact daisy.
        //I'll assign the result to a variable called replacedContact. And
        //I'll print Daisy.
        //Then the replacedContact. finally, all the key value pairs in my map.

        Contact daisy=new Contact("Daisy Jane Duck","daisyj@duck.com");

        Contact replacedContact=contacts.replace("Daisy Duck",daisy);
        System.out.println("daisy = "+daisy);
        System.out.println("replaced contact"+replacedContact);
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));

        //Running that code,
        //you can see the new daisy contact,
        //and the replaced Contact was the one that was in the map already.
        //But this code replaced that in the map, with the new daisy, with the name Daisy Jane Duck.
        //There's no rule that says the contact name has to match the key,
        //and right now, they don't for this record.
        System.out.println("_______________________________");


        //The replace method has an overloaded version,
        //which lets you specify that you only want to replace the value in the map, if both the keys and values match.

        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy "+updatedDaisy);
        boolean success=contacts.replace("Daisy Duck",replacedContact,updatedDaisy);
        if(success){
            System.out.println("Successfully replaced element");
        }else {
            System.out.printf("Did not match both key %s and value %s %n"
                    .formatted("Daisy Duck",replacedContact));
        }
        contacts.forEach((k,v)-> System.out.println("Key= "+k+" value= "+v));

        //Running that code,
        //you can see the merged contact, updated Daisy, with the name Daisy Duck, but with 2 emails.
        //You can see that the code to replace Daisy,
        //testing the key Daisy Duck and the record that's in replaced Contact, wasn't successful.
        System.out.println("_______________________________");

        //Remember that a contact is considered equal, if they have the same name.
        //Our map's daisy record now has Daisy Jane Duck as the name, and that doesn't match the name of the
        //replaced contact, which was the original record. You can see that when I printed out the map,
        //the key says Daisy Duck, but the value shows Daisy Jane Duck.
        //I'll change my arguments, swapping replacedContact with just daisy, the contact that has Daisy Jane.


        // remove & removeAll
        //Similarly, there are also two overloaded versions of the remove method. The first remove method takes a key, and returns the value that was removed, or null, if a value doesn't exist for that key.
        //The second remove method takes both a key and a value. It only removes the element from the map, if the key is in the map, and the element to be removed equals the value passed. This method returns a boolean.

        success=contacts.remove("Daisy Duck",daisy);
        if(success){
            System.out.println("Successfully removed element");
        }else{
            System.out.printf("Did not match on both key :%s and value: %s%n".formatted("Daisy Duck",daisy));
        }
        contacts.forEach((k,v)-> System.out.println("Key="+k+", value= "+v));

        //Running that code,
        //I get the statement that they did not match on the key and the value. The value in the map doesn't include Jane in the name, so it doesn't match. Like the replace method that returns a boolean, this version of the remove method, must find the key in the map. It won't remove the element though,unless it's considered equal to the element passed as the second argument.
    }
}
