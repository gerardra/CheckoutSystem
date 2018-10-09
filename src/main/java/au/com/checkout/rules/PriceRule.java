package au.com.checkout.rules;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;

public interface PriceRule {
	
	int THREE = 3;
	int FOUR = 4;
	
	double applyBusinessRules(final Map<CheckoutItem, Integer> checkoutItems);
	
	default double calculateTotalCheckoutItemCost(final Map.Entry<CheckoutItem, Integer> checkoutItem) {
		return checkoutItem.getKey().getItemPrice() * checkoutItem.getValue();
	}
	
	default Optional<Entry<CheckoutItem, Integer>> filterByCheckoutItemType(final Map<CheckoutItem, Integer> checkoutItems, final CheckoutItemType checkoutItemType) {
		return checkoutItems.entrySet().stream()
				.filter(entry -> checkoutItemType == entry.getKey().getItemSku()).findFirst();
	}
	

}
