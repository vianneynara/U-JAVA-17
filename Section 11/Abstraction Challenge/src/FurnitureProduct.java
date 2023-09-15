public class FurnitureProduct extends ProductForSale {

    public FurnitureProduct(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    void showDetails() {
        System.out.println("This " + type + " is a finest furniture");
        System.out.printf("The price of this furniture is $%6.2f %n", price);
        System.out.println(description);
    }
}
