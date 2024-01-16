package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser1;
import pom.PlacedOrderNMakePaymentPage;

public class PaymentTest extends BaseTest{

	PlacedOrderNMakePaymentPage PaymentPage;
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
		 PaymentPage = new PlacedOrderNMakePaymentPage(driver);
		 PaymentPage.clickOnLogInButton();
		 PaymentPage.enterMobileNoForOtp("8484982590");
		 PaymentPage.clickOnContinueButton(); 
		 PaymentPage.clickOnOtpSubmitButton();      
		 PaymentPage.enterIntoSearchTab("mobile");
		 PaymentPage.clickOnSearch();
		 PaymentPage.clickOnQuickView(driver, 0);
		 PaymentPage.clickOnBuyButton();
		 PaymentPage.clickProceedToChcekout();
		 PaymentPage.selectTitle();
		 PaymentPage.enterFirstName("Nikita");
		 PaymentPage.enterLastName("Patil");
		 PaymentPage.enterAddress("Dadawadi Jalgaon");
		 PaymentPage.enterLandMark("Jain Temple");
		 PaymentPage.enterPincode("425001");
		 PaymentPage.selectSate("Maharashtra");
		 PaymentPage.selectCity("JALGAON");
		 PaymentPage.enterMobileNo(driver,"8484982590");
		 PaymentPage.clickOnShipToThisAddress();
     
     
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
	



