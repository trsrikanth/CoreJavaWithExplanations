package sri.quizz;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {

        int [] arr={1,2,3,4,5,6};



    }


    private static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        boolean subArraySumFound=Boolean.FALSE;
        ArrayList<Integer> positions= new ArrayList<>();
        int firstPosition=0;
        int nextPosition=0;
        while (!subArraySumFound){

            for(int i=firstPosition;i<arr.length;i++){
                if(s==Arrays.stream(Arrays.copyOfRange(arr,firstPosition,i)).sum()){
                    nextPosition=i;
                    subArraySumFound=Boolean.TRUE;
                    break;
               }
            }
            firstPosition++;
        }
        if(subArraySumFound){
            positions.add(0,firstPosition);
            positions.add(1,nextPosition);
        }
        return positions;
    }


}
