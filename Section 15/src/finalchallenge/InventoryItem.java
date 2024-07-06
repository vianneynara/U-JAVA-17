package finalchallenge;

public class InventoryItem {

	private Product product;	//product of this item
	private int price;
	private int qtyTotal;		//total amount in stock, wherever it is
	private int qtyReserved;	//amount of products in the cart, not yet sold
	private int qtyReorder;		//reorder amount for ordering more products
	private int qtyLow;			//threshold to order more product

	public InventoryItem(Product product, int price, int qtyTotal, int qtyLow) {
		this.product = product;
		this.price = price;
		this.qtyTotal = qtyTotal;
		this.qtyReorder = 10;
		this.qtyLow = qtyLow;
	}

	public boolean reserveItem(int qty) {
		if ((qtyTotal - qtyReserved) >= qty) {
			qtyReserved += qty;
			return true;
		}

		return false;
	}

	public void releaseItem(int qty) {
		qtyReserved -= qty;
	}

	public boolean sellItem(int qty) {
		if (qtyTotal >= qty) {
			qtyTotal -= qty;
			qtyReserved -= qty;
			if (qtyTotal <= qtyLow) {
				placeInventoryOrder();
			}
			return true;
		}
		return false;
	}

	public void placeInventoryOrder() {
		System.out.printf("Reordering %d %s%n", qtyReorder, product.name());
//		qtyTotal += qtyReorder;
	}

	@Override
	public String toString() {
		return "%s, ($%d): [%04d, % 2d]".formatted(product, price, qtyTotal, qtyReserved);
	}

	//// GETTERS

	public Product getProduct() {
		return product;
	}

	public int getPrice() {
		return price;
	}
}