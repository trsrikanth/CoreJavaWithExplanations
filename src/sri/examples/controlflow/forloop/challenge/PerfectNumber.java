package sri.examples.controlflow.forloop.challenge;

/*
A perfect number is a positive integer which is equal to the sum of its proper positive divisors.
Proper positive divisors are positive integers that fully divide the perfect number without leaving a remainder and exclude the perfect number itself.
For example, take the number 6:
Its proper divisors are 1, 2, and 3 (since 6 is the value of the perfect number, it is excluded), and the sum of its proper divisors is 1 + 2 + 3 = 6.
 */
public class PerfectNumber {

    public static void main(String[] args) {
        int numberToCheck=6;
        System.out.printf("Is %d a perfect number? %b%n",
                numberToCheck,isPerfectNumber(numberToCheck));

        numberToCheck=8;
        System.out.printf("Is %d a perfect number? %b%n",
                numberToCheck,isPerfectNumber(numberToCheck));
    }

    private static boolean isPerfectNumber(int number) {
        int sumOfFactors = 0;
        if (number < 1) return false;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sumOfFactors += i;
        }
        return (sumOfFactors == number);
    }
}

