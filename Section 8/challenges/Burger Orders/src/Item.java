public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getItemPrice() {
        return price;
    }

    public void printPrice() {
        System.out.printf(getName() + "\t\t\t\t $" + getItemPrice() + "%n");
    }

    public String getName() {
        return name;
    }
}

class Burger extends Item {
    private String topping1, topping2, topping3;
    private double topping1price, topping2price, topping3price;

    public Burger(String name, double price) {
        super(name, price);
    }

    public void addTopping1(String topping, double price) {
        topping1 = topping;
        topping1price = price;
    }

    public void addTopping2(String topping, double price) {
        topping2 = topping;
        topping2price = price;
    }

    public void addTopping3(String topping, double price) {
        topping3 = topping;
        topping3price = price;
    }

    @Override
    public double getItemPrice() {
        return (super.getItemPrice() +
                ((topping1 == "") ? 0 : topping1price) +
                ((topping2 == "") ? 0 : topping2price) +
                ((topping3 == "") ? 0 : topping3price)
        );
    }

    public void printToppingList() {
        System.out.println("Burger base price\t\t $" + getItemPrice());
        if (topping1price != 0) System.out.println("+ " + topping1 + " \t\t\t\t $" + topping1price);
        if (topping2price != 0) System.out.println("+ " + topping2 + " \t\t\t\t $" + topping2price);
        if (topping3price != 0) System.out.println("+ " + topping3 + " \t\t\t\t $" + topping3price);
    }
}

class Drink extends Item {
    private boolean upSize;

    public Drink(String name) {
        this(name, false);
    }
    public Drink(String name, boolean upSize) {
        super(
                switch (name.toUpperCase().charAt(0)) {
                    case 'S' -> {
                        if (upSize) yield "(up) Sprite\t\t\t\t";
                        else yield "Sprite\t\t\t\t\t";
                    }
                    case 'F' -> {
                        if (upSize) yield "(up) Fanta";
                        else yield "Fanta";
                    }
                    case 'L' -> {
                        if (upSize) yield "(up) Lemon Tea";
                        else yield "Lemon Tea";
                    }
                    default -> {
                        if (upSize) yield "(up) Coca-cola\t";
                        else yield "Coca-cola";
                    }
                },
                switch (name.toUpperCase().charAt(0)) {
                    case 'S' -> 0.5;
                    case 'F' -> 0.6;
                    case 'L' -> 0.7;
                    default -> 0.9;
                }
        );
        this.upSize = upSize;
    }

    @Override
    public double getItemPrice() {
        return (((!upSize) ? super.getItemPrice() : (super.getItemPrice() + 0.2)));
    }
}