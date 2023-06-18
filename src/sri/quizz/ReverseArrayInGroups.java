package sri.quizz;

/*
https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1?page=1&curated[]=1&sortBy=submissions
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseArrayInGroups {

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.addAll(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
        System.out.println("Before revers"+ List.of(arr));
        reverseUsingCollectionsSwap(arr,arr.size(),4);
        System.out.println("After revers collections logic"+List.of(arr));


        System.out.println("Before revers"+ List.of(arr));
        reverseUsingCollectionsSwap(arr,arr.size(),4);
        System.out.println("After revers loops logic"+List.of(arr));

    }

    private static void reverseUsingCollectionsSwap(ArrayList<Integer> arr, int n, int k){

        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            while (left < right) {
                Collections.swap(arr, left, right);
                left++;
                right--;
            }
        }
    }

    private static void reverseUsingLoops(ArrayList<Integer> arr, int n, int k){
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            while (left < right) {
                int temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);
                left++;
                right--;
            }
        }

    }


}
