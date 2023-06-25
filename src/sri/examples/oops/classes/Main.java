package sri.examples.oops.classes;

public class Main {
    public static void main(String[] args) {
        Account srisAccount=new Account();
        srisAccount.setNumber("12345");
        srisAccount.setCustomerName("Srikanth Reddy");
        srisAccount.setCustomerEmail("srikanth@email.com");
        srisAccount.setCustomerPhone("9898989898");

        srisAccount.withdrawFunds(100);
        srisAccount.depositFunds(250);
        srisAccount.withdrawFunds(50);
        srisAccount.withdrawFunds(200);

        srisAccount.depositFunds(100);
        srisAccount.withdrawFunds(45.55);
        srisAccount.withdrawFunds(54.46);
        srisAccount.withdrawFunds(54.45);


    }

}
