package sri.examples.gog.challenges;

import java.util.*;

public class AllChallenges {
    public static void main(String[] args) {

        int [] numbs={16,17,4,3,5,2};
        System.out.println(leadersInAnArray(numbs,6));
        System.out.println(leaders(numbs,6));

       for(int i:findTwoElement(new int[]{1,3,3},3)){
           System.out.print(i);
       }

       rotateArr(new int[]{2,4,6,8,10,12,14,16,18,20},3,10);
    }

    /*
    Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader.
     */
    private static ArrayList<Integer> leadersInAnArray(int arr[],int size){

        ArrayList<Integer> integers=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            // looping twice.. we can reduce it.
            int max=Integer.MIN_VALUE;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>max){
                    max=arr[j];
                }
            }
            if(arr[i]>max){
                integers.add(arr[i]);
            }
        }
        return integers;
    }

    //Function to find the leaders in the array.
    private static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int mx = arr[n-1];
        ans.add(mx);
        for(int i = n-2;i>=0;i--){
            if(arr[i]>=mx) {
                mx = arr[i];
                ans.add(mx);
            }

        }
        Collections.reverse(ans);
        return ans;
    }

    private static boolean parenthesisChecker(String expression){
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<expression.length();i++){
            char x=expression.charAt(i);
            if("{([".indexOf(x)>=0){
                stack.push(x);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }
            char check;
            switch (x){
                case '}': {
                    check=stack.pop();
                    if("])".indexOf(x)>=0){
                        return false;
                    }
                }
                case ']': {
                    check=stack.pop();
                    if("})".indexOf(x)>=0){
                        return false;
                    }
                }
                case ')':{
                    check=stack.pop();
                    if("}]".indexOf(x)>=0){
                        return false;
                    }
                }

            }
           break;
        }
        return stack.isEmpty();
    }


    /*

    Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array. Return the answer in ascending order.

     */
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        Set<Integer> dups= new LinkedHashSet<>();
        for(int i=0;i<arr.length;i++){
            if(!set.add(arr[i])){
                dups.add(arr[i]);
            }
        }
        if(dups.isEmpty()){
            result.add(-1);
            return result;
        }
        result.addAll(dups);
        return result;
    }

    /*
        Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.

     */
    private static int getPairsCount(int[] arr, int arraySize, int sum) {
        int pairsCount=0;
        /*for(int rowCount=0;rowCount<arraySize;rowCount++){
            for(int colCount=0;colCount<arraySize;colCount++){
                if(rowCount==colCount){
                    break;
                }
                if(arr[rowCount]+arr[colCount]==sum){
                    pairsCount++;
                }
            }
        }*/

        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum)
                    pairsCount++;
        return pairsCount;
    }


    private static int[] findTwoElement(int arr[], int n) {
        int []k=new int[2];
        if(arr.length==2 && arr[0]==arr[1]){
            k[0]=arr[0];
            k[1]=arr[0]-1;
            return k;
        }

       Arrays.sort(arr);
       for(int i=0;i<arr.length-2;i++){
           if(arr[i]==arr[i+1]);{
               k[0]=arr[i+1];
               k[1]=arr[i+1]-1;
           }
       }
       return k;
    }

    static void rotateArr(int arr[], int d, int n)
    {
        // add your code here
        List<Integer> nums=Arrays.stream(arr)
                .boxed()
                .collect(java.util.stream.Collectors.toList());
        Collections.rotate(nums,d*-1);


        System.out.println(nums);
        arr=nums.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
