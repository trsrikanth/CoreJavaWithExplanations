package sri.quizz;

//https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1?page=1&curated[]=1&sortBy=submissions
import java.util.Arrays;

public class TwoArraysAreEqualOrNot {

    public static void main(String[] args) {

    }

    public static boolean check(long a[],long b[],int N)
    {
        if(a.length!=b.length){
            return false;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.compare(a,b)==0;
    }
}
