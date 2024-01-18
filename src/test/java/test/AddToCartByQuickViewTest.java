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
		productQuickViewPage.selectColour(0);
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
	//	Assert.assertEquals(cartPage.getNoOfProductsPresentInCart(driver),2);		
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

