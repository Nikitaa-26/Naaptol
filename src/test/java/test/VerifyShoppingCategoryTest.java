package test;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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
@Listeners(test.Listeners.class)
public class VerifyShoppingCategoryTest extends BaseTest{
//	ExtentReports extentReport;
//	ExtentTest Test;
//	NaaptolHomePage naaptolHomePage;

//	@Parameters ({"Browser"})
//	@BeforeTest
//	public void openApplication(String browser) {
//	  driver = LaunchBrowser.browser(browser);
//	}
	
	@BeforeTest
	public void openApplication() {
		driver = LaunchBrowser1.openBrowser();
	}
	
	@Test
	  public void verifyIfUserAbleToAccessShoppingCategories(WebDriver driver) {
	//   Test=extentReport.createTest("verifyIfUserAbleTOAccessShoppingCategories");
		 NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		 naaptolHomePage.clickOnShoppingCategory();
		 naaptolHomePage.selectShoppingCategory(driver, 3);
		 naaptolHomePage.getCategoryHeading();
		 String currentTitle = driver.getTitle();

//       Assert.assertEquals(naaptolHomePage.getCategoryHeading(),"Mobiles : Mobile Handsets");	  
         Assert.assertTrue(currentTitle.contains("Mobile Handset"));
	     
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