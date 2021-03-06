package au.com.checkout.rules;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;



public class IpadPriceRuleTest {

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
	public void buy0IPadest() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 549.99, 499.99);
		checkoutItems.put(checkoutItem, 0);
		PriceRule priceRule = new IpadPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		
		Assert.assertEquals(0.00, totalPrice, 0.0);
	}

	@Test
	public void buy3IPadest() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 549.99, 499.99);
		checkoutItems.put(checkoutItem, 3);
		PriceRule priceRule = new IpadPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		
		Assert.assertEquals(1649.97, totalPrice, 0.0);
	}

	@Test
	public void buy5IPadest() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 549.99, 499.99);
		checkoutItems.put(checkoutItem, 5);
		PriceRule priceRule = new IpadPriceRule();
		double totalPrice = priceRule.applyBusinessRules(checkoutItems);
		
		Assert.assertEquals(2499.95, totalPrice, 0.0);
	}
}
