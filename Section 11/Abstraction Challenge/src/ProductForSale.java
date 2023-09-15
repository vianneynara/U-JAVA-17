public abstract class ProductForSale {

    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    double getSalesPrice(int quantity) {
        return price * quantity;
    }

    void printPricedItem(int quantity) {
        System.out.printf("QTY: %2d @ $%8.2f -> %-15s %-30s %n",
                quantity, price, type, description);
    }

    abstract void showDetails();
}
