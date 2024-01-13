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

public class NaaptolHomePage {
    @FindBy (xpath = "//a[text()='Log In / Register']") private WebElement logIn;
    @FindBy (xpath = "//a[text()='Track Order']")       private WebElement trackOrder;
    @FindBy (xpath = "//div[@class='cate_head']")       private WebElement shoppingCategories;
    @FindBy (xpath = "//ul[@id='mainMenu_UL']//li")     private List<WebElement> category;
    @FindBy (xpath = "(//a[text()='Mobile Handsets'])[1]")private WebElement mobileSubcategory;
    @FindBy (xpath = "(//li[@class='head'])[1]")        private WebElement categoryHeading;
    @FindBy (xpath = "//input[@id='header_search_text']")private WebElement searchTab;
    @FindBy (xpath = "(//div[@class='search'])[2]")      private WebElement search;    
    @FindBy (xpath = "//span[@id='header_search_shopping_cart_count']")private WebElement addToCart;
    
    public NaaptolHomePage(WebDriver driver) {
      PageFactory.initElements(driver,this);
    }
    
    public void  clickOnLogin() {
    	logIn.click();
    }
    public void clickOnTerackOrder() {
    	trackOrder.click();
    }
    public void clickOnShoppingCategory() {
    	shoppingCategories.click();
    }
    public void selectShoppingCategory(WebDriver driver,int index) {
    	Actions actions = new Actions(driver);
    	actions.moveToElement(category.get(index));
    	actions.perform();
    	mobileSubcategory.click();
    }
    public String getCategoryHeading() {
    	return categoryHeading.getText();
    }
    public void enterSearchTab(String product) {
    		searchTab.sendKeys(product);
    }   
    public void ClickOnSearch() {
    	search.click();
    }
    public void clickOnAddToCart() {
    	addToCart.click();
    }
}
