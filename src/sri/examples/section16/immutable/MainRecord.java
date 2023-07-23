package sri.examples.section16.immutable;

public class MainRecord {
    public static void main(String[] args) {
        PersonRecord jane = new PersonRecord("Jane","01/01/1930");
        PersonRecord jim = new PersonRecord("Jim","02/02/1932");
        PersonRecord joe = new PersonRecord("Joe","03/03/1934");
        PersonRecord[] johnsKids={jane,jim,joe};
        PersonRecord john= new PersonRecord("John","05/05/1900",johnsKids);
        System.out.println(john);
        //Running this code,I get the same output I did originally when using the Person class.

        PersonRecord johnCopy=new PersonRecord("John","05/05/1900");
        System.out.println(johnCopy);

        PersonRecord[] kids=johnCopy.kids();
        kids[0]=jim;
        kids[1]=new PersonRecord("Ann","04/04/1936");
        System.out.println(johnCopy);
        //running this code,you can see I can set and change the kids in the kids array on my record, meaning these instances are mutable.
        // For this reason, you can't assume, just because you're using a record, or setting up a record, that the record is immutable.

        //If the fields were all immutable types, yes, but if you're using arrays or collections, or mutable types, then you can't use a record, and prevent side effects, without implementing some defensive measures.
        //A record satisfies several of the requirements for an immutable class design.
        //  It uses private final instance fields, it has a constructor to set the data, and it doesn't have any setters. What's missing is, it's not creating defensive copies. Let's add this, to the Person record.




        ///Now, you may feel like you've created a type that's immutable, but don't congratulate yourself just yet.
        //Consider this minor change, where I'll change my local variable johnsKids, element 0 to a new Person, say Ann, born April 4, 1936.

        johnsKids[0]=new PersonRecord("Ann","04/04/1936");
        System.out.println(john);
        //run this code,
        //you can see I'm able to change John's data, his kids array, by changing the array variable, I used to construct the record. This means I need a constructor that will create a copy of the array passed, before I assign it.


    }
}
