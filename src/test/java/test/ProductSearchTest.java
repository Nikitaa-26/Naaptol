package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pojo.LaunchBrowser1;
import pom.NaaptolHomePage;
import pom.ProductResultPage;
@Listeners(test.Listeners.class)
public class ProductSearchTest extends BaseTest{
//	ExtentReports extentReport;
//	ExtentTest Test;
	NaaptolHomePage naaptolHomePage;
	ProductResultPage productResultPage;

//	 @Parameters ({"Browser"})
//	 @BeforeTest
//	 public void openApplication(String browser) {
//		driver =  LaunchBrowser.browser(browser);
//	 }
	
	@BeforeTest
	public void openApplication() {
		driver = LaunchBrowser1.openBrowser();
	}
	 
	 @Test(priority=1)
	 public void VerifyIfProductsAreDisplayedValidSearch() {
		// Test=extentReport.createTest("VerifyIfUserProductsAreDisplayedValidSearch");
		 naaptolHomePage = new NaaptolHomePage(driver);
		 naaptolHomePage.enterSearchTab("mobiles"); // mobiles
		 naaptolHomePage.ClickOnSearch();
		 String url = driver.getCurrentUrl();
		 System.out.println("url:"+ url);
		 Assert.assertTrue(url.contains("mobiles"));
		 productResultPage = new ProductResultPage(driver);
		 Assert.assertTrue(productResultPage.getNumberOfproducts()>0);
	 }
	 
	 @Test(priority = 2)
	 public void VerifyIfNoProductsAreDisplayedInalidSearch() {
		// Test=extentReport.createTest("VerifyIfUserProductsAreDisplayedInalidSearch");
		 naaptolHomePage = new NaaptolHomePage(driver);
		 naaptolHomePage.enterSearchTab("iphone");
		 naaptolHomePage.ClickOnSearch();
		 String url = driver.getCurrentUrl();
		 System.out.println("url:"+ url);
		 Assert.assertTrue(url.contains("iphone"));
		 productResultPage = new ProductResultPage(driver);
		 Assert.assertTrue(productResultPage.getNumberOfproducts()==0);		 		 
	 }
	
	 
//	 @AfterMethod
//		public void addTestStatus(ITestResult result) {
//			
//			if(result.getStatus()==ITestResult.SUCCESS) {
//				
//				Test.log(Status.PASS, result.getName());
//			}
//			else if(result.getStatus()==ITestResult.FAILURE) {
//				
//				Test.log(Status.FAIL, result.getName());
//			}
//			else if(result.getStatus()==ITestResult.SKIP) {
//				
//				Test.log(Status.SKIP, result.getName());
//			}
//	    
//		}
//		
//		 @AfterTest
//	     public void publishReports() {
//
//	    	 extentReport.flush();
//	        }
}
