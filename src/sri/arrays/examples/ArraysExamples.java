package sri.arrays.examples;

import java.util.Arrays;
import java.util.Random;

public class ArraysExamples {

    public static void main(String[] args) {
        basicArraysInstantion();
        arrayInitilizer();
        arraysStartIndexingFromZero();

        basicArraysIterationAndInitilization();

        arraysUtilClass();

    }

    public static void arraysUtilClass(){
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

    public static int[] reversSort(int [] unSortedArray){

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




    public static int[] getRandomArray(int length){
        Random random = new Random();
        int[] numbers=new int[length];
        for(int i=0;i<length;i++){
            numbers[i]=random.nextInt(100);
        }
        return numbers;
    }

    public  static  void basicArraysIterationAndInitilization(){
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
    public static void arraysStartIndexingFromZero(){
        int [] firstTen={1,2,3,4,5,6,7,8,9,10};
        System.out.println("First element : "+firstTen[0]);
        int length = firstTen.length;
        System.out.println("Last element : "+firstTen[length -1]);
    }
    public static void basicArraysInstantion(){

        int[] myIntArray = new int[10];
        myIntArray[5] = 60;

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;
        System.out.println( myDoubleArray[2]);
    }

    public static void arrayInitilizer(){
        int [] firstFivePositive = new int[]{1,2,3,4,5};

        int [] newFirstFivePositives = {1,2,3,4,5}; // anonymous array initilizer

        String [] names = {"Srikanth","Reddy","charles","Akbar","siddhu"}; // anonymous array initilizer

        int[] newArray;
        //newArray ={6,8,6,9}; // array initilizer not allowed hear

    }
}
