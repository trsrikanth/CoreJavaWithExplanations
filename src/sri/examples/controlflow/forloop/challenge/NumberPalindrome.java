package sri.examples.controlflow.forloop.challenge;

public class NumberPalindrome {

    public static void main(String[] args) {
        System.out.println("is the Number 1221 a palindrome? "+isPalindrome(1221));
        System.out.println("is the Number 1543 a palindrome? "+isPalindrome(1543));
    }
    public static boolean isPalindrome(int number){
        int reverse = 0 ;

        if( number < 0 ){
            number = number * -1;
        }
        int tempNumber = number;
        while (number > 0 ){
            reverse = (reverse * 10) + (number % 10);
            number = number / 10;
        }
        return  tempNumber == reverse;
    }

}
