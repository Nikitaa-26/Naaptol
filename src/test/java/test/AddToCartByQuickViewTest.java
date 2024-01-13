package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pojo.LaunchBrowser1;
import pom.AddProductFromDescriptionPage;
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
@Listeners(test.Listeners.class)
public class AddToCartByQuickViewTest extends BaseTest{
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
	
	@Test (priority=1)
	public void verifyIfUserIsAbleToAddProdutToCartUsingQuickViewOption() throws InterruptedException{
		// Test=extentReport.createTest("verifyIfUserIsAbleToAddProdutToCartUsingQuickViewOption");
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");		
		naaptolHomePage.ClickOnSearch();
		
		productResultPage = new ProductResultPage(driver);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("laptop"));
		productResultPage.clickOnQuickView(driver,1);
		
		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnBuyButton();
		
	    CartPage cartPage = new CartPage(driver);
	    Assert.assertEquals(cartPage.getNoOfProductsPresentInCart(driver),1);	
	}
	@Test(priority=2)
	public void verifyIfUserIsAbleToAddMultipleProdutToCartUsingQuickViewOption() throws InterruptedException {
	//	 Test=extentReport.createTest("verifyIfUserIsAbleToAddMultipleProdutToCartUsingQuickViewOption");
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();
		
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver,0);
		
		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnBuyButton();
		productQuickViewPage.clickOnContinueShopping();
		
		productResultPage.clickOnQuickView(driver, 1);
		
		productQuickViewPage.clickOnBuyButton();
	     
		CartPage cartPage = new CartPage(driver);
		cartPage.enterOnRemoveToRemoveTheProduct(driver,1);
		cartPage.enterOnRemoveToRemoveTheProduct(driver,0);	
	//	Assert.assertEquals(cartPage.getNoOfProductsPresentInCart(driver),2);		
	}
	@Test(priority=3)
    public void  VerifyIfUserIsAbleToRemoveProdutFromCart() throws InterruptedException { 
		//Test=extentReport.createTest("VerifyIfUserIsAbleToRemoveProdutFromCart");
		naaptolHomePage = new NaaptolHomePage(driver);
   	    naaptolHomePage.enterSearchTab("laptop");
   	    naaptolHomePage.ClickOnSearch();
   	    
   	    productResultPage = new ProductResultPage(driver);
   	    productResultPage.clickOnQuickView(driver,4);
   	    
   	    productQuickViewPage = new ProductQuickViewPage(driver);
   	    productQuickViewPage.clickOnBuyButton();
    	
   	    cartPage = new CartPage(driver);
		cartPage.enterOnRemoveToRemoveTheProduct(driver,4);   	
      }
	//scenario 9 to 12
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
		double OrderAmt = productQuickViewPage.getOrderAmt(0);
	//	System.out.println(OrderAmt);
		double TotalAmt =productQuickViewPage.getTotalAmt();
	//	System.out.println(TotalAmt);
		Assert.assertTrue(UnitPrice+ShippingPrice==TotalAmt);		
	}
	
	@Test
	public void AddTwoToCartAndVerifyIfUnitPriceAndShipingPriceIsEqualToOrderAmountAndAlsoVerifyIfSumOfOrderAmountIsEqualToCartAmount(){
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();		
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

