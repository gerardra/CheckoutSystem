package au.com.checkout.domain;

public enum CheckoutItemType {
	IPD("ipd", "Super iPad" ), MPB("mpb", "MacBook Pro"), ATV("atv", "Apple TV"), VGA("vga", "VGA adapter");
	
	private String checkoutItemCode;
	private String checkoutItemName;
	
	private CheckoutItemType(final String checkoutItemCode, final String checkoutItemName) {
		this.checkoutItemCode = checkoutItemCode;
		this.checkoutItemName = checkoutItemName;
	}
	
	public String getCheckoutItemCode() {
		return this.checkoutItemCode;
	}

	public String getCheckoutItemName() {
		return checkoutItemName;
	}

	
}
