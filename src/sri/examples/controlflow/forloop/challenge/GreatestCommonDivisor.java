package sri.examples.controlflow.forloop.challenge;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int firstNumber=15;
        int secondNumber=25;

         int gcd=getGreatestCommonDivisor(firstNumber,secondNumber);
        System.out.printf("Greatest Common Divisor of %d and %d is %d",
                firstNumber,secondNumber,gcd);
    }
    public static int getGreatestCommonDivisor(int first, int second){
        if(first < 10 || second < 10 ) return -1;
        int minumum = first < second ? first : second;
        int gcd = 1;
        for(int i = 2; i <= minumum ; i++ ){
            if(first % i == 0 && second % i ==0) gcd = i;
        }
        return gcd;
    }
}
