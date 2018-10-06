package au.com.checkout.rules;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;



public class VgaPriceRuleTest {
	
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
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.VGA, 30.00);
		checkoutItems.put(checkoutItem, 0);
		PriceRule priceRule = new VgaPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 0 == totalPrice);
	}

	@Test
	public void buy2MacBookProAnd2Vga() {
		CheckoutItem vgaCheckoutItem = CheckoutItem.checkoutItem(CheckoutItemType.VGA, 30.00);
		CheckoutItem macBookCheckoutItem = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		checkoutItems.put(vgaCheckoutItem, 2);
		checkoutItems.put(macBookCheckoutItem, 2);
		PriceRule priceRule = new VgaPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(vgaCheckoutItem.getItemPrice() * (2 - 2) == totalPrice);
	}

	@Test
	public void buy5MacBookProAnd7Vga() {
		CheckoutItem vgaCheckoutItem = CheckoutItem.checkoutItem(CheckoutItemType.VGA, 30.00);
		CheckoutItem macBookCheckoutItem = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		checkoutItems.put(macBookCheckoutItem, 5);
		checkoutItems.put(vgaCheckoutItem, 7);
		PriceRule priceRule = new VgaPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(vgaCheckoutItem.getItemPrice() * (7 - 5) == totalPrice);
	}

	@Test
	public void buy7MacBookProAnd5Vga() {
		CheckoutItem vgaCheckoutItem = CheckoutItem.checkoutItem(CheckoutItemType.VGA, 30.00);
		CheckoutItem macBookCheckoutItem = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		checkoutItems.put(macBookCheckoutItem, 7);
		checkoutItems.put(vgaCheckoutItem, 5);
		PriceRule priceRule = new VgaPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(vgaCheckoutItem.getItemPrice() * 0 == totalPrice);
	}

}
