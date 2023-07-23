package sri.examples.section16.immutable;

public class Main {
    public static void main(String[] args) {
        /*Person jane = new Person();
        jane.setName("Jane");
        Person jim=new Person();
        jim.setName("Jim");
        Person joe=new Person();
        joe.setName("Joe");
        Person john=new Person();
        john.setName("John");
        john.setDob("05/05/1900");
        john.setKids(new Person[]{jane,jim,joe});
        System.out.println(john);
        System.out.println("______________________________________________");*/

        //The object, John, is definitely not immutable. I can use the setters to change any data on the object.
        //I'll change john's name to jacob, for example. I'll also use the set kids method, passing it two new instances of persons, constructed with no data. And I'll print john out.

        /*john.setName("jacob");
        john.setKids(new Person[]{new Person(),new Person()});
        System.out.println(john);*/
        //Running that
        //you can see that john is no longer named John, and his kids are now nameless, and there's only two of them.
        //Again, depending on what the case for your genealogy application is, this may be a valid way to design your class.
        //System.out.println("______________________________________________");
        //Let's at least create two constructors, to make the job of creating persons a little easier.

        Person jane = new Person("Jane","01/01/1930");
        Person jim = new Person("Jim","02/02/1932");
        Person joe = new Person("Joe","03/03/1934");
        Person[] johnsKids={jane,jim,joe};
        Person john= new Person("John","05/05/1900",johnsKids);
        System.out.println(john);
        //I'll set the kids to a new in place array, initialized to a new Person, Ann, born 4 4 1930.
        john.setKids(new Person[]{new Person("Ann","04/04/1930")});
        //Running that, you can see John's kids have been completely changed.
        System.out.println(john);
        Person[] kids=john.getKids();
        kids[0]=jim;
        //Running that,John's kid has changed from Ann to Jim.
        System.out.println(john);
        kids=null;
        //Running this code has no effect on Jim's kids, so that's a good thing.
        //This means reassigning the reference,or setting it to null, from the client or calling code, doesn't change kids.
        System.out.println(john);
        //I'll call set kids, and pass the kids variable, which we know is null.
        john.setKids(kids);
        //Running this code,
        //you can see I've managed to remove all John's kids I could only do it, by calling the method on Person, so that's at least some control going back to the Person class.


        //This is a very common kind of class, where some parts of the class is mutable.
        //Next, I'll create a Person record, in comparison.


        //A record solves a lot of the problems for designing an immutable object, but not all.



    }
}
