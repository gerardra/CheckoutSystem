package au.com.checkout.rules;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;

public class IpadPriceRule implements PriceRule {

	public double applyBusinessRules(final Map<CheckoutItem, Integer> checkoutItems) {
		double totalPrice = 0.0;
		final Optional<Entry<CheckoutItem, Integer>> ipadEntry = filterByCheckoutItemType(checkoutItems, CheckoutItemType.IPD);
		if (!ipadEntry.isPresent() || !ipadEntry.get().getKey().isDealOn()) {
			return totalPrice;
		}
		if (ipadEntry.get().getValue() > FOUR) {
			totalPrice = ipadEntry.get().getKey().getDiscountPrice() * ipadEntry.get().getValue();
		} else {
			totalPrice = ipadEntry.get().getKey().getItemPrice() * ipadEntry.get().getValue();
		} 
		return totalPrice;

	}

}
