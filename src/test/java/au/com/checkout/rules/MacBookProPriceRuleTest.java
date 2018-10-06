package au.com.checkout.rules;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;



public class MacBookProPriceRuleTest {

private Map<CheckoutItem, Integer> checkoutItems;
	
	@Before
	public void setUp(){
		checkoutItems = new HashMap<CheckoutItem, Integer>();
	}

	@After
	public void tearDown() {
		checkoutItems = null;
	}
	
	@Test
	public void buy0IMacBookPro() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		checkoutItems.put(checkoutItem, 0);
		PriceRule priceRule = new MacBookProPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 0 == totalPrice);
	}

	@Test
	public void buy5IMacBookPro() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		checkoutItems.put(checkoutItem, 5);
		PriceRule priceRule = new MacBookProPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 5 == totalPrice);
	}

	@Test
	public void buy8IMacBookPro() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		checkoutItems.put(checkoutItem, 8);
		PriceRule priceRule = new MacBookProPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 8 == totalPrice);
	}

}
