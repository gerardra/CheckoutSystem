package au.com.checkout.rules;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;



public class AppleTvPriceRuleTest {

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
	public void buy0AndGe1FreeTest() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 0);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 0 == totalPrice);
	}

	@Test
	public void buy2AndGe1FreeTest() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 3);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 2 == totalPrice);
	}

	@Test
	public void buy3AndGe1FreeTest() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 3);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 2 == totalPrice);
	}

	@Test
	public void buy4AppleTv() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 4);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 3 == totalPrice);
	}

	@Test
	public void buy5AppleTv() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 5);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 4 == totalPrice);
	}

	@Test
	public void buy6AppleTv() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 6);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		Assert.assertTrue(checkoutItem.getItemPrice() * 4 == totalPrice);
	}
	

}
