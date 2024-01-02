package burger;

public class Store {

	public static void main(String[] args) {
		Meal doubleBeef = new Meal("Double Beef", 0.5);
		doubleBeef.addToppings(
			Topping.CHEESE,
			Topping.ONION,
			Topping.PICKLE,
			Topping.EXTRA_BEEF_PATTY
		);
		System.out.println(doubleBeef);

		Meal eggBeef = new Meal("Extra Sunny", 0.5);
		eggBeef.addToppings(
			Topping.CHEESE,
			Topping.ONION,
			Topping.SUNNY_SIDE_EGG
		);
		System.out.println(eggBeef);
	}
}
