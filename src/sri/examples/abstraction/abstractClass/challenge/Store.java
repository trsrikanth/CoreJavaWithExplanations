package sri.examples.abstraction.abstractClass.challenge;

import java.util.ArrayList;

record OrderItem(int qty,ProductForSale product) {}
public class Store {
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();
    public static void main(String[] args) {
        storeProducts.add(new ArtObject("Oil Painting",1350,
                "Good work by ABC painting company"));
        storeProducts.add(new ArtObject("Sculpture",2000,
                "bronze work by jkf, produced in 2010"));
        storeProducts.add(new Furniture("Desk",5000,"Mahogany desk"));
        storeProducts.add(new Furniture("Lamp",200,"Tiffany lamp with Humming birds"));
        listProducts();

        System.out.println("\nOrder 1");
        var order1=new ArrayList<OrderItem>();
        addItemToOrder(order1,1,2);
        addItemToOrder(order1,0,1);
        printOrder(order1);


        System.out.println("\nOrder 2");
        var order2=new ArrayList<OrderItem>();
        addItemToOrder(order2,3,5);
        addItemToOrder(order2,0,1);
        addItemToOrder(order2,2,1);
        printOrder(order2);
    }

    public static void listProducts(){
        for(var item:storeProducts){
            System.out.println("_".repeat(30));
            item.showDetails();
        }
    }


    private static void addItemToOrder(ArrayList<OrderItem> order,int orderIndex,int qty){
        order.add(new OrderItem(qty,storeProducts.get(orderIndex)));
    }
    private static void printOrder(ArrayList<OrderItem> order){
        double saleTotal=0;
        for(var item:order){
            item.product().printPricedItem(item.qty());
            saleTotal+=item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total = Rs%6.2f %n",saleTotal);
    }


}
