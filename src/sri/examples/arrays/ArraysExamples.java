package sri.examples.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysExamples {

    public static void main(String[] args) {
        basicArraysInstantion();
        arrayInitilizer();
        arraysStartIndexingFromZero();

        basicArraysIterationAndInitilization();

        arraysUtilClass();

        stringSplitExample();

        //minElementChallenge();

        reverseArrayChallenge();

        twoDiArraysPrinting();

    }

    private static void arraysUtilClass(){
        int[] numbers = {4,5,6,7,8,9,2};
        System.out.println(Arrays.toString(numbers));

        Object objectVarible= numbers;
        if(objectVarible instanceof int []){
            System.out.println("Object varible is really an int array");
        }

        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int [] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        Arrays.fill(secondArray,4);
        System.out.println(Arrays.toString(secondArray));


        int [] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        int [] fourthArray = Arrays.copyOf(thirdArray,10);
        System.out.println(Arrays.toString(fourthArray));

        int [] smallArray=Arrays.copyOf(thirdArray,5);
        System.out.println(Arrays.toString(smallArray));

        int [] bigArray = Arrays.copyOf(thirdArray,15);
        System.out.println(Arrays.toString(bigArray));


        String [] sArray={"hi","cow","god","love","ultimate"};
        Arrays.sort(sArray);
        if(Arrays.binarySearch(sArray,"cow")>=0){
            System.out.println("Cow found in the list");
        }

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5};

        if(Arrays.equals(s1,s2)){
            System.out.println(" S1 & S2 are equal");
        }else{
            System.out.println(" S1 & S2 are not equal");
        }

        int [] numbersToBeSortedReverse = getRandomArray(10);
        System.out.println("Before sorting " + Arrays.toString(numbersToBeSortedReverse));
        numbersToBeSortedReverse=reversSort(numbersToBeSortedReverse);
        System.out.println("After sorting " + Arrays.toString(numbersToBeSortedReverse));

    }

    private static int[] reversSort(int [] unSortedArray){

        /*Arrays.sort(unSortedArray);
        int [] reversSortedArray = new int [unSortedArray.length];
        int counter=0;
        for(int i= unSortedArray.length-1;i>=0;i--){
            reversSortedArray[counter]=numbers[i];
            counter++;
        }*/
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


    private static int[] getRandomArray(int length){
        Random random = new Random();
        int[] numbers=new int[length];
        for(int i=0;i<length;i++){
            numbers[i]=random.nextInt(100);
        }
        return numbers;
    }

    private  static  void basicArraysIterationAndInitilization(){
        int [] numbers = new int[5];

        for(int i=0;i<numbers.length;i++){
            numbers[i]=numbers.length-i;
        }

        for(int i =0 ;i<numbers.length;i++){
            System.out.print(numbers[i]);
        }
        System.out.println();
        for(int i : numbers){
            System.out.print(i);
        }
        System.out.println();
    }
    private static void arraysStartIndexingFromZero(){
        int [] firstTen={1,2,3,4,5,6,7,8,9,10};
        System.out.println("First element : "+firstTen[0]);
        int length = firstTen.length;
        System.out.println("Last element : "+firstTen[length -1]);
    }
    private static void basicArraysInstantion(){

        int[] myIntArray = new int[10];
        myIntArray[5] = 60;

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;
        System.out.println( myDoubleArray[2]);
    }

    private static void arrayInitilizer(){
        int [] firstFivePositive = new int[]{1,2,3,4,5};

        int [] newFirstFivePositives = {1,2,3,4,5}; // anonymous array initilizer

        String [] names = {"Srikanth","Reddy","charles","Akbar","siddhu"}; // anonymous array initilizer

        int[] newArray;
        //newArray ={6,8,6,9}; // array initilizer not allowed hear

    }

    private static void stringSplitExample(){
        String[] splitStrings = "Hello world again".split(" ");
        System.out.println(("_".repeat(20)));
        printUsingVaribleArgsExample(splitStrings);  //passing array
        System.out.println(("_".repeat(20)));
        printUsingVaribleArgsExample("Hello" , "World","Example"); // passing independent strings
        System.out.println(("_".repeat(20)));
        printUsingVaribleArgsExample(); // without any arguments also it works.

        String [] sArray={"first","second","third","fourth"};
        printUsingVaribleArgsExample(String.join(",",sArray)); //printing single string.



    }
    private static void printUsingVaribleArgsExample(String ... strings){
        //There can be only one varible argument in a method
        // The varible argument must be the last argument.

        for(String str : strings){
            System.out.println(str);
        }
    }

    private static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter multiple numbers seperated by comma");
        String[] sNumbers = scanner.nextLine().split(",");

        int [] numbers=new int[sNumbers.length];

        for(int i=0;i<sNumbers.length;i++){
            numbers[i]=Integer.parseInt(sNumbers[i]);
        }

        return numbers;
    }

    private static int findMin(int[] numbers){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<min){
                min = numbers[i];
            }
        }
        return min;
    }

    private static void  minElementChallenge(){
        int[] numbers = readIntegers();
        System.out.println(Arrays.toString(numbers));

        int minNumber = findMin(numbers);
        System.out.println("Minimum number entered in the list is "+minNumber);


    }

    private static int readInteger(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int[] readElements(int count){
        Scanner scanner = new Scanner(System.in);
        int[] numbers=new int[count];
        for(int i=0;i<count;i++){
            numbers[i]=scanner.nextInt();
        }
        return numbers;
    }


    private static void reverseArrayChallenge(){
        int[] numbers = getRandomArray(10);
        System.out.println("Original numbers");
        System.out.println(Arrays.toString(numbers));
        System.out.println("After reversing");
        System.out.println(Arrays.toString(reverseArray(numbers)));
    }
    private static int[] reverseArray(int [] numbers){

        //Full iteration mode
        /*
        int [] reversArray=new int[numbers.length];
        int counter=0;
        for(int i=numbers.length-1;i>-1;i--){
            reversArray[counter]=numbers[i];
            counter++;
        }
        return reversArray;
        */

        //Half iteration mode (bit fast compared to full iteration mode
        int maxIndex=numbers.length-1;
        int midIndex=numbers.length/2;
        int temp =0;
        for(int i=0;i<midIndex;i++){
            temp = numbers[i];
            numbers[i]=numbers[maxIndex-i];
            numbers[maxIndex-i]=temp;
        }
        return numbers;
    }

    private static void twoDimentionalArraysInitilizer(){
        int[][] arrays1={ {1,2,3},
                {4,6,8,9},
                {12,4,8,3,90}
                };
        int [][] arrays2={{12,3,54,8},{23,5,6,7},{23,5}};

        int [][] arrays3=new int[3][3];

        int [][] arrays4 = new int[3][]; // we can initilize two dimentional array without specifying the size of nested array

        int [][] arrays5; //declaration1
        int[] arrays6[]; //declaration2


    }

    private static void twoDiArraysPrinting(){
        int [][] array2=new int[4][4];
        System.out.println(Arrays.toString(array2));

        for(int [] arr : array2){
            for(int element : arr){
                System.out.print(element);
            }
            System.out.println();
        }

        for(int [] arr:array2){
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(Arrays.deepToString(array2));
    }

}
