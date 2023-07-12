package glca.general;

import java.util.*;

public class SelfPractice {
    public static void main(String[] args) {
        char ch='A';
        int number=94;
        System.out.printf("Char %c converted to integer is %d%n Number %d conveted to string is %s%n",ch,(int)ch,number, String.valueOf(number));

        System.out.println("anagaram check "+areAnagram("listen","silent"));
        System.out.println("is balance check "+isBalancedString("{[]()}"));

        numberSumOfPrimes(9);

        perfectNumber();
    }

    private static void maxOfThreeNumbers(){
        Random random = new Random();
        int a,b,c=0;
        a=random.nextInt(100);
        b=random.nextInt(121);
        c=random.nextInt(132);

        if(a>b){
            if(a>c){
                System.out.printf("The max of %d,%d,%d is %d",a,b,c,a);
            }else {
                System.out.printf("The max of %d,%d,%d is %d",a,b,c,c);
            }
        }else {
            if(b>c){
                System.out.printf("The max of %d,%d,%d is %d",a,b,c,b);
            }else {
                System.out.printf("The max of %d,%d,%d is %d",a,b,c,c);
            }
        }

        System.out.println("\nMax using math functions");
        System.out.printf("Maximum of %d,%d,%d is %d",a,b,c,Math.max(a,Math.max(b,c)));

        System.out.println("\nMax using arrays and stream functions");
        int []numbers={a,b,c};
        OptionalInt max=Arrays.stream(numbers).max();
        System.out.printf("Maximum of %d,%d,%d is %s%n",a,b,c,max.toString());

        System.out.println("\nMax using arrays and for loop functions");
        int tempMax=Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>tempMax){
                tempMax=numbers[i];
            }
        }
        System.out.printf("Maximum of %d,%d,%d is %s%n",a,b,c,tempMax);


        List numberList=new ArrayList<>(List.of(numbers));
        numberList.stream().max(Comparator.naturalOrder());
    }


    private static boolean areAnagram(String sampleString1,String sampleString2){
        if(sampleString1.length()==sampleString2.length()){
            char[] chars1= sampleString1.toCharArray();
            Arrays.sort(chars1);
            char[] chars2= sampleString2.toCharArray();
            Arrays.sort(chars2);
            return Arrays.compare(chars1,chars2)==0;
        }
        return false;
    }


    private static boolean isBalancedString(String atr){

        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<atr.length();i++){
            char x=atr.charAt(i);
            if("{[(".indexOf(x)>=0){
                stack.push(x);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            char check;
            switch (x){

                case ')': {
                    check=stack.pop();
                    if("{[".indexOf(check)>=0){
                        return false;
                    }
                    break;
                }
                case ']':{
                    check=stack.pop();
                    if("{(".indexOf(check)>=0){
                        return false;
                    }
                    break;
                }
                case '}':{
                    check=stack.pop();
                    if("([".indexOf(check)>=0){
                        return false;
                    }
                    break;
                }
            }

        }
        return stack.isEmpty();
    }


    private static void numberSumOfPrimes(int number){
        boolean flag=false;
        for(int i=2;i<=number/2;i++){
            if(checkPrime(i)){
                if(checkPrime(number-i)){
                    // n = primeNumber1 + primeNumber2
                    System.out.printf("%d = %d + %d\n", number, i, number - i);
                    flag = true;
                }
            }
        }

        if (!flag)
            System.out.println(number + " cannot be expressed as the sum of two prime numbers.");
    }


    private static boolean checkPrime(int number){
        boolean isPrime=Boolean.TRUE;
        for(int i=2;i<=number/2;++i){
            if(number%i==0){
                isPrime=Boolean.FALSE;
                break;
            }
        }
        return isPrime;
    }

    private static boolean perfectNumber(){

        List numbers=new ArrayList<>(List.of(1,2,3,4,5,6,7,2,7,12,17,22,4,9,14,19,24,19));

        for(int i=0;i<numbers.size()-2;i++){
            List subList=numbers.subList(i,i+3);

                if((subList.indexOf(1)-subList.indexOf(0))==(subList.indexOf(2)-subList.indexOf(1))){
                    System.out.println("Perfect number sublist");
                    System.out.println(subList);
                }


        }

        return false;
    }

    private static boolean checkIfPN(int numb1,int numb2,int numb3){
        return (numb2-numb1==numb3-numb1);
    }
}
