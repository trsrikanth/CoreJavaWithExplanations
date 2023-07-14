package sri.examples.controlflow.switches;

public class SwitchExamples {
    public static void main(String[] args) {
        simpleIfExamples();
        simpleSwitch();
        String month = "OCTOBER";
        System.out.println(month + " is in the "+getQuarter(month) +" quarter");

        printDayOfTheWeek(9);

    }

    private static void simpleIfExamples(){
        int value=1;
        if(value==1){
            System.out.println("Value was 1");
        } else if (value ==2) {
            System.out.println("Value was 2");
        } else if (value ==3 ) {
            System.out.println("Value was 3");
        }else {
            System.out.println("Value was not 1 or 2 or 3");
        }
    }

    /*
    Java provides another mechanism, called the switch  statement, that lets us test if a variable matches  a particular value, and will then execute one  or more lines of code if the check is true.

    The case keyword, as shown here, is used with the switch statement for comparison.

    switch value, case x, essentially means, in the case that value equals x, execute this code. If it doesn't, then move on to check the next case. The break keyword tells the switch statement to terminate any further checks. the default keyword means if none of the above cases were true, execute this code. 

    switch statement, is that it can only be used  with a limited type of variable data types.
    We can only use half of the primitives, byte, short,int and char, and their corresponding wrappers.
    We can use Strings and a type called enum.

    But, importantly, note that the primitive types of  boolean, long, float, and double, cannot be used.
     */
    private static void simpleSwitch(){

        int value =8;
        switch (value){
            case 1 :
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3:
                System.out.println("Value was 3");
                break;
            case 4,5,6 :
                System.out.println("Value was 4 or 5 or 6");
                break;
            case 7: case 8: case 9:
                System.out.println("Value was 8 or 9 or 7");
                break;
            default:
                System.out.println("Value was not 1 to 9");
                break;

        }
    }


    private static String getQuarter(String month){
        switch (month){
            case "JANUARY" :
            case "FEBRUARY" :
            case "MARCH ":
                return "1st";
            case "APRIL" :
            case "MAY":
            case "JUNE":
                return "2nd";
            case "JULY":
            case "AUGUST":
            case "SEPTEMBER":
                return "3rd";
            case "OCTOBER":
            case "NOVEMBER":
            case "DECEMBER":
                return "4rth";
        }
        return "bad";
    }


    private static String getQuarterEnhancedSwitch(String month){
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH " -> "1st";
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4rth";
            //default -> "bad"; // this is a valid statement if we want to change some thing like this.
            default -> {
                String badResponse=month + "is bad";
                //return badResponse; // this will error out
                yield badResponse; // this will work. yield statement has to be in a code block.
            }
        };
    }

    private static void printDayOfTheWeek(int day){
        String dayOfTheWeek= switch (day){
            case 0->"Sunday";
            case 1->{yield "Monday";}
            case 2->"Tuesday";
            case 3->"Wednesday";
            case 4->"Thursday";
            case 5->"Friday";
            case 6->"Saturday";
            default -> "Invalid Day";
        };
        System.out.println(day + " Stands for "+dayOfTheWeek);
    }


    private static void printNumberInWord(int number){
        switch (number) {
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            default:
                System.out.println("Other");
                break;
        };
    }



}
