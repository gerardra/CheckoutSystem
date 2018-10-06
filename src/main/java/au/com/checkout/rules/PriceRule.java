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
	
	default double calculateTotalCost(final Map.Entry<CheckoutItem, Integer> checkoutItem) {
		double totalPrice = 0.0;
		int noOfItems = checkoutItem.getValue();
		double itemPrice = checkoutItem.getKey().getItemPrice();
		totalPrice = totalPrice + (itemPrice * noOfItems);
		return totalPrice;
	}
	
	default Optional<Entry<CheckoutItem, Integer>> filterByCheckoutItemType(final Map<CheckoutItem, Integer> checkoutItems, final CheckoutItemType checkoutItemType) {
		return checkoutItems.entrySet().stream()
				.filter(entry -> checkoutItemType == entry.getKey().getItemSku()).findFirst();
	}
	

}
