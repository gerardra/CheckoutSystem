package au.com.checkout;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.checkout.domain.CheckoutItem;
import au.com.checkout.domain.CheckoutItemType;
import au.com.checkout.rules.AppleTvPriceRule;
import au.com.checkout.rules.IpadPriceRule;
import au.com.checkout.rules.MacBookProPriceRule;
import au.com.checkout.rules.PriceRule;
import au.com.checkout.rules.VgaPriceRule;

public class CheckoutTest {
	
	private List<PriceRule> priceRules = new ArrayList<PriceRule>();
	
	@Before
	public void setUp(){
		priceRules.add(new VgaPriceRule()); 
		priceRules.add(new MacBookProPriceRule()); 
		priceRules.add(new IpadPriceRule()); 
		priceRules.add(new AppleTvPriceRule()); 
	}

	@After
	public void tearDown() {
		priceRules.clear();
		priceRules = null;
	}
	
	
	@Test
	public void buy1VgaAnd3AppleTV() {
		double totalPrice = 0.0;
		Checkout checkout = new Checkout(priceRules);
		CheckoutItem vgaCheckoutItem1 = CheckoutItem.checkoutItem(CheckoutItemType.VGA, 30.00);
		CheckoutItem atvCheckoutItem1 = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		CheckoutItem atvCheckoutItem2 = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		CheckoutItem atvCheckoutItem3 = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(vgaCheckoutItem1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(atvCheckoutItem1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(atvCheckoutItem2);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(atvCheckoutItem3);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		Assert.assertTrue(249.00 == checkout.calculateTotal());
	}

	@Test
	public void buy2AppleTVAnd5IPad() {
		double totalPrice = 0.0;
		Checkout checkout = new Checkout(priceRules);
		CheckoutItem atvCheckoutItem1 = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		CheckoutItem atvCheckoutItem2 = CheckoutItem.checkoutItem(CheckoutItemType.ATV, 109.50);
		CheckoutItem checkoutItem1 = CheckoutItem.checkoutItemWithDiscount(CheckoutItemType.IPD, 549.99, 499.99);
		CheckoutItem checkoutItem2 = CheckoutItem.checkoutItemWithDiscount(CheckoutItemType.IPD, 549.99, 499.99);
		CheckoutItem checkoutItem3 = CheckoutItem.checkoutItemWithDiscount(CheckoutItemType.IPD, 549.99, 499.99);
		CheckoutItem checkoutItem4 = CheckoutItem.checkoutItemWithDiscount(CheckoutItemType.IPD, 549.99, 499.99);
		CheckoutItem checkoutItem5 = CheckoutItem.checkoutItemWithDiscount(CheckoutItemType.IPD, 549.99, 499.99);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(atvCheckoutItem1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);

		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(checkoutItem1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);

		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(checkoutItem2);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);

		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(atvCheckoutItem2);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);

		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(checkoutItem3);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);

		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(checkoutItem4);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(checkoutItem5);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		Assert.assertTrue(2718.95 == checkout.calculateTotal());
	}

	@Test
	public void buy1MacBookProAnd1VgaAnd1IPad() {
		double totalPrice = 0.0;
		Checkout checkout = new Checkout(priceRules);
		CheckoutItem macBook1 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem vga1 = CheckoutItem.checkoutItem(CheckoutItemType.VGA, 30.00);
		CheckoutItem ipad1 = CheckoutItem.checkoutItemWithDiscount(CheckoutItemType.IPD, 549.99, 499.99);
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(macBook1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(vga1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(ipad1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		Assert.assertTrue(1949.98 == checkout.calculateTotal());
	}

	@Test
	public void buy1MacBookProAnd2VgaAnd1IPad() {
		double totalPrice = 0.0;
		Checkout checkout = new Checkout(priceRules);
		CheckoutItem macBook1 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1399.99);
		CheckoutItem vga1 = CheckoutItem.checkoutItem(CheckoutItemType.VGA, 30.00);
		CheckoutItem vga2 = CheckoutItem.checkoutItem(CheckoutItemType.VGA, 30.00);
		CheckoutItem ipad1 = CheckoutItem.checkoutItemWithDiscount(CheckoutItemType.IPD, 549.99, 499.99);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(macBook1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(vga1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);

		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(vga2);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		totalPrice = checkout.scanCheckoutItemAndCalculateTotal(ipad1);
		Assert.assertTrue(checkout.calculateTotal() == totalPrice);
		
		Assert.assertTrue(1979.98 == checkout.calculateTotal());
	}

	
	
}
