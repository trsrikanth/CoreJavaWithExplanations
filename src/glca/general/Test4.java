package glca.general;

public class Test4 {
    public static void main(String[] args) {

        int numberOfRows=4;

        int numberofColums=numberOfRows*2-1;

        for(int rowIndex=0;rowIndex<numberOfRows;rowIndex++){
            for (int colIndex=0;colIndex<numberofColums;colIndex++){
                if(rowIndex==colIndex){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }


        int numb1=10;
        int numb2=20;

        numb2=numb1+numb2;
        numb1=numb2-numb1;
        numb2=numb2-numb1;

        System.out.println("Numbers after swapping"+numb1+" , "+numb2);



        String test="abba";
        char [] temp=test.toCharArray();
        String tempString="";
        for(int i=test.length()-1;i>=0;i--){
            tempString +=temp[i];
        }
        if(test.equals(tempString)){
            System.out.println("Rotation is true on the string");
        }else{
            System.out.println("Rotation is false on the string");
        }

    }
}
