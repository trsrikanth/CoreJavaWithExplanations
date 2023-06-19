package sri.examples.controlflow.forloop;

public class ForLoopExamples {
    public static void main(String[] args) {

        System.out.println("0 is "+(isPrime(0)?"":"Not ")+"a Prime number");
        System.out.println("1 is "+(isPrime(1)?"":"Not ")+"a Prime number");
        System.out.println("2 is "+(isPrime(2)?"":"Not ")+"a Prime number");
        System.out.println("3 is "+(isPrime(3)?"":"Not ")+"a Prime number");
        System.out.println("4 is "+(isPrime(4)?"":"Not ")+"a Prime number");

        int primeNumberCounter=0;
        for(int startNumber =32;primeNumberCounter<4 && startNumber<=1000;startNumber++){
            if(isPrime(startNumber)){
                System.out.println(startNumber+" is a prime number");
                primeNumberCounter++;
            }
        }

    }

    private static void printInterestRates(){
        //System.out.println("10,000 at 2% interest is "+calculateInterest(10000,2));

        for(int rate=2;rate<6;rate++){
            double interestAmount = calculateInterest(10000,rate);
            System.out.println("10000 at "+rate+" % interest "+interestAmount);
        }

        for(double rate=7.5;rate<=10;rate=rate+0.25){
            double interestAmount = calculateInterest(100,rate);
            if(interestAmount>8.5){
                break;
            }
            System.out.println("100 at "+rate+" % interest "+interestAmount);
        }
    }

    private static double calculateInterest(double amount, double interestRate){
        return (amount*interestRate/100);
    }

    private static boolean isPrime(int number){
        if(number<=2){
            return (number == 2);
        }

        for(int divisor=2;divisor<=number / 2;divisor++){
            if(number%divisor == 0){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;

    }
}
