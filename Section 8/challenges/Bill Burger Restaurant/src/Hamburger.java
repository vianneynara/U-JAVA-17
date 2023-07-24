public class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;
    // additions
    private String addition1Name, addition2Name, addition3Name, addition4Name;
    private double addition1Price, addition2Price, addition3Price, addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
        System.out.println("%s hamburger on a %s roll with %s, price is %d");
    }

    public void addHamburgerAddition1(String name, double price) {
        addition1Name = name;
        addition1Price = price;
        System.out.printf("Added %s for an extra %s", name, price);
    }

    public void addHamburgerAddition2(String name, double price) {
        addition2Name = name;
        addition2Price = price;
        System.out.printf("Added %s for an extra %s", name, price);
    }

    public void addHamburgerAddition3(String name, double price) {
        addition3Name = name;
        addition3Price = price;
        System.out.printf("Added %s for an extra %s", name, price);
    }

    public void addHamburgerAddition4(String name, double price) {
        addition4Name = name;
        addition4Price = price;
        System.out.printf("Added %s for an extra %s", name, price);
    }

    public double itemizeHamburger() {
        return (
                price +
                        ((addition1Price == 0) ? 0 : addition1Price)  +
                        ((addition2Price == 0) ? 0 : addition2Price)  +
                        ((addition3Price == 0) ? 0 : addition3Price)  +
                        ((addition4Price == 0) ? 0 : addition4Price)
                );
    }
}

class DeluxeBurger extends Hamburger {
    public DeluxeBurger () {
        super("Deluxe Burger", "Juicy Meat", 19.1, "Idk");
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }
}

class HealthyBurger extends Hamburger {
    private String healthyExtra1Name, healthyExtra2Name;
    private double healthyExtra1Price, healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy Burger", meat, price, "Healthy thing idk");
    }

    public void addHealthyAddition1(String name, double price) {
        healthyExtra1Name = name;
        healthyExtra1Price = price;
        System.out.printf("Added %s for an extra %s", name, price);
    }

    public void addHealthyAddition2(String name, double price) {
        healthyExtra2Name = name;
        healthyExtra2Price = price;
        System.out.printf("Added %s for an extra %s", name, price);
    }

    @Override
    public double itemizeHamburger() {
        return (
                super.itemizeHamburger() +
                ((healthyExtra1Price == 0) ? 0 : healthyExtra1Price)  +
                ((healthyExtra2Price == 0) ? 0 : healthyExtra2Price)
                );
    }
}
