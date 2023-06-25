package sri.examples.oops.classes;

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;


    public void depositFunds(double depositAmount){
        balance+=depositAmount;
        System.out.println("Deposit of Rs:"+depositAmount +" made. New balance is Rs:"+balance);
    }

    public void withdrawFunds(double withdrawalAmount){
        if(balance-withdrawalAmount<0){
            System.out.println("Insufficient funds. You only have Rs:"+balance+
                    " in your account.");
        }else {
            balance -=withdrawalAmount;
            System.out.println("Withdrawal of Rs:"+withdrawalAmount+
                    " processed, Remaining balance is Rs:"+balance);
        }
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
