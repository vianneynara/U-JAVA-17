package burger;

/**
 * Enum class to store list of toppings and their prices.
 */
public enum Topping {
	LETTUCE("Lettuce", 0.1),
	TOMATO("Tomato", 0.1),
	ONION("Onion", 0.1),
	PICKLE("Pickle", 0.1),
	CHEESE("Cheese", 0.3),
	SUNNY_SIDE_EGG("Sunny Side Egg", 1.0),
	BASE_BEEF_PATTY("Base Beef Patty", 0.0),
	EXTRA_BEEF_PATTY("Extra Beef Patty", 1.5);

	final String name;
	final double price;

	Topping(String name, double price) {
		this.name = name;
		this.price = price;
	}
}