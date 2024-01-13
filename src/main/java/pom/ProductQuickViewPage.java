package pom;

import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductQuickViewPage {

	 @FindBy (xpath = "//div[@id='square_Details']//h1")private WebElement productTitle;
	 @FindBy (xpath = "//span[@class='offer-price']//span[1]") private WebElement price;
	 @FindBy (xpath = "//span[@class='offer-price']//span[2]")private WebElement shippingCharges;
	 @FindBy (xpath = "//a[@id='cart-panel-button-0']") private WebElement buyButton;
	 @FindBy (xpath = "//a[@class='link_Continue']") private WebElement continueShopping;
//	 @FindBy (xpath = "//li[@class='head_UPrice']") private List<WebElement> unitPrice;
//	 @FindBy (xpath = "//li[@class='head_ship']") private List<WebElement> shippingPrice;
//	 @FindBy (xpath = "//li[@class='head_Amount']") private List<WebElement>orderAmt;
//	 @FindBy (xpath = "//span[@id='totalPayableAmount']")private WebElement totalAmt;
//	 
	 @FindBy (xpath = "//ul[@id='cartData']//li[3]")private List<WebElement> unitPrice;
	 @FindBy (xpath = "//ul[@id='cartData']//li[4]")private List<WebElement> shippingPrice;
	 @FindBy (xpath = "//ul[@id='cartData']//li[5]")private List<WebElement> orderAmount;
	 @FindBy (xpath = "(//ul[@id='cartTotal']//label)[1]") private WebElement totalAmount;
	
		public ProductQuickViewPage(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	 }
	 
	 public String getProductTitle() {
		return productTitle.getText();
	 }
	 public Double getProductPrice() {
		 return Double.parseDouble(price.getText());				 
	 }
	 public Double getShippingPrice() {
		String charges = shippingCharges.getText();
		String [] charge = charges.split(" ");
	//	System.out.println("charges");
		return Double.parseDouble(charge[1]);
	 }
	 public void clickOnBuyButton() {
		 buyButton.click();
	 }
	 public void clickOnContinueShopping() {
		 continueShopping.click();
	 }	 	 
	 public double getUnitPrice(int index) {
          return Double.parseDouble(unitPrice.get(index).getText().substring(3));		
	
	 }
	 public double getShippingPrice(int index) {
		 return Double.parseDouble(shippingPrice.get(index).getText().substring(3));
	 }
	 public double getOrderAmt(int index) {
	
		 return Double.parseDouble(orderAmount.get(index).getText());
	 }
	 public double getTotalAmt() {
		 return Double.parseDouble(totalAmount.getText().substring(3));
	  
	 }
	 
}
