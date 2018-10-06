package au.com.checkout.domain;

public class CheckoutItem {
	
	private final CheckoutItemType itemSku;
	
	private final String itemName;
	
	private final double itemPrice;
	
	private final double discountPrice;
	
	private CheckoutItem (final CheckoutItemType checkoutItemCode, final double itemPrice, final double discountPrice) {
		this.itemSku = checkoutItemCode;
		this.itemPrice = itemPrice;
		this.itemName = checkoutItemCode.getCheckoutItemName();
		this.discountPrice = discountPrice;
	}

	public static CheckoutItem checkoutItemWithDiscount(final CheckoutItemType checkoutItemCode, final double itemPrice, final double discountPrice) {
		return new CheckoutItem(checkoutItemCode, itemPrice, discountPrice);
	}

	public static CheckoutItem checkoutItem(final CheckoutItemType checkoutItemCode, final double itemPrice) {
		return new CheckoutItem(checkoutItemCode, itemPrice, 0.0);
	}
	
	public CheckoutItemType getItemSku() {
		return itemSku;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemSku == null) ? 0 : itemSku.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckoutItem other = (CheckoutItem) obj;
		if (itemSku == null) {
			if (other.itemSku != null)
				return false;
		} else if (!itemSku.equals(other.itemSku))
			return false;
		return true;
	}
	
	
}
