package glca.general;

public class PracticeLogic {
    public static void main(String[] args) {
        int x=10;
        int y=20;
        ///int temp;
        System.out.println("Before swapping X contains "+x+" Y contains"+y);

        //logic of swapping
        y=x+y;
        x=y-x;
        y=y-x;

        System.out.println("After swapping X contains "+x+" Y contains"+y);

        String sampleString="Ramesh";
        char[] chars=sampleString.toCharArray();
        // logic is to iterate through the array of chars and if its and even count you need to
        // print in uppercase else lower case

        for(int i=0;i<chars.length;i++){
            if(i%2==0){
                if(97<=chars[i] && chars[i]<=122){
                    chars[i] -= 32;
                }
            }else {
                if(65<=chars[i] && chars[i]<=96) {
                    chars[i] +=32;
                }
            }
            System.out.print(chars[i]);
        }

    }
}
