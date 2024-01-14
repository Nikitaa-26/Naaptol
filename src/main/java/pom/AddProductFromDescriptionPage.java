package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductFromDescriptionPage{

     @FindBy (xpath = "//a[@class='red_button icon chat']")private WebElement buy;
   
    
     public AddProductFromDescriptionPage(WebDriver driver) {
   	  PageFactory.initElements(driver,this);
     }
     
     public void clickOnBuyButton() {
   	  buy.click();
     }
    
     
}
