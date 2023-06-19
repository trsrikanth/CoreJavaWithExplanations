package sri.examples.controlflow.forloop.challenge;

public class FirstLastDigitSum {

    public static void main(String[] args) {
        int number=1256987536;
        System.out.printf("Sum of first and last digit in the number %d is %d",number,sumFirstAndLastDigit(number));
    }
    private static int sumFirstAndLastDigit(int number){

        if(number < 0 ) return -1;

        int sum = number % 10;
        do {
            int rem = number % 10;
            number = number / 10;
            if (number == 0 )
                sum += rem;
        }while( number !=0);

        return  sum;
    }
}
