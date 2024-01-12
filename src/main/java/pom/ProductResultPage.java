package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductResultPage extends BasePage{

		@FindBy (xpath= "//div[@class='grid_Square ']")private List<WebElement> products;
		@FindBy (xpath= "//a[@class='bt_compare icon chat quickFancyBox']")private List<WebElement>quickView;
	    @FindBy (xpath = "//div[@class='item_title']")private List<WebElement> productTitle;
	   
	    public ProductResultPage(WebDriver driver) {
		     PageFactory.initElements(driver, this);
        }	
	    public int getNumberOfproducts() {
		    return products.size();
	    }	     
	    public void clickOnQuickView(WebDriver driver,int product) {	
			Actions actions=new Actions(driver);
			actions.moveToElement(products.get(product));
			actions.perform();
			quickView.get(product).click();
	    }	    
	    public void clickOnProducts(int product) {
			products.get(product).click();
        }
	
	    public String getProductTitle(int product) {
	    	return productTitle.get(product).getText();
        }
//	    public String getProductHeading() {
//			return productHeading.getText();
//		}
//	    
//	    public void checkTheTitlesAreEqual() {
//	    	if(productTitle.contains(productHeading))
//			{
//				System.out.println("Titles are equal");
//			}
//	    	else
//	    	{
//	    		System.out.println("Titles are not equal");
//	    	}
 }


