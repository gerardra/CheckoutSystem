package au.com.checkout.rules;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;

public class AppleTvPriceRule implements PriceRule {

	
	public double applyBusinessRules(final Map<CheckoutItem, Integer> checkoutItems) {
		double totalPrice = 0.0;
		final Optional<Entry<CheckoutItem,Integer>> atvEntry = filterByCheckoutItemType(checkoutItems, CheckoutItemType.ATV);
		if (!atvEntry.isPresent()) {
			return totalPrice;
		}
		if (atvEntry.get().getValue() < THREE) {
			totalPrice = calculateTotalCost(atvEntry.get());
		} else {
			int numOfItemsAfterDeal = applyDealToGetChargableNumberOfItems(atvEntry.get().getValue()); 
			totalPrice = atvEntry.get().getKey().getItemPrice() * numOfItemsAfterDeal;
		}
		return totalPrice;

	}
	
	private int applyDealToGetChargableNumberOfItems(int noOfItems) {
		return noOfItems - (noOfItems/THREE); 
	}

}
