package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser1;
import pom.AddProductFromDescriptionPage;
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

public class RemoveProductFromCart extends BaseTest{
//	ExtentReports extentReport;
//	ExtentTest Test;	 
	NaaptolHomePage naaptolHomePage;
	ProductResultPage productResultPage;
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
	@Test(priority=1)
    public void VerifyIfUserIsAbleToRemoveProdutFromCart() throws InterruptedException { 
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
	@Test(priority=2)
    public void VerifyIfUserIsAbleToRemoveMultileProdutFromCart() throws InterruptedException { 
    	//Test=extentReport.createTest("VerifyIfUserIsAbleToRemoveProdutFromCart");
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
		
      }

}
