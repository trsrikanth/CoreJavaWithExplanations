package sri.examples.lists.arrayListChallenge;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact newContact){
        if(findContact(newContact)>-1){
            return Boolean.FALSE;
        }else {
            this.myContacts.add(newContact);
            return Boolean.TRUE;
        }
    }

    public boolean updateContact(Contact oldContact,Contact newContact){
        int position=findContact(oldContact);
        if(position>-1){
            this.myContacts.set(position,newContact);
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    public boolean removeContact(Contact contact){
        if(findContact(contact)>-1){
            this.myContacts.remove(contact);
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    private int findContact(Contact contact){
        for(Contact contact1:this.myContacts){
            if((contact1.getName().equals(contact.getName()))
            && (contact1.getPhoneNumber().equals(contact.getPhoneNumber()))){
                return this.myContacts.indexOf(contact1);
            }
        }
        return -1;
   }

    private int findContact(String contactName){
        for(Contact contact:this.myContacts){
            if(contact.getName().equals(contactName)){
                return this.myContacts.indexOf(contact);
            }
        }
      return -1;
   }

    public void printContacts(){
        System.out.println("Contact List:");
        int counter=1;
        for (Contact contact:this.myContacts){
            System.out.printf("%d. %s -> %s%n",counter,contact.getName(),contact.getPhoneNumber());
            counter++;
        }
    }

    public Contact queryContact(String name){
        int position=findContact(name);
        if(position>-1){
            return this.myContacts.get(position);
        }
        return null;
    }

}
