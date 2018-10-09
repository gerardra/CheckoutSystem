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
		CheckoutItem checkoutItem = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 0);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		
		Assert.assertEquals(0.00, totalPrice, 0.0);
	}

	@Test
	public void buy3AndGe1FreeTest() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 3);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		
		Assert.assertEquals(219.00, totalPrice, 0.0);
	}

	@Test
	public void buy4AppleTv() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 4);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		
		Assert.assertEquals(328.50, totalPrice, 0.0);
	}

	@Test
	public void buy5AppleTv() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 5);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		
		Assert.assertEquals(438.00, totalPrice, 0.0);
	}

	@Test
	public void buy6AppleTv() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 109.50);
		checkoutItems.put(checkoutItem, 6);
		PriceRule priceRule = new AppleTvPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		
		Assert.assertEquals(438.00, totalPrice, 0.0);
	}
	

}
