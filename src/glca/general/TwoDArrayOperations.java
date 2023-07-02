package glca.general;

import java.util.Scanner;

public class TwoDArrayOperations {
    public static void main(String[] args) {
        int [][] twoDA;
        int multiplier;
        twoDA= new int[][]{{2, 3, 4}, {5, 6, 9}, {8, 1, 3}};

        System.out.println("Before Multiplication");
        for(int row=0;row<twoDA.length;row++){
            System.out.print("[");
            for(int col=0;col<twoDA[row].length;col++){
                System.out.print(twoDA[row][col]);
                System.out.print(" ");
            }
            System.out.println("]");
        }

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number to multiply with 2D array");
        multiplier=scanner.nextInt();

        for(int row=0;row<twoDA.length;row++){

            for(int col=0;col<twoDA[row].length;col++){
                twoDA[row][col]=twoDA[row][col]*multiplier;
            }

        }

        System.out.println("After Multiplication");
        for(int row=0;row<twoDA.length;row++){
            System.out.print("[");
            for(int col=0;col<twoDA[row].length;col++){
                System.out.print(twoDA[row][col]);
                System.out.print(" ");
            }
            System.out.println("]");
        }

    }
}
