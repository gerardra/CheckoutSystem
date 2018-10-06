package au.com.checkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.rules.PriceRule;

public class Checkout {

	private final Map<CheckoutItem, Integer> checkoutItems;
	private final List<PriceRule> priceRules;
	
	public Checkout(final List<PriceRule> priceRules) {
		 checkoutItems = new HashMap<CheckoutItem, Integer>();
		 this.priceRules = priceRules;
	}

	public double scanCheckoutItemAndCalculateTotal(final CheckoutItem checkoutItem) {
		checkoutItems.merge(checkoutItem, 1, Integer::sum);
		return calculateTotal();
	}
	
	public double calculateTotal() {
		double totalAmount = 0.0;
		for (PriceRule priceRule : priceRules) {
			totalAmount = totalAmount + priceRule.applyBusinessRules(checkoutItems);
		}
		return totalAmount;
	}
	
}
