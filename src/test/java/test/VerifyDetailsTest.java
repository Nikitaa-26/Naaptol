package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser1;
import pom.AddProductFromDescriptionPage;
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

public class VerifyDetailsTest extends BaseTest{
//	ExtentReports extentReport;
//	ExtentTest Test;	 
	NaaptolHomePage naaptolHomePage;
	ProductResultPage productResultPage;
	AddProductFromDescriptionPage addProductFromDescriptionPage;
	ProductQuickViewPage productQuickViewPage;
	CartPage cartPage;

//	@Parameters ({"Browser"})
//	@BeforeMethod
//	public void openApplication(String browser) {
//		driver = LaunchBrowser.browser(browser);
//	}
	
	@BeforeMethod
	public void openApplication() {
		driver = LaunchBrowser1.openBrowser();
	}    
	@Test
	public void VerifyIfProductsDetailsAndQuickViewDescriptionAreSimilar() throws InterruptedException {
	    naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();	
		
        productResultPage = new ProductResultPage(driver);
        String expectedProductTitle = productResultPage.getProductTitle(0);
    //  System.out.println(expectedProductTitle);
        productResultPage.clickOnQuickView(driver, 0);
        productQuickViewPage = new ProductQuickViewPage(driver);
        String productTitle = productQuickViewPage.getProductTitle();
    //  System.out.println(productTitle);
        Assert.assertEquals(expectedProductTitle,productTitle);
        
	}
	
	@Test
	public void VerifyIfProductsDetailsOnShoppingCartAreSimilarToProductAddedFromQuickViewTab() throws InterruptedException {
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();
	   
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
	    productQuickViewPage = new ProductQuickViewPage(driver);
	    String expectedProductName = productQuickViewPage.getProductTitle();
    //  System.out.println(ProductName);	   
	    Double expectedPrice = productQuickViewPage.getProductPrice();
	//  System.out.println(price);	  
	    Double expectedShipping = productQuickViewPage.getShippingPrice();
	 // System.out.println(shipping);
	    productQuickViewPage.clickOnBuyButton();
	    
	    cartPage = new CartPage(driver);
	    Assert.assertEquals(cartPage.getProductName(0,driver),expectedProductName);
	    Assert.assertEquals(cartPage.getProductName(0,driver),expectedPrice);
	    Assert.assertEquals(cartPage.getProductName(0,driver),expectedShipping);		
	}
	
	@Test
	public void AddSingleToCartAndVerifyIfUnitPriceAndShippingPriceIsEqualToOrderAmount() throws InterruptedException{
	    naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("mobile");
		naaptolHomePage.ClickOnSearch();			
		
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
	
		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnBuyButton();
		
		double UnitPrice =productQuickViewPage.getUnitPrice(0);
	//	System.out.println(UnitPrice);
		double ShippingPrice =productQuickViewPage.getShippingPrice(0);
	//	System.out.println(ShippingPrice);
		double OrderAmt = productQuickViewPage.getOrderAmt(driver,0);
	//	System.out.println(OrderAmt);
		double TotalAmt =productQuickViewPage.getTotalAmt();
	//	System.out.println(TotalAmt);
		Assert.assertTrue(UnitPrice+ShippingPrice==TotalAmt);		
	}
	
	@Test
	public void AddTwoToCartAndVerifyIfUnitPriceAndShipingPriceIsEqualToOrderAmountAndAlsoVerifyIfSumOfOrderAmountIsEqualToCartAmount(){
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("mobile");
		naaptolHomePage.ClickOnSearch();	
		
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
	
		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnBuyButton();
		productQuickViewPage.clickOnContinueShopping();
	
		productResultPage.clickOnQuickView(driver, 1);
		
		productQuickViewPage.clickOnBuyButton();
	    
		double orderAmount1=productQuickViewPage.getOrderAmt(driver,0);
		System.out.println(orderAmount1);
		double orderAmount2=productQuickViewPage.getOrderAmt(driver,1);
		System.out.println(orderAmount2);
		double expectedCartAmount=productQuickViewPage.getTotalAmt();
		System.out.println(expectedCartAmount);
		Assert.assertTrue(orderAmount1+orderAmount2==expectedCartAmount);								
	}
//	@AfterMethod
//	public void addTestStatus(ITestResult result) {
//		
//		if(result.getStatus()==ITestResult.SUCCESS) {
//			
//			Test.log(Status.PASS, result.getName());
//		}
//		else if(result.getStatus()==ITestResult.FAILURE) {
//			
//			Test.log(Status.FAIL, result.getName());
//		}
//		else if(result.getStatus()==ITestResult.SKIP) {
//			
//			Test.log(Status.SKIP, result.getName());
//		}
//    
//	}
//	
//	 @AfterTest
//     public void publishReports() {
//
//    	 extentReport.flush();
//        }
}

