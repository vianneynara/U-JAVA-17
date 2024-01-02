package burger;

public class Meal {

	private double price = 5.0;
	private Burger burger;
	private Item drink;
	private Item side;
	private double conversionRate;

	public Meal() {
		this("Basic Meal", 1.0);
	}

	public Meal(String name, double conversionRate) {
		this.conversionRate = conversionRate;

		// Base burger
		this.burger = new Burger(name);
		addTopping(Topping.BASE_BEEF_PATTY);
		addTopping(Topping.LETTUCE);
		addTopping(Topping.TOMATO);

		// Base drink and side
		this.drink = new Item("Coke", "drink", 1.5);
		this.side = new Item("Fries", "side", 2.5);
	}

	public double getTotalPrice() {
		return Item.getConvertedPrice(burger.price + drink.price + side.price, conversionRate);
	}

	public void addTopping(Topping topping) {
		if (burger.toppingIndex < burger.toppings.length - 1) {
			burger.toppings[++burger.toppingIndex] = topping;
			burger.price += topping.price;
		}
	}

	public void addToppings(Topping... toppings) {
		for (Topping topping : toppings) {
			addTopping(topping);
		}
	}

	@Override
	public String toString() {
		return ("Meal ($%4.2f): " +
			"%n\t\\ %s " +
			"%n\t\\ %s " +
			"%n\t\\ %s ")
			.formatted(getTotalPrice(), burger, drink, side);
	}

	/** Item class to generify meal items */
	private class Item {

		protected String name;
		protected String type;
		protected double price;

		public Item(String name, String type) {
			// `Meal.this` is used to access the outer class's instance instead of the current scope
			this(name, type, type.equals("burger") ? Meal.this.price : 0);
		}

		public Item(String name, String type, double price) {
			this.name = name;
			this.type = type;
			this.price = price;
		}

		@Override
		public String toString() {
			return "%-10s $%5.2f %s".formatted(type, getConvertedPrice(price, conversionRate), name);
		}

		private static double getConvertedPrice(double price, double rate) {
			return price * rate;
		}
	}

	/** Burger class with toppings */
	public class Burger extends Item {

		private Topping[] toppings = new Topping[8];
		private int toppingIndex = -1;

		public Burger(String name) {
			super(name, "burger");
		}

		@Override
		public String toString() {
			StringBuilder toppings = new StringBuilder();
			for (Topping topping : this.toppings) {
				if (topping != null) {
					toppings.append(topping.name).append(", ");
				}
			}
			toppings.delete(toppings.length() - 2, toppings.length());
			return "%s (%s)".formatted(super.toString(), toppings);
		}
	}
}
