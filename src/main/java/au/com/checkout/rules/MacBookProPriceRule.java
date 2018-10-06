package au.com.checkout.rules;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;

public class MacBookProPriceRule implements PriceRule {

	public double applyBusinessRules(final Map<CheckoutItem, Integer> checkoutItems) {
		final Optional<Entry<CheckoutItem, Integer>> mpbEntry = filterByCheckoutItemType(checkoutItems, CheckoutItemType.MPB);
		if (!mpbEntry.isPresent()) {
			return 0.0;
		}
		return calculateTotalCost(mpbEntry.get());
	}

}
