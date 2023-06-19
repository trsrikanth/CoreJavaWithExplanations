package sri.examples.controlflow.forloop.challenge;

/*
The method should print all factors of the number.
A factor of a number is an integer which divides that number wholly (i.e. without leaving a remainder).
 */
public class FactorPrinter {

    public static void main(String[] args) {
        printFactors(38);
    }
    public static void printFactors(int number){
        if(number < 1 ) System.out.println("Invalid Value");

        for(int i =1 ; i <= number ;i++){
            if(number % i == 0 ){
                System.out.println(i);
            }
        }
    }
}
