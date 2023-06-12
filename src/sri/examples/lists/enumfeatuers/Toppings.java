package sri.examples.lists.enumfeatuers;


//Intresting thing about enum is its really just a class and each of the constants are just instances of the class.
//we can add fields methods and even constructors to enum type
public enum Toppings {

    MUSTARD,
    PICKLES,
    BACON,
    CHEDDAR,
    TOMATO;

    public double getPrice(){
        return switch (this){
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }


}
