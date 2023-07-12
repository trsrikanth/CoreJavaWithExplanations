package glca.general;

public class Test {

    public static void main(String[] args) {

        String str="Srikanth";

        for(int i=0;i<str.length();i++){
            if(i%2==0){
                System.out.print(String.valueOf(str.charAt(i)).toUpperCase());
            }else {
                System.out.print(String.valueOf(str.charAt(i)).toLowerCase());
            }
        }


        for(int i=5;i>0;i--){
            System.out.println(" ".repeat(i)+"*".repeat(5-i));
        }

        //printing v

        int nuberofRows=6;
        int numberofCols=(nuberofRows*2)-1;

        System.out.println("*".repeat(numberofCols));
        for(int rowCount=0;rowCount<nuberofRows;rowCount++){
            for(int columnCount=0;columnCount<numberofCols;columnCount++){
                if((rowCount==columnCount)||( columnCount==(numberofCols-rowCount-1))){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }



}

