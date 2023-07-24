public class Meal {
    private Burger burger;
    private Drink drink;
    private Item sideDish;

    private Meal(Burger burger, Drink drink, Item sideDish) {
        this.burger = burger;
        this.drink = drink;
        this.sideDish = sideDish;
    }

    public double getTotalPrice() {
        return (
                burger.getItemPrice() +
                drink.getItemPrice() +
                sideDish.getItemPrice()
                );
    }
}
