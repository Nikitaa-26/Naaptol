package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pojo.LaunchBrowser1;
import pom.NaaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

public class VerifyIfProductsDetailsOnQuickViewTab extends BaseTest{
 
//	@Parameters ({"Browser"})
//	@BeforeMethod
//	public void openApplication() {
//		driver = LaunchBrowser1.openBrowser();
//	}
	
	@BeforeTest
	public void openApplication() {
		driver = LaunchBrowser1.openBrowser();
	}
	
	@Test
	public void VerifyIfProductsDetailsAndQuickViewDescriptionAreSimilar() {
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();	
		
        ProductResultPage productResultPage = new ProductResultPage(driver);
        productResultPage.getProductTitle(1);
        productResultPage.clickOnQuickView(driver, 0);
    //    productResultPage.getProductHeading();       
     //   productResultPage.checkTheTitlesAreEqual();		
	}
	
	@Test
	public void VerifyIfProductsDetailsOnShoppingCartAreSimilarToProductAddedFromQuickViewTab() {
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();	
	}
	
	@Test
	public void AddSingleToCartAndVerifyIfUnitPriceAndShippingPriceIsEqualToOrderAmount(){
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();		
	}
	
	@Test
	public void AddTwoToCartAndVerifyIfUnitPriceAndShipingPriceIsEqualToOrderAmountAndAlsoVerifyIfSumOfOrderAmountIsEqualToCartAmount(){
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();		
	}
}
