package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.Keywords;

public class CartPage {
	
	private static final Logger log = Logger.getLogger(CartPage.class);

	
	public CartPage(){
		PageFactory.initElements(Keywords.driver, this);
	}
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkOutOption;
	
	@FindBy (xpath= "//span[text()='Checkout: Your Information']")
	WebElement yourInfoText;
	
	@FindBy (xpath = "//button[@data-test='remove-sauce-labs-backpack']")
	WebElement removeBackPack;
	
	public void removeBackpack() {
		removeBackPack.click();
	}
	
	public void clickOnCheckout() {
		Keywords.driver.executeScript(
			    "arguments[0].click();",
			    checkOutOption
			);
		
	}
	
	public void getInfoText() {
		String getYourInfoText = yourInfoText.getText();
		log.info(getYourInfoText);
		Assert.assertEquals(getYourInfoText, "Checkout: Your Information");
	}

}
