package pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.Keywords;


public class ProductPage {
	
	private static final Logger log = Logger.getLogger(ProductPage.class);

	
	Keywords keyword = new Keywords();
	
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']/descendant::button")
	WebElement BackPack;
	
	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']/descendant::button")
	WebElement bikeLight;
	
	@FindBy(css = "a.shopping_cart_link")
	WebElement cartOption;
	
	@FindBy(xpath = "//span[text()='Your Cart']")
	WebElement yourCartText;
	
	@FindBy(xpath = "//span[text()='Products']")
	WebElement productText;
	
	public ProductPage(){
		PageFactory.initElements(Keywords.driver, this);
	}
	
	public void clickOnBackPack() {
		BackPack.click();
	}
	
	public void clickOnBikeLight() {
		bikeLight.click();
	}
	
	public void clickOnCartOption() {

		Keywords.driver.executeScript(
		        "arguments[0].click();",
		        cartOption);
	}
	public void getYourCartText() {
		keyword.fluentWait("//span[text()='Your Cart']");
		String cartText = yourCartText.getText();
		
		Assert.assertEquals(cartText, "Your Cart");
	}
	
	public void waitForproductTextToBeVisible() {
		keyword.fluentWait("//span[text()='Products']");
	}
	

}
