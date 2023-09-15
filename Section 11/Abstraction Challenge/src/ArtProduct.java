public class ArtProduct extends ProductForSale {

    public ArtProduct(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    void showDetails() {
        System.out.println("This " + type + " is a finest production");
        System.out.printf("The price of this piece is $%6.2f %n", price);
        System.out.println(description);
    }
}
