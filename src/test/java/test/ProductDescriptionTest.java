package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
import pom.AddProductFromDescriptionPage;
import pom.NaaptolHomePage;
import pom.ProductResultPage;
@Listeners(test.Listeners.class)
public class ProductDescriptionTest extends BaseTest{
	ExtentReports extentReport;
	ExtentTest Test;
	NaaptolHomePage naaptolHomePage;
	ProductResultPage productResultPage;
	AddProductFromDescriptionPage addProductFromDescriptionPage;
	
	@Parameters ({"Browser"})
     @BeforeMethod
     public void openApplication(String browser) {
    	 driver = LaunchBrowser.browser(browser);    			 
     }
     
     @Test
     public void VerifyIfUserIsAbleToAddProductToCartFromProductDescriptionPage() {
    //	 Test=extentReport.createTest("VerifyIfUserIsAbleToAddProductToCartFromProductDescriptionPage");
    	 naaptolHomePage = new NaaptolHomePage(driver);
    	 naaptolHomePage.enterSearchTab("laptop");
    	 naaptolHomePage.ClickOnSearch();
    	 
    	 productResultPage =new ProductResultPage(driver);    	
    	 String productTitle = productResultPage.getProductTitle(1);
    	 productResultPage.clickOnProducts(1);
    	 productResultPage.switchToPage(driver,"productTitle");
    	
    	 addProductFromDescriptionPage = new AddProductFromDescriptionPage(driver);	 
    	 addProductFromDescriptionPage.clickOnBuyButton();	
     }
     
     @AfterMethod
 	public void addTestStatus(ITestResult result) {
 		
 		if(result.getStatus()==ITestResult.SUCCESS) {
 			
 			Test.log(Status.PASS, result.getName());
 		}
 		else if(result.getStatus()==ITestResult.FAILURE) {
 			
 			Test.log(Status.FAIL, result.getName());
 		}
 		else if(result.getStatus()==ITestResult.SKIP) {
 			
 			Test.log(Status.SKIP, result.getName());
 		}
     
 	}
 	
 	 @AfterTest
      public void publishReports() {

     	 extentReport.flush();
         }
}
