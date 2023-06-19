package sri.examples.controlflow.forloop.challenge;

/*
Create a for loop using a range of numbers from 1 to 1000 inclusive.
Sum all the numbers that can be divided by both 3 & 5.
Print out the numbers that have met the above conditions.
Break out of the loop once you have found 5 numbers that met the conditions above.
After breaking out of the loop, print the sum of the numbers that met the conditions above.
 */
public class Sum3_5 {
    public static void main(String[] args) {
        int count=0;
        int sum=0;
        for(int i=1;i<=1000;i++){
            if(count>5){
                break;
            }
            if(i%3 == 0 && i%5==0){
                //System.out.println(i);
                count++;
                sum+=i;
            }
        }
        System.out.println("Sum of first five numbers divisible by 3 & 5 is "+ sum);
    }
}
