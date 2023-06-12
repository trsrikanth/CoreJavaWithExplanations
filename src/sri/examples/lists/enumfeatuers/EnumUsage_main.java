package sri.examples.lists.enumfeatuers;

import java.util.Random;

public class EnumUsage_main {
    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek=DayOfTheWeek.SUN;
        System.out.println(dayOfTheWeek);
        for(int i =0;i<10;i++){
            dayOfTheWeek=randomDay();
            /*System.out.printf("Name is %s, Ordinal value = %d%n",dayOfTheWeek,dayOfTheWeek.ordinal());

            if(dayOfTheWeek==DayOfTheWeek.FRI){
                System.out.println("Found a friday!!!");
            }*/

            switchOfTheWeek(dayOfTheWeek);
        }
        System.out.println("=".repeat(20));
        for(Toppings toppings:Toppings.values()){
            System.out.println(toppings.name()+" : "+toppings.getPrice());
        }

   }

    public static DayOfTheWeek randomDay(){
        int randomInt = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();
        return allDays[randomInt];
    }

    public static void switchOfTheWeek(DayOfTheWeek dayOfTheWeek){
        int weekDayInteger = dayOfTheWeek.ordinal()+1;
        switch (dayOfTheWeek){
            case WED -> System.out.println("Wednesday is Day "+weekDayInteger);
            case SAT -> System.out.println("Saturday is Day "+weekDayInteger);
            default -> System.out.println(dayOfTheWeek.name().charAt(0)+
                    dayOfTheWeek.name().substring(1).toLowerCase()+
                    "day is Day "+ weekDayInteger);

        }
    }
}
