package sri.examples.polymorphism;

import java.util.Scanner;

public class Movie_Main {
    public static void main(String[] args) {
         /*
        the method that gets run is determined by the Java Virtual machine based
        on the runtime object and not this variable type.
        */
        Scanner scanner = new Scanner(System.in);
        while(Boolean.TRUE) {
            System.out.println("Enter the type ( A for Adventure, S Science fiction , C for comedy, Q for quit)");
            String type = scanner.nextLine();
            if("Qq".contains(type)){
                break;
            }
            System.out.println("Enter movie title : ");
            String title = scanner.nextLine();

            Movie.getMovie(type,title).watchMovie();
        }
    }
}
