package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PlacedOrderNMakePaymentPage {
	 @FindBy (xpath = "//a[text()='Log In / Register']") private WebElement logIn;
	 @FindBy (xpath = "//input[@placeholder='Enter mobile number']") private WebElement mobileNumber;
	 @FindBy (xpath = "//input[@value='Continue']") private WebElement continueButton;
	 @FindBy (xpath = "//input[@value='Submit']") private WebElement submitOtp;
	 @FindBy (xpath = "//input[@id='header_search_text']")private WebElement searchTab;
	 @FindBy (xpath = "(//div[@class='search'])[2]")  private WebElement search;  
	 @FindBy (xpath = "//div[@class='grid_Square ']")private List<WebElement> products;
	 @FindBy (xpath = "//span[@id='header_search_shopping_cart_count']")private WebElement addToCart;
	 @FindBy (xpath = "//a[@class='bt_compare icon chat quickFancyBox']")private List<WebElement>quickView;
	 @FindBy (xpath = "//a[@id='cart-panel-button-0']") private WebElement buyButton;
	 @FindBy (xpath = "(//a[@onclick='cart.submitOrder()'])[1]") private WebElement proceedToChcekout;	
     @FindBy (xpath = "//select[@id='fktitle_id']") private WebElement title; 
     @FindBy (xpath = "//input[@name='firstName']") private WebElement firstName;
     @FindBy (xpath = "//input[@name='lastName']") private WebElement lastName;
     @FindBy (xpath = "//textarea[@id='address']") private WebElement addressArea;
     @FindBy (xpath = "//input[@name='landmark']") private WebElement landMark;
     @FindBy (xpath = "//input[@name='pincode']") private WebElement pinCode;
     @FindBy (xpath = "//select[@id='state']") private WebElement selectState;
     @FindBy (xpath = "/select[@id='city']") private WebElement selectCity;
     @FindBy (xpath = "//input[@id='mobile']") private WebElement mobileNo;
     @FindBy (xpath = "//span[text()=' Ship to This Address']") private WebElement address;
     @FindBy (xpath = "//label[text()='Cash On Delivery']") private WebElement cashOnDelivery;
     @FindBy (xpath = "//a[text()='Click here to Place Order']")  private WebElement placeOrder;
     
     public PlacedOrderNMakePaymentPage(WebDriver driver) {
    	 PageFactory.initElements(driver,this);
     } 
     
     public void clickOnLogInButton() {
    	 logIn.click();
     }
     public void enterMobileNoForOtp(String Number) {    	
    	 mobileNumber.sendKeys(Number);
     }
     public void clickOnContinueButton()  {   	
    	 continueButton.click();  	 
     }
     public void clickOnOtpSubmitButton() throws InterruptedException{
    	 Thread.sleep(30000);
    	 submitOtp.click();
     }
     public void enterIntoSearchTab(String productName) throws InterruptedException {
    	 Thread.sleep(3000);
    	 searchTab.sendKeys(productName);
     }
     public void clickOnSearch() {
    	 search.click();
     }
     public void clickOnAddToCart() {
    	 addToCart.click();
     }
     public void clickOnQuickView(WebDriver driver,int product) throws InterruptedException {
    	// Thread.sleep(4000);
    	 Actions actions=new Actions(driver);
		 actions.moveToElement(products.get(product));
		 actions.perform();
		 quickView.get(product).click();	
//    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
//    	 wait.until(ExpectedConditions.visibilityOf((WebElement) quickView));
    
     }
     public void clickOnBuyButton() {
    	 buyButton.click();
     }
     public void clickProceedToChcekout() {
    	 proceedToChcekout.click();
     }  
     public void selectTitle() {  	 
    	 Select Title = new Select(title);
    	 Title.selectByVisibleText("Miss.");   	
     }
     public void enterFirstName(String fname) {
    	 firstName.sendKeys(fname);
     }
     public void enterLastName(String lname) {
    	 lastName.sendKeys(lname);
     }
     public void enterAddress(String address) {
    	 addressArea.sendKeys(address);
     }
     public void enterLandMark(String landmark) {
    	 landMark.sendKeys(landmark);
     }
     public void enterPincode(String pincode) {
    	 pinCode.sendKeys(pincode);
     }
     public void selectSate(String State) {
    	 Select state = new Select(selectState);
         state.selectByVisibleText("MAHARASHTRA");	 
     }
     public void selectCity(String City) {
    	 Select city = new Select(selectCity);
    	 city.selectByVisibleText("JALGAON");
     }
     public void enterMobileNo(WebDriver driver,String number) throws InterruptedException {
         Thread.sleep(5000);
    //	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
    //	 wait.until(ExpectedConditions.visibilityOf(mobileNo ));
    	 mobileNo.sendKeys(number);
     }
     public void clickOnShipToThisAddress() {
    	 address.click();
     }
     public void selectCashOnDelivery() {
    	 cashOnDelivery.click();
     }
     public void clickOnPlacedOrder() {
    	 placeOrder.click();
     }
     
}
