import java.util.ArrayList;

public class Store {

    private static ArrayList<ProductForSale> productsForSale;

    private boolean addItemToOrder() {
        return true;
    }

    public static void printOrder(ArrayList<OrderItem> order) {
        double total = 0;
        for (var item : order) {
            item.product().printPricedItem(item.quantity());
            total += item.product().getSalesPrice(item.quantity());
        }

        System.out.printf("Total = $%6.2f %n", total);
    }

    public static void listProducts() {
        for (var product : productsForSale) {
            System.out.println("-".repeat(30));
            product.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int index, int quantity) {
        order.add(new OrderItem(quantity, productsForSale.get(index)));
    }

    public static void main(String[] args) {
        productsForSale = new ArrayList<>();

        productsForSale.add(new ArtProduct("Painting", 1200, "'Quilloshe' by Hanz"));
        productsForSale.add(new ArtProduct("Sclupture", 820, "A miniature by Dewa"));
        productsForSale.add(new FurnitureProduct("Sofa", 1500, "Cool Sofa"));

        listProducts();

        System.out.println("\nOrder 1:\n");
        ArrayList<OrderItem> order1 = new ArrayList<>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        addItemToOrder(order1, 2, 3);

        printOrder(order1);
    }
}
