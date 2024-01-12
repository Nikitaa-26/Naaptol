package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductQuickViewPage {

	 @FindBy (xpath = "//div[@id='square_Details']//h1")private WebElement productName;
	 @FindBy (xpath = "//span[@class='offer-price']//span[1]") private WebElement price;
	 @FindBy (xpath = "//span[@class='offer-price']//span[2]")private WebElement shippingCharges;
	 @FindBy (xpath = "//a[@id='cart-panel-button-0']") private WebElement buyButton;
	 @FindBy (xpath = "//a[@class='link_Continue']") private WebElement continueShopping;
	 @FindBy (xpath = "//div[@id='square_Details']") private WebElement square_Details;
	
	 
	 public ProductQuickViewPage(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	 }
	 
	 public String getProductName() {
		return productName.getText();
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
	 
}
