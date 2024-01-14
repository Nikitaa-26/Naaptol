package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser1;
import pom.PlacedOrderNMakePaymentPage;

public class PaymentTest extends BaseTest{

	PlacedOrderNMakePaymentPage makePaymentTest;
//	ExtentReports extentReport;
//	ExtentTest Test;	 

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
	public void placeOrder() throws InterruptedException {
	//   Test=extentReport.createTest("placeOrder");
		 makePaymentTest = new PlacedOrderNMakePaymentPage(driver);
	     makePaymentTest.clickOnLogInButton();
	     makePaymentTest.enterMobileNoForOtp("8484982590");
	     makePaymentTest.clickOnContinueButton(); 
	     makePaymentTest.clickOnOtpSubmitButton();      
	     makePaymentTest.enterIntoSearchTab("mobile");
	     makePaymentTest.clickOnSearch();
	     makePaymentTest.clickOnQuickView(driver, 0);
	     makePaymentTest.clickOnBuyButton();
	     makePaymentTest.clickProceedToChcekout();
	     makePaymentTest.selectTitle();
	     makePaymentTest.enterFirstName("Nikita");
	     makePaymentTest.enterLastName("Patil");
	     makePaymentTest.enterAddress("Dadawadi Jalgaon");
	     makePaymentTest.enterLandMark("Jain Temple");
	     makePaymentTest.enterPincode("425001");
	     makePaymentTest.selectSate("Maharashtra");
	     makePaymentTest.selectCity("JALGAON");
	     makePaymentTest.enterMobileNo(driver,"8484982590");
	     makePaymentTest.clickOnShipToThisAddress();
     
     
// 	@AfterMethod
// 	public void addTestStatus(ITestResult result) {
// 		
// 		if(result.getStatus()==ITestResult.SUCCESS) {
// 			
// 			Test.log(Status.PASS, result.getName());
// 		}
// 		else if(result.getStatus()==ITestResult.FAILURE) {
// 			
// 			Test.log(Status.FAIL, result.getName());
// 		}
// 		else if(result.getStatus()==ITestResult.SKIP) {
// 			
// 			Test.log(Status.SKIP, result.getName());
// 		}
//    
// 	}
 	
// 	 @AfterTest
//      public void publishReports() {
// 
//     	 extentReport.flush();
//         }
	     
 }
}
	



