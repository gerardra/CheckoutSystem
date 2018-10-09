package au.com.checkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.rules.PriceRule;

public class Checkout {

	private final Map<CheckoutItem, Integer> checkoutItems;
	private final List<PriceRule> priceRules;
	
	public Checkout(final List<PriceRule> priceRules) {
		 checkoutItems = new HashMap<CheckoutItem, Integer>();
		 this.priceRules = priceRules;
	}

	public void scanCheckoutItem(final CheckoutItem checkoutItem) {
		checkoutItems.merge(checkoutItem, 1, Integer::sum);
	}
	
	public double calculateTotal() {
		return calculateChekoutItemsWithDeal() + calculateChekoutItemsWithOutDeal();
	}
	
	private double calculateChekoutItemsWithOutDeal() {
		return checkoutItems.entrySet().stream()
				.filter(checkoutItem -> !checkoutItem.getKey().isDealOn())
				.mapToDouble(item -> item.getKey().getItemPrice() * item.getValue())
				.sum();
	}
	
	private double calculateChekoutItemsWithDeal() {
		return priceRules.stream().collect(Collectors.summingDouble(priceRule -> priceRule.applyBusinessRules(checkoutItems)));
	}
}
