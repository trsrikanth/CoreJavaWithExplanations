package sri.examples.abstraction.abstractClass.challenge;

public class Furniture extends ProductForSale{
    public Furniture(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This "+type+" is manufactured in India");
        System.out.printf("The price of the piece is Rs%6.2f %n",price);
        System.out.println(description);
    }
}
