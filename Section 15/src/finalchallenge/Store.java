package finalchallenge;

import java.time.LocalDate;
import java.util.*;

public class Store {

	private Map<String, InventoryItem> inventory;
	private NavigableSet<Cart> carts;
	private Map<Category, Map<String, InventoryItem>> aisleInventory; // category -- sku:item

	private Random random = new Random();

	public Store() {
		this.carts = new TreeSet<>(Comparator.comparing(Cart::getId));
	}

	void manageStoreCarts() {
		Cart cart1 = new Cart(Cart.CartType.PHYSICAL, 1);
		carts.add(cart1);
		cart1.addItem(aisleInventory.get(Category.PRODUCE).get("apple"), 6);
		cart1.addItem(aisleInventory.get(Category.PRODUCE).get("pear"), 5);
		cart1.addItem(aisleInventory.get(Category.BEVERAGE).get("coffee"), 2);
		System.out.println(cart1);

		cart1.removeItem(aisleInventory.get(Category.PRODUCE).get("pear"), 2);
		System.out.println(cart1);

		Cart cart2 = new Cart(Cart.CartType.VIRTUAL, 1);
		carts.add(cart2);
		cart2.addItem(inventory.get("L103"), 4);
		cart2.addItem(inventory.get("B100"), 6);
		System.out.println(cart2);

		Cart cart3 = new Cart(Cart.CartType.VIRTUAL, 0);
		carts.add(cart3);
		cart3.addItem(inventory.get("R777"), 5);
		System.out.println(cart3);

		if (!checkOutCart(cart3)) {
			System.out.println("Something went wrong!");
		}

		Cart cart4 = new Cart(Cart.CartType.PHYSICAL, 0);
		carts.add(cart4);
		cart4.addItem(aisleInventory.get(Category.BEVERAGE).get("tea"), 1);
		System.out.println(cart4);
	}

	boolean checkOutCart(Cart cart) {
		for (var cartItem : cart.getCartItems().entrySet()) {
			var item = inventory.get(cartItem.getKey());
			int qty = cartItem.getValue();
			if (!item.sellItem(qty)) return false;
		}
		cart.printSalesSlip(inventory);
		carts.remove(cart);
		return true;
	}

	boolean abandonCarts() {
		// TODO: Abandon carts if the date associated with the cart doesn't match today's date
		int dayOfYear = LocalDate.now().getDayOfYear();
		Cart lastCart = null;
		for (Cart cart : carts) {
			if (cart.getDate().getDayOfYear() == dayOfYear) {
				break;
			}
			lastCart = cart;
		}

		//getting the range from start to lastCart (inclusive true)
		var oldCarts = carts.headSet(lastCart, true);
		Cart abandondedCart = null;
		while ((abandondedCart = oldCarts.pollFirst()) != null) {
			//releasing the qty of each product in the iterated cart
			for (String sku : abandondedCart.getCartItems().keySet()) {
				InventoryItem item = inventory.get(sku);
				item.releaseItem(abandondedCart.getCartItems().get(sku));
			}
		}

		return false;
	}

	void listProductsByCategory() {
		listProductsByCategory(true, false);
	}

	void listProductsByCategory(boolean includeHeader, boolean includeDetail) {
		aisleInventory.keySet().forEach(k -> {
			if (includeHeader) System.out.printf("|> %s:%n", k);
			if (!includeDetail) {
				aisleInventory.get(k).keySet().forEach(p -> System.out.println(" - " + p));
			} else {
				aisleInventory.get(k).values().forEach(p -> System.out.println(" - " + p));
			}
		});
	}

	private void stockStore() {
		inventory = new HashMap<>();
		List<Product> products = new ArrayList<>(List.of(
			new Product("A100","apple","local",Category.PRODUCE),
			new Product("B100","banana","local",Category.PRODUCE),
			new Product("P100","pear","local",Category.PRODUCE),
			new Product("L103","lemon","local",Category.PRODUCE),
			new Product("M201","milk","farm",Category.DAIRY),
			new Product("Y001","yogurt","farm",Category.DAIRY),
			new Product("C333","cheese","farm",Category.DAIRY),
			new Product("R777","rice chex","Nabisco",Category.CEREAL),
			new Product("G111","granola","Nat Valley",Category.CEREAL),
			new Product("BB11","ground beef","butcher",Category.MEAT),
			new Product("CC11","chicken","butcher",Category.MEAT),
			new Product("BC11","bacon","butcher",Category.MEAT),
			new Product("BC77","coke","coca cola",Category.BEVERAGE),
			new Product("BC88","coffee","value",Category.BEVERAGE),
			new Product("BC99","tea","herbal",Category.BEVERAGE)
		));

		products.forEach(p -> inventory.put(
			p.sku(),
			new InventoryItem(p, random.nextInt(0, 5), 100, 3)
		));
	}

	private void listInventory() {
		System.out.println("-------------------------------------------------------");
		inventory.values().forEach(System.out::println);
	}

	private void stockAisles() {
		aisleInventory = new EnumMap<>(Category.class);
		for (InventoryItem item : inventory.values()) {
			Category aisleCategory = item.getProduct().category();

			Map<String, InventoryItem> aisleProducts = aisleInventory.get(aisleCategory);
			if (aisleProducts == null) {
				aisleProducts = new TreeMap<>();
			}
			aisleProducts.put(item.getProduct().name(), item);
			aisleInventory.putIfAbsent(aisleCategory, aisleProducts);
		}
	}

	public static void main(String... args) {
		Store store = new Store();
		store.stockStore();
		store.listInventory();
		store.stockAisles();
		store.listProductsByCategory();

		store.manageStoreCarts();
		store.listProductsByCategory(false, true);

		store.carts.forEach(System.out::println);
		store.abandonCarts();
		store.listProductsByCategory(false, true);
		store.carts.forEach(System.out::println);
	}
}
