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
import au.com.checkout.rules.PriceRule;
import au.com.checkout.rules.VgaPriceRule;

public class CheckoutTest {
	
	private List<PriceRule> priceRules = new ArrayList<PriceRule>();
	
	private Checkout checkout;
	
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
		priceRules = null;
	}
	
	
	@Test
	public void buy1VgaAnd3AppleTV() {
		CheckoutItem vgaCheckoutItem1 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.VGA, 30.00);
		CheckoutItem atvCheckoutItem1 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 100.00);
		CheckoutItem atvCheckoutItem2 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 100.00);
		CheckoutItem atvCheckoutItem3 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 100.00);
		checkout.scanCheckoutItem(vgaCheckoutItem1);
		checkout.scanCheckoutItem(atvCheckoutItem1);
		checkout.scanCheckoutItem(atvCheckoutItem2);
		checkout.scanCheckoutItem(atvCheckoutItem3);
		
		Assert.assertEquals(230.00, checkout.calculateTotal(), 0.0);
	}

	@Test
	public void buy2AppleTVAnd5IPad() {
		CheckoutItem atvCheckoutItem1 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 100.00);
		CheckoutItem atvCheckoutItem2 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.ATV, 100.00);
		CheckoutItem checkoutItem1 = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 549.99, 500.00);
		CheckoutItem checkoutItem2 = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 549.99, 500.00);
		CheckoutItem checkoutItem3 = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 549.99, 500.00);
		CheckoutItem checkoutItem4 = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 549.99, 500.00);
		CheckoutItem checkoutItem5 = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 549.99, 500.00);
		
		checkout.scanCheckoutItem(atvCheckoutItem1);
		checkout.scanCheckoutItem(atvCheckoutItem2);
		checkout.scanCheckoutItem(checkoutItem1);
		checkout.scanCheckoutItem(checkoutItem2);
		checkout.scanCheckoutItem(checkoutItem3);
		checkout.scanCheckoutItem(checkoutItem4);
		checkout.scanCheckoutItem(checkoutItem5);
		
		Assert.assertEquals(2700.00, checkout.calculateTotal(), 0.0);
	}

	@Test
	public void buy1MacBookProAnd1VgaAnd1IPad() {
		CheckoutItem macBook1 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1400.00);
		CheckoutItem vga1 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.VGA, 30.00);
		CheckoutItem ipad1 = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 549.99, 500.00);
		checkout.scanCheckoutItem(macBook1);
		checkout.scanCheckoutItem(vga1);
		checkout.scanCheckoutItem(ipad1);
		
		Assert.assertEquals(1949.99, checkout.calculateTotal(), 0.0);
	}

	@Test
	public void buy1MacBookProAnd2VgaAnd1IPad() {
		CheckoutItem macBook1 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1300.00);
		CheckoutItem vga1 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.VGA, 30.00);
		CheckoutItem vga2 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.VGA, 30.00);
		CheckoutItem ipad1 = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 550.00, 500.00);
		
		checkout.scanCheckoutItem(macBook1);
		checkout.scanCheckoutItem(vga1);
		checkout.scanCheckoutItem(vga2);
		checkout.scanCheckoutItem(ipad1);
		
		Assert.assertEquals(1880, checkout.calculateTotal(), 0.0);
	}

	@Test
	public void buy1MacBookProAnd2VgaAnd1IPadAnd1IPhone() {
		CheckoutItem macBook1 = CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1300.00);
		CheckoutItem vga1 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.VGA, 50.00);
		CheckoutItem vga2 = CheckoutItem.checkoutItemWithDeal(CheckoutItemType.VGA, 50.00);
		CheckoutItem ipad1 = CheckoutItem.checkoutItemWithDiscountAndDeal(CheckoutItemType.IPD, 550.00, 500.00);
		CheckoutItem iphone = CheckoutItem.checkoutItem(CheckoutItemType.IPH, 300.00);
		
		checkout.scanCheckoutItem(macBook1);
		checkout.scanCheckoutItem(vga1);
		checkout.scanCheckoutItem(vga2);
		checkout.scanCheckoutItem(ipad1);
		checkout.scanCheckoutItem(iphone);
		
		Assert.assertEquals(2200.00, checkout.calculateTotal(), 0.0);
	}
	
	@Test
	public void buy2MacBookProAnd2IPhone() {
		checkout.scanCheckoutItem(CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1000.00));
		checkout.scanCheckoutItem(CheckoutItem.checkoutItem(CheckoutItemType.MPB, 1000.00));
		checkout.scanCheckoutItem(CheckoutItem.checkoutItem(CheckoutItemType.IPH, 300.00));
		checkout.scanCheckoutItem(CheckoutItem.checkoutItem(CheckoutItemType.IPH, 300.00));
		
		Assert.assertEquals(2600.00, checkout.calculateTotal(), 0.0);
	}
	
}
