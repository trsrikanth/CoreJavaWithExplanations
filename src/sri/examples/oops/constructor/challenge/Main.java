package sri.examples.oops.constructor.challenge;

public class Main {
    public static void main(String[] args) {
        Customer customer1=new Customer("Anoop",1000,"anoop@tcs.com");
        System.out.print(customer1.getName());
        System.out.print(customer1.getCreditLimit());
        System.out.println(customer1.getEmail());

        Customer customer2=new Customer("Vijay","vijay@jpmc.com");
        System.out.print(customer2.getName());
        System.out.print(customer2.getCreditLimit());
        System.out.println(customer2.getEmail());

        Customer customer3= new Customer();
        System.out.print(customer3.getName());
        System.out.print(customer3.getCreditLimit());
        System.out.println(customer3.getEmail());

    }
}
