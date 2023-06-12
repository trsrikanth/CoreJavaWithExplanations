package sri.examples.arrays;

import java.util.Scanner;

public class SortedArray {

    public static int[] getIntegers(int size){
        Scanner scanner = new Scanner(System.in);
        int [] numbers = new int[size];
        for(int i=0;i<size;i++){
            numbers[i]=scanner.nextInt();
        }
        return numbers;
    }

    public static void printArray(int [] numbers){
        for (int i=0;i<numbers.length;i++){
            //System.out.println("Element "+i+" contents "+numbers[i]);
            System.out.printf("Element %d contents %d%n",i,numbers[i]);
        }
    }

    public static int [] sortIntegers(int [] unSortedArray){
        boolean flag =Boolean.TRUE;
        int temp=0;
        while(flag){
            flag=Boolean.FALSE;
            for(int i=0;i<unSortedArray.length-1;i++){
                if(unSortedArray[i+1]>unSortedArray[i]){
                    temp = unSortedArray[i];
                    unSortedArray[i]=unSortedArray[i+1];
                    unSortedArray[i+1]=temp;
                    flag=Boolean.TRUE;
                }
            }

        }
        return unSortedArray;
    }

}
