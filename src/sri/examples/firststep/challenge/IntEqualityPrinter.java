package sri.examples.firststep.challenge;
/*
Write a method printEqual with 3 parameters of type int. The method should not return anything (void).
If one of the parameters is less than 0, print text "Invalid Value".
If all numbers are equal print text "All numbers are equal"
If all numbers are different print text "All numbers are different".
Otherwise, print "Neither all are equal or different".


EXAMPLES OF INPUT/OUTPUT:
printEqual(1, 1, 1); should print text All numbers are equal
printEqual(1, 1, 2); should print text Neither all are equal or different
printEqual(-1, -1, -1); should print text Invalid Value
printEqual(1, 2, 3); should print text All numbers are different
 */
public class IntEqualityPrinter {

    public static void printEqual(int firstNumber,int secondNumber,int thirdNumber){
        if(firstNumber<0||secondNumber<0||thirdNumber<0){
            System.out.println("Invalid Value");
        } else
        if((firstNumber == secondNumber)&&(firstNumber == thirdNumber)){
            System.out.println("All numbers are equal");
        } else
        if((firstNumber == secondNumber)||(firstNumber == thirdNumber)||(secondNumber == thirdNumber)){

            System.out.println("Neither all are equal or different");
        } else {
            System.out.println("All numbers are different");
        }
    }
}