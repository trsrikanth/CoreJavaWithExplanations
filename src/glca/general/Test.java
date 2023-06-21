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


        for(int i=20;i>0;i--){
            System.out.println(" ".repeat(i)+"*".repeat(20-i));
        }
    }



}

