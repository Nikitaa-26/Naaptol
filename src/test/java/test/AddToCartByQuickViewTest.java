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
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
@Listeners(test.Listeners.class)
public class AddToCartByQuickViewTest extends BaseTest{
	ExtentReports extentReport;
	ExtentTest Test;	 
	
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
	public void verifyIfUserIsAbleToAddProdutToCartUsingQuickViewOption() {
		// Test=extentReport.createTest("verifyIfUserIsAbleToAddProdutToCartUsingQuickViewOption");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");		
		naaptolHomePage.ClickOnSearch();
		
		ProductResultPage productResultPage = new ProductResultPage(driver);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("laptop"));
		productResultPage.clickOnQuickView(driver,1);
		
		ProductQuickViewPage productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnBuyButton();
		
	    CartPage cartPage = new CartPage(driver);
	    Assert.assertEquals(cartPage.getNoOfProductsPresentInCart(driver),1);	
	}
	@Test(priority=2)
	public void verifyIfUserIsAbleToAddMultipleProdutToCartUsingQuickViewOption() throws InterruptedException {
	//	 Test=extentReport.createTest("verifyIfUserIsAbleToAddMultipleProdutToCartUsingQuickViewOption");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();
		
		ProductResultPage productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver,0);
		
		ProductQuickViewPage productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnBuyButton();
		productQuickViewPage.clickOnContinueShopping();
		
		ProductResultPage  productResultPage1 = new ProductResultPage(driver);
		productResultPage1.clickOnQuickView(driver, 1);
		
		ProductQuickViewPage productQuickViewPage1 = new ProductQuickViewPage(driver);
		productQuickViewPage1.clickOnBuyButton();
	     
		CartPage cartPage = new CartPage(driver);
		cartPage.enterOnRemoveToRemoveTheProduct(driver,1);
		cartPage.enterOnRemoveToRemoveTheProduct(driver,0);
		
		Assert.assertEquals(cartPage.getNoOfProductsPresentInCart(driver),2);		
	}
	@Test(priority=3)
    public void  VerifyIfUserIsAbleToRemoveProdutFromCart() throws InterruptedException { 
		//Test=extentReport.createTest("VerifyIfUserIsAbleToRemoveProdutFromCart");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
   	    naaptolHomePage.enterSearchTab("laptop");
   	    naaptolHomePage.ClickOnSearch();
   	    
   	    ProductResultPage productResultPage = new ProductResultPage(driver);
   	    productResultPage.clickOnQuickView(driver,4);
   	    
   	    ProductQuickViewPage productQuickViewPage = new ProductQuickViewPage(driver);
   	    productQuickViewPage.clickOnBuyButton();
    	
   	    CartPage cartPage = new CartPage(driver);
		cartPage.enterOnRemoveToRemoveTheProduct(driver,4);
    	
      }
	//scenario 9 to 12
	@Test
	public void VerifyIfProductsDetailsAndQuickViewDescriptionAreSimilar() {
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();	
		
        ProductResultPage productResultPage = new ProductResultPage(driver);
        productResultPage.getProductTitle(1);
        productResultPage.clickOnQuickView(driver, 0);
     //   productResultPage.getProductHeading();       
      //  productResultPage.checkTheTitlesAreEqual();		
	}
	
	@Test
	public void VerifyIfProductsDetailsOnShoppingCartAreSimilarToProductAddedFromQuickViewTab() {
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterSearchTab("laptop");
		naaptolHomePage.ClickOnSearch();
		ProductResultPage productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
	    ProductQuickViewPage productQuickViewPage = new ProductQuickViewPage(driver);
	    String expectedProductName = productQuickViewPage.getProductName();
//	    System.out.println(ProductName);	   
	    Double expectedPrice = productQuickViewPage.getProductPrice();
	//    System.out.println(price);	  
	    Double expectedShipping = productQuickViewPage.getShippingPrice();
	 //   System.out.println(shipping);
	    productQuickViewPage.clickOnBuyButton();
	    
	    CartPage cartPage = new CartPage(driver);
	    Assert.assertEquals(cartPage.getProductName(0,driver),expectedProductName);
	    Assert.assertEquals(cartPage.getProductName(0,driver),expectedPrice);
	    Assert.assertEquals(cartPage.getProductName(0,driver),expectedShipping);
		
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

