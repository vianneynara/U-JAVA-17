public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger("Regular", 4.5);
        burger.addTopping1("sausage", 0.25);

        Drink drink = new Drink("Fanta", true);
        Item sideItem = new Item("Fries", 2);

        printBill(burger, drink, sideItem);
        System.out.println();
        burger = new Burger("Regular", 4.5);
        drink = new Drink("Cola");
        sideItem = new Item("Fries", 2);

        printBill(burger, drink, sideItem);
    }

    public static void printBill(Burger burger, Drink drink, Item sideItem) {
        System.out.println(" _".repeat(7) + "BILL" + "_ ".repeat(7));
        burger.printToppingList();
        drink.printPrice();
        sideItem.printPrice();

        double totalPrice = burger.getItemPrice() + drink.getItemPrice() + sideItem.getItemPrice();
        System.out.println("-".repeat(31));
        System.out.printf("Total Price" + " ".repeat(13) + " $" + totalPrice + "\n");
    }
}
