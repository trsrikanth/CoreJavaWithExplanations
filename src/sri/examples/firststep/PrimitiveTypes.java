package sri.examples.firststep;

public class PrimitiveTypes {
    public static void main(String[] args) {
        int myMinIntValue=Integer.MIN_VALUE;
        int myMaxIntValue=Integer.MAX_VALUE;
        System.out.printf("Integer range is (%d to %d) width in bits %d %n",myMinIntValue,myMaxIntValue,Integer.SIZE);

        System.out.printf("Busted Max int value %d%n",myMaxIntValue+1); //instead of throwing an error it overflowed.
        System.out.printf("Busted Min int value %d%n",myMinIntValue-1); //This concept is called Underflow this time, and not Overflow.
        // These situations are also known as integer wraparounds.
        //This is not usually behavior you really want, and as a developer, you need to be aware that this can happen,
        // and choose the appropriate data type.

        //myMaxIntValue=2147483648; // trying to assign max+1 compiler reports Integer number too large
        myMaxIntValue = 2_147_483_647; // for readability we can use underscores for numeric literals.
        //myMaxIntValue =_2_147_483_647_// we cannot keep _ at starting or end of numeric literal


        /*
        Maybe one reason to use a byte is, if you had a requirement to store a lot of numbers that are within that range,
        and you want to save memory or try to boost performance.
         */
        byte myMinByteValue=Byte.MIN_VALUE;
        byte myMaxByteValue=Byte.MAX_VALUE;
        System.out.printf("Byte range is (%d to %d) width in bits %d %n",myMinByteValue,myMaxByteValue,Byte.SIZE);

        short myMinShortValue=Short.MIN_VALUE;
        short myMaxShortValue=Short.MAX_VALUE;
        System.out.printf("Short range is (%d to %d) width in bits %d %n",myMinShortValue,myMaxShortValue,Short.SIZE);


        long myMinLongValue=Long.MIN_VALUE;
        long myMaxLongValue=Long.MAX_VALUE;
        System.out.printf("Long range is (%d to %d) width in bits %d %n",myMinLongValue,myMaxLongValue,Long.SIZE);

        /*
        The number 100, by default, is an int. Java allows certain numeric literals to have a suffix appended to the value,
        to force it to be a different data type from the default type.
        The long is one of these typesand its suffix is an 'L'. uppercase 'L' at the end of a whole number mean the same thing – the number is a long.
         */
        long myLong=100L; //

        //myLong=2_147_483_648;// integer number too large compilation error
        myLong=2_147_483_648L; // placing L suffix resolves the problem

        //short myShortValue=32768;  // results out to be incompatible types

        byte myByte=Byte.MAX_VALUE/2;
        System.out.println(myByte);

        // Casting means to treat or convert a number from one type to another.


        double myMinDoubleValue=Double.MIN_VALUE;
        double myMaxDoubleValue=Double.MAX_VALUE;
        System.out.printf("Double range is (%f to %f) width in bits %d %n",myMinDoubleValue,myMaxDoubleValue,Double.SIZE);

    }
}
