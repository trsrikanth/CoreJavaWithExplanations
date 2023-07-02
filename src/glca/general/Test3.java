package glca.general;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        int num1,num2,sum,sub,mul,div;
        int choice;
        int arithmaticOperationChoice;

        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("Enter the first number ");
            num1=scanner.nextInt();
            System.out.println("Enter the second number: ");
            num2=scanner.nextInt();
            System.out.println("Enter the arithmatic operation For 1. addition " +
                    "2. substraction -" +
                    "3. Multiplication /" +
                    "4. Divison %" );
            arithmaticOperationChoice=scanner.nextInt();
            switch (arithmaticOperationChoice){
                case 1:{
                    sum=num1+num2;
                    System.out.println("The sum of "+num1+" and "+num2+" is: "+sum);
                    break;
                }
                case 2:{
                    sub=num1-num2;
                    System.out.println("The difference of "+num1+" and "+num2+" is: "+sub);
                    break;
                }
                case 3:{
                    mul=num1*num2;
                    System.out.println("The Multiplication of "+num1+" and "+num2+" is: "+mul);
                    break;
                }
                case 4:{
                    div=num1/num2;
                    System.out.println("The Divison of "+num1+" and "+num2+" is: "+div);
                    break;
                }
                default:{
                    System.out.println("Enter proper choice");
                }
            }


            System.out.println("Enter 0 to exit or any other number to continue");
            choice=scanner.nextInt();
        } while (choice!=0);
    }

}
