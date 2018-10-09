package au.com.checkout.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.checkout.Checkout;
import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;



public class MacBookProPriceRuleTest {

	private Checkout checkout;
	
	private List<PriceRule> priceRules = new ArrayList<PriceRule>();
	
	@Before
	public void setUp(){
		priceRules.add(new VgaPriceRule()); 
		priceRules.add(new IpadPriceRule()); 
		priceRules.add(new AppleTvPriceRule()); 
		checkout = new Checkout(priceRules);
	}

	@After
	public void tearDown() {
		priceRules.clear();
	}
	
	@Test
	public void buyOneIMacBookPro() {
		CheckoutItem checkoutItem = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		checkout.scanCheckoutItem(checkoutItem);
		Assert.assertEquals(1399.99, checkout.calculateTotal(), 0.0);
	}

	@Test
	public void buy5IMacBookPro() {
		CheckoutItem checkoutItem1 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem2 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem3 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem4 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem5 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		checkout.scanCheckoutItem(checkoutItem1);
		checkout.scanCheckoutItem(checkoutItem2);
		checkout.scanCheckoutItem(checkoutItem3);
		checkout.scanCheckoutItem(checkoutItem4);
		checkout.scanCheckoutItem(checkoutItem5);
		
		Assert.assertEquals(6999.95, checkout.calculateTotal(), 0.0);
	}

	@Test
	public void buy8IMacBookPro() {
		CheckoutItem checkoutItem1 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem2 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem3 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem4 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem5 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem6 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem7 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem checkoutItem8 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		
		checkout.scanCheckoutItem(checkoutItem1);
		checkout.scanCheckoutItem(checkoutItem2);
		checkout.scanCheckoutItem(checkoutItem3);
		checkout.scanCheckoutItem(checkoutItem4);
		checkout.scanCheckoutItem(checkoutItem5);
		checkout.scanCheckoutItem(checkoutItem6);
		checkout.scanCheckoutItem(checkoutItem7);
		checkout.scanCheckoutItem(checkoutItem8);
		Assert.assertEquals(11199.92, checkout.calculateTotal(), 0.0);
	}

}
