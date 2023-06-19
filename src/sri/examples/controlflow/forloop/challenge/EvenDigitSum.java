package sri.examples.controlflow.forloop.challenge;

/*
The method should return the sum of the even digits within the number.

 */
public class EvenDigitSum {

    public static void main(String[] args) {
        int number= 7569843;
        System.out.printf("Even digits sum in the number %d is %d",number,getEvenDigitSum(number));
    }

    private static int getEvenDigitSum(int number){
        if( number < 0 ) return -1;
        int sum = 0;
        do {
            if((number % 10) % 2 ==0 )
                sum += number %10;

            number = number / 10;
        }while( number !=0);
        return  sum;
    }
}
