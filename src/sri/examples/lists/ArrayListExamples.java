package sri.examples.lists;
// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html
//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html

import java.util.*;

record GroceryItems(String name,String type, int count){
    public GroceryItems(String name) {
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
      return String.format("%d %s in %s",count,name.toUpperCase(),type);

    }
}
public class ArrayListExamples {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        arrayOfObjects();
        commonsArrayListUsages();
        moreListOperations();

        arrayListChallenge_main();
    }

    //First demonstration
    private static void arrayOfObjects(){
        Object[] groceryArray = new Object[3];
        groceryArray[0]=new GroceryItems("Milk");
        groceryArray[1]= new GroceryItems("Apples","PRODUCE",1);
        groceryArray[2] = "4 Oranges";

        System.out.println(Arrays.toString(groceryArray));


        GroceryItems[] groceryArray1 = new GroceryItems[3];
        groceryArray1[0]=new GroceryItems("Milk");
        groceryArray1[1]= new GroceryItems("Apples","PRODUCE",1);
        groceryArray1[2] = new GroceryItems("Oranges","PRODUCE",4);

        System.out.println(Arrays.toString(groceryArray1));

    }

    //Second demonstration
    private static void oldArrayListUsage(){

        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItems("Milk"));
        objectList.add(new GroceryItems("Apples","PRODUCE",1));
        objectList.add("Curd");


    }

    private static void commonsArrayListUsages(){
        ArrayList<GroceryItems> groceryList= new ArrayList<>(); // <> diamond operator
        groceryList.add(new GroceryItems("Milk"));
        groceryList.add(new GroceryItems("Apples","PRODUCE",1));
        groceryList.add(0,
                new GroceryItems("Oranges","PRODUCE",4));
        groceryList.set(1,new GroceryItems("Grapes","PRODUCE",1));
        System.out.println(groceryList);
        groceryList.remove(1);
        System.out.println(groceryList);

    }

    private static void moreListOperations(){

        //transform array of items to list
        String[] items = {"apples","bananas","grapes"};
        List<String> list = List.of(items); //factory method
        System.out.println(list);
        //list.add("curd"); we cannot perform this action as its immutable.


        // converting immutable list to mutable arraylist
        ArrayList<String> groceries= new ArrayList<>(list);
        groceries.add("curd");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(List.of("Pickles","mustard","cheese"));
        System.out.println(nextList);

        groceries.addAll(nextList);
        System.out.println(groceries);


        // general search operations
         System.out.println("Third item = " + groceries.get(2));
         if(groceries.contains("mustard")){
             System.out.println("List contains mustard");
         }

         groceries.add("mustard");
        System.out.println("First = "+groceries.indexOf("mustard"));
        System.out.println("last = "+groceries.lastIndexOf("mustard"));


        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("mustard"); // removes only one instance
        System.out.println(groceries);

        groceries.removeAll(List.of("apples","grapes"));
        System.out.println(groceries);

        groceries.retainAll(List.of("apples","curd","mustard"));

        System.out.println(groceries);

        groceries.clear();

        System.out.println(groceries);

        System.out.println("isEmpty "+groceries.isEmpty());


        groceries.addAll(List.of("apples","milk","musturd","cheese"));
        groceries.addAll(Arrays.asList("eggs","pickles","musturd","ham"));

        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());

        System.out.println(groceries);
        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        var groceriesArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceriesArray));
        

    }


    private static void arrayListChallenge_main(){

        //Scanner scanner = new Scanner(System.in);
        boolean runAgain=Boolean.TRUE;
        ArrayList<String> groceryList = new ArrayList<>();
        while (runAgain){
            /*System.out.printf("Available actions: %n" +
                    "0 - to shutdown %n" +
                    "1 - to add item(s) to list (comma delimited list%n" +
                    "2 - to remove any items (comma delimited list)%n" +
                    "Enter a number for which action you want to do:");*/
            String textBlock= """
                    Available actions:
                    0 - to shutdown
                    1 - to add item(s) to list (comma delimited list
                    2 - to remove any items (comma delimited list)
                    Enter a number for which action you want to do:""";
            System.out.print(textBlock+" ");
            int option=0;
            try {
                option=Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println();
                System.out.println("Enter valid value");
                continue;
            }


            switch (option){
                case 0 -> runAgain=Boolean.FALSE;
                case 1 -> addItems(groceryList);
                case 2 -> removeItems(groceryList);
                default -> runAgain=Boolean.FALSE;
            }
            groceryList.sort(Comparator.naturalOrder());
            System.out.println(groceryList);
        }
    }

    private static void removeItems(ArrayList<String> groceryList) {
        String itemsToRemove=scanner.nextLine();
        String[] items=itemsToRemove.split(",");
        for(String item:items){
            groceryList.remove(item.trim());
      }
    }

    private static void addItems(ArrayList<String> groceryList) {
        String itemsToAdd=scanner.nextLine();
        String[] items=itemsToAdd.split(",");
        for(String item:items){
            if(groceryList.indexOf(item.trim())<0){
                groceryList.add(item.trim());
            }
        }
    }


}



