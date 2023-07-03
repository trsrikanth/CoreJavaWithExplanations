package sri.examples.collections.sets.tree_set_challenge;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/*
In this challenge, you'll be creating a Theatre class, that has a set of seats.
The Seat class should be a nested class on the Theatre class.
A Seat should be constructed with a row character and an integer, that represents the seat number within the row.
Each Seat should have a string, a seat number, in the format 'A005', where A is the row number, and
005 is the seat number within the row, It should be zero padded up to three digits.
Seat should also have a field, a boolean, indicating if the seat is reserved or not.
The theatre class should have three fields, theatre name, an integer for seats in row,
how many seats are in a single row in other words, and a field for the seats themselves.
This last field should be a TreeSet. A Theatre instance should be constructed with the
theatre name, the number of rows in the theatre, and the number of seats total in the theatre.
For simplicity, assume there are a uniform number of seats in every row,
and the number of rows should never exceed 26, so the rows will be labeled A through Z.
You should create the seats, and number them, as part of the initialization of a theatre class.
The theatre class should also have a printSeatMap method, that prints each seat,
with each row printed on a separate line. You should allow a booking agent to reserve
a single seat, and the printed seat map should show which seats are reserved.
If you want an extra challenge, create a second method on theatre, that lets an agent specify.
the number of reservations being requested. a range of rows (from A to C for example,
for front row seats). a range of seats (a number greater than or equal to 1,
and less than or equal to the rows per seat). For example, if there are 10 seats in each row,
you could assume the aisle seats are 1 and 9, and maybe your buyer isn't interested in an
aisle seat, so they should be able to specify 2 through 9 as the range of seat numbers.
The seats that get reserved, should be contiguous within a row.

 */
public class Theater {
    class Seat implements Comparable<Seat>{
        private String seatNum;
        private boolean reserved;

        public Seat(char rowChar,int seatNo) {
            this.seatNum = "%c%03d".formatted(rowChar,seatNo).toUpperCase();
        }

        @Override
        public String toString() {
            return seatNum;
        }


        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }
    }
    private String theatreName;
    private int seatsPerRow;


    private NavigableSet<Seat> seats;

    public Theater(String theatreName, int rows,int totalSeats) {
        this.theatreName = theatreName;
        this.seatsPerRow = totalSeats/rows;
        seats=new TreeSet<>();
        for(int i=0;i<totalSeats;i++){
            char rowChar=(char) (i/seatsPerRow+(int)'A');
            int seatInRow=i%seatsPerRow+1;
            seats.add(new Seat(rowChar,seatInRow));
        }
    }

    public void printSeatMap(){
        String seperatorLine="_".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map %n%1$s%n",seperatorLine,theatreName);
        int index=0;
        for(Seat s:seats){
            System.out.printf("%-8s%s",
                    s.seatNum+((s.reserved)?"\u25CF":""),
                    ((index++ +1)%seatsPerRow==0)?"\n":"");
        }
        System.out.println(seperatorLine);
    }

    public String reserverSeat(char row,int seat){
        Seat requestedSeat=new Seat(row,seat);
        Seat requested=seats.floor(requestedSeat);
        if(requested==null || !requested.seatNum.equals(requestedSeat.seatNum)){
            System.out.print("->No such seat: "+requestedSeat);
            System.out.printf(": Seats must be between %s and %s%n",
                    seats.first().seatNum,seats.last().seatNum);
        }else {
            if(!requested.reserved){
                requested.reserved=true;
                return requested.seatNum;
            }else {
                System.out.println("Seat's already reserved.");
            }
        }
        return null;
    }


    private boolean validate(int count,char first, char last,int min,int max){
        boolean result=(min>0 || seatsPerRow>= count || (max-min+1)>=count );
        result=result && seats.contains(new Seat(first,min));
        if(!result){
            System.out.printf("Invalid! %1$d seats between "+
                    "%2$c[%3$d-%4$d]-%5$c[%3$d-%4$d] Try again",
                    count,first,min,max,last);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first().seatNum,seats.last().seatNum);
        }
        return result;
    }

    public Set<Seat> reserveSeats(int count,char minRow,char maxRow,
                                  int minSeat,int maxSeat){
        char lastValid=seats.last().seatNum.charAt(0);
        maxRow=(maxRow<lastValid)?maxRow:lastValid;
        if(!validate(count,minRow,maxRow,minSeat,maxSeat)){
            return null;
        }
        NavigableSet<Seat> selected=null;
        for(char letter =minRow;letter<=maxRow;letter++){
            NavigableSet<Seat> contigous=seats.subSet(new Seat(letter,minSeat),true,
                    new Seat(letter,maxSeat),true);
            int index=0;
            Seat first=null;
            for(Seat current:contigous){
                if(current.reserved){
                    index=0;
                    continue;
                }
                first=(index==0)?current:first;
                if(++index==count){
                    selected=contigous.subSet(first,true,
                            current,true);
                    break;
                }
            }
            if(selected!=null){
                break;
            }
        }
        Set<Seat> reservedSeats=null;
        if(selected!=null){
            selected.forEach(s->s.reserved=true);
            reservedSeats=new TreeSet<>(selected);

        }
        return reservedSeats;
    }

}
