package au.com.checkout.rules;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;

public class VgaPriceRule implements PriceRule {

	public double applyBusinessRules(final Map<CheckoutItem, Integer> checkoutItems) {
		double totalPrice = 0.0;
		Optional<Entry<CheckoutItem,Integer>> vgaEntry = filterByCheckoutItemType(checkoutItems, CheckoutItemType.VGA);
		Optional<Entry<CheckoutItem,Integer>> mbpEntry = filterByCheckoutItemType(checkoutItems, CheckoutItemType.MPB);
		if (!vgaEntry.isPresent()) {
			return totalPrice;
		}
		
		int numOfVgas = vgaEntry.get().getValue();
		int numOfMacBookPro = 0;
		if (mbpEntry.isPresent()) {
			numOfMacBookPro = mbpEntry.get().getValue();
		}
		
		int numOfVgaAfterDeal = numOfVgas - numOfMacBookPro;
		if (numOfVgaAfterDeal > 0) {
			totalPrice = vgaEntry.get().getKey().getItemPrice() * numOfVgaAfterDeal;
		}
		return totalPrice;
	}

}
