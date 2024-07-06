package finalchallenge;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private static int idCounter = 1;
	enum CartType {
		PHYSICAL,
		VIRTUAL
	};

	private int id;
	private Map<String, Integer> cartItems; // sku, qty
	private LocalDate date;
	private CartType type;	//physical / virtual

	public Cart(CartType type, int days) {
		this.id = idCounter++;
		this.cartItems = new HashMap<>();
		this.date = LocalDate.now().minusDays(days);
		this.type = type;
	}

	public Cart(int id) {
		this.id = id;
	}

	void addItem(InventoryItem item, int qty) {
		cartItems.merge(item.getProduct().sku(), qty, Integer::sum);

		if (!item.reserveItem(qty)) {
			System.out.println("There was an error while adding the item");
		}
	}

	void removeItem(InventoryItem item, int qty) {
		// current item quantity
		int cartQty = cartItems.get(item.getProduct().sku());
		if (cartQty <= qty) {
			qty = cartQty;
			cartItems.remove(item.getProduct().sku());
			System.out.printf("[%s] has been removed from the basket%n", item.getProduct().name());
		} else {
			cartItems.merge(item.getProduct().sku(), qty, (oldVal, newVal) -> oldVal - newVal);
		}
		item.releaseItem(qty);
	}

	void printSalesSlip(Map<String, InventoryItem> inventory) {
		int totalPrice = 0;
		System.out.println("------------------------------------------------------------");
		for (var cartItem : cartItems.entrySet()) {
			//associating key of cartItem and inventory which uses sku
			var item = inventory.get(cartItem.getKey());
			int qty = cartItem.getValue();
			int itemizedPrice = item.getPrice() * qty;
			totalPrice += itemizedPrice;
			System.out.printf("\t%s %-10s (%d)@ $%d = $%d%n",
				cartItem.getKey(), item.getProduct().name(), qty, item.getPrice(), itemizedPrice);
		}
		System.out.println("------------------------------------------------------------");
		System.out.printf("Grand Total: $%d%n", totalPrice);
	}

	@Override
	public String toString() {
		return "Cart{" +
			"id=" + id +
			", cartItems=" + cartItems +
			", date=" + date +
			'}';
	}

	public int getId() {
		return id;
	}

	public Map<String, Integer> getCartItems() {
		return cartItems;
	}

	public LocalDate getDate() {
		return date;
	}
}
